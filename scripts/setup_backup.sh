#!/bin/bash

IP=$(hostname -I | awk '{print $2}')
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_backup.log"
DEBIAN_FRONTEND="noninteractive"

BACKUP_FILE="/vagrant/backups"
#Fichier config AWS
AWS_CONF_FILE="/vagrant/scripts/config/config_aws.sh"

# Les fichiers backups seront gardés 1h
RETENTION=60

echo "START - Database backup "$IP

echo "=> [1]: Install required packages ..."
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get install $APT_OPT \
  cron \
  >> $LOG_FILE 2>&1

echo "=> [2]: Retrieving the database and storing it"
mkdir -p $BACKUP_FILE
sed -i -e 's/\r$//' /vagrant/scripts/upload_backup.sh
echo "*/5 * * * * bash /vagrant/scripts/upload_backup.sh" | crontab -

# Remove files older than X days
find $BACKUP_FILE/* -mmin +$RETENTION -delete
echo "END - Database backup completed successfully "$IP