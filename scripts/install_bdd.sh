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

echo "START - install MariaDB - "$IP

echo "=> [1]: Install required packages ..."
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get install $APT_OPT \
	mariadb-server \
	mariadb-client \
   >> $LOG_FILE 2>&1

echo "=> [2]: Configuration du service"
if [ -n "$DB_NAME" ] && [ -n "$DB_USER" ] && [ -n "$DB_PASSWD" ] ;then
  mysql -e "CREATE DATABASE $DB_NAME" \
  >> $LOG_FILE 2>&1
  mysql -e "grant all privileges on $DB_NAME.* to '$DB_USER'@'%' identified by '$DB_PASSWD'" \
  >> $LOG_FILE 2>&1
  echo "BDD CREER ET PRIVILEGES DONNEES"
fi

echo "=> [3]: Configuration de BDD"
if [ -n "$DB_FILE" ] ;then
  mysql -u $DB_USER --password=$DB_PASSWD < /vagrant/$DB_FILE \
  >> $LOG_FILE 2>&1
  echo "FICHIER SQL INJECTE"
fi

echo "=> [4] Ouverture ecoute du serveur à tous et restart"
sed -i "s|bind-address            = 127.0.0.1|bind-address            = 0.0.0.0|" \
  /etc/mysql/mariadb.conf.d/50-server.cnf

service mariadb restart


echo "END - install MariaDB"
