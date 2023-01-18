#!/bin/bash

## install Mariadb server (ex Mysql))

LOG_FILE="/vagrant/logs/install_bdd.log"
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"

#Variable pour déchiffrage
GPG_PASSPHRASE="pilg11projet"
GPG_KEY_FILE="/vagrant/data/gnupg/key.asc"
GPG_FILE="/vagrant/data/gnupg/config.sh.gpg"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"
#Fichier config DB
DB_CONF_FILE="/vagrant/scripts/config/config_db.sh"
#Fichier config AWS
AWS_CONF_FILE="/vagrant/scripts/config/config_aws.sh"
#Variable pour config AWS
AWS_FILE="/vagrant/data/gnupg/config.sh"

source $DB_CONF_FILE
source $ALL_CONF_FILE

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
fi

#Déchiffrage script config AWS
echo "=> [3]: Récupération du fichier conf chiffré"
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE --import $GPG_KEY_FILE \
>> $LOG_FILE 2>&1
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE $GPG_FILE \
>> $LOG_FILE 2>&1 

source $AWS_FILE
echo "=> [4]: Config AWS identity"
bash $AWS_CONF_FILE \
>> $LOG_FILE 2>&1 

echo "=> [5]: Récupération dernière sauvegarde database sur aws"
# Store the name of the latest file in a variable
LATEST_FILE=$(aws s3 ls $AWS_S3_BUCKET | sort | tail -n 1 | awk '{print $4}')

# Use the variable in the aws s3 cp command to download and rename database
aws s3 cp $AWS_S3_BUCKET/$LATEST_FILE $DB_FILE \
>> $LOG_FILE 2>&1 

echo "=> [6]: Configuration de la database"
if [ -n "$DB_FILE" ] ;then
  mysql -u $DB_USER --password=$DB_PASSWD < $DB_FILE \
  >> $LOG_FILE 2>&1
fi

echo "=> [7] Ouverture ecoute du serveur à tous et restart"
sed -i "s|bind-address            = 127.0.0.1|bind-address            = 0.0.0.0|" \
  /etc/mysql/mariadb.conf.d/50-server.cnf

service mariadb restart


echo "END - install MariaDB"
