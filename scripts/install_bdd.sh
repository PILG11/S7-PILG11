#!/bin/bash

## install Mariadb server (ex Mysql))

IP=$(hostname -I | awk '{print $2}')
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_bdd.log"
DEBIAN_FRONTEND="noninteractive"

#Utilisateur a créer (si un vide alors pas de création)
DB_NAME="gite"
DB_USER="admin"
DB_PASSWD="mdpgite"
#Fichier sql à injecter (présent dans un sous répertoire)
DB_FILE="files/database.sql"
#Fichier accès bucket
GPG_PASSPHRASE="pilg11projet"
GPG_KEY_FILE="/vagrant/data/gnupg/key.asc"
GPG_FILE="/vagrant/data/gnupg/config.sh.gpg"
AWS_FILE="/vagrant/data/gnupg/config.sh"


echo "START - install MariaDB - "$IP

echo "=> [1]: Install required packages ..."
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get install $APT_OPT \
	mariadb-server \
  awscli \
  gnupg \
   >> $LOG_FILE 2>&1

echo "=> [2]: Configuration du service"
if [ -n "$DB_NAME" ] && [ -n "$DB_USER" ] && [ -n "$DB_PASSWD" ] ;then
  mysql -e "CREATE DATABASE $DB_NAME" \
  >> $LOG_FILE 2>&1
  mysql -e "grant all privileges on $DB_NAME.* to '$DB_USER'@'%' identified by '$DB_PASSWD'" \
  >> $LOG_FILE 2>&1
  echo "BDD CREER ET PRIVILEGES DONNEES"
fi

echo "=> [3]: Récupération du fichier conf chiffré"
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE --import $GPG_KEY_FILE
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE $GPG_FILE

echo "=> [4]: Récupération de la dernière version de database stocké sur AWS en backup"

echo "=> [4.1]: Config AWS credentials"
source $AWS_FILE
aws configure set aws_access_key_id "$AWS_ACCESS_KEY_ID"
aws configure set aws_secret_access_key "$AWS_SECRET_ACCESS_KEY"
aws configure set default.region "$AWS_REGION"
echo "=> [4.2]: Verification identité"
aws sts get-caller-identity

echo "=> [4.3]: Récupération dernière sauvegarde database sur aws"
# Store the name of the latest file in a variable
LATEST_FILE=$(aws s3 ls $AWS_S3_BUCKET | sort | tail -n 1 | awk '{print $4}')

# Use the variable in the aws s3 cp command to download and rename database
aws s3 cp $AWS_S3_BUCKET/$LATEST_FILE  /vagrant/files/database.sql

echo "=> [5]: Configuration de la database"
if [ -n "$DB_FILE" ] ;then
  mysql -u $DB_USER --password=$DB_PASSWD < /vagrant/$DB_FILE \
  >> $LOG_FILE 2>&1
  echo "FICHIER SQL INJECTE"
fi

echo "=> [5] Ouverture ecoute du serveur à tous et restart"
sed -i "s|bind-address            = 127.0.0.1|bind-address            = 0.0.0.0|" \
  /etc/mysql/mariadb.conf.d/50-server.cnf

service mariadb restart


echo "END - install MariaDB"
