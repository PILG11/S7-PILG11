#!/bin/bash

LOG_FILE="/vagrant/logs/install_backup.log"
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"

BACKUP_FILE="/vagrant/backups"
#Fichier config AWS
AWS_CONF_FILE="/vagrant/scripts/config/config_aws.sh"

source $ALL_CONF_FILE

echo "START - Database backup setup "$IP

echo "=> [1]: Install required packages ..."
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get install $APT_OPT \
  cron \
  >> $LOG_FILE 2>&1

echo "=> [2]: Retrieving the database and storing it"
mkdir -p $BACKUP_FILE

echo "*/5 * * * * bash /vagrant/scripts/upload_backup.sh" | crontab -

sudo systemctl cron restart

echo "END - Setup of database backup completed successfully "$IP