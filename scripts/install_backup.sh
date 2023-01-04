#!/bin/bash

IP=$(hostname -I | awk '{print $2}')
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_backup.log"
DEBIAN_FRONTEND="noninteractive"

DATE=$(date +"%d.%m.%Y_%Hh%M")
DB_NAME="gite"
DB_USER="admin"
DB_PASSWD="mdpgite"

BACKUP_FILE="/vagrant/backups"
BACKUP_NAME="$DATE-$DB_NAME"

# Les fichiers backups seront gardés 1h
RETENTION=60

echo "START - Database backup "$IP

echo "=> [1]: Installing required packages..."
apt-get update $APT_OPT \
  >> $LOG_FILE 2>&1

apt-get install $APT_OPT \
  curl \
  >> $LOG_FILE 2>&1

echo "=> [2]: Retrieving the database and storing it"
mkdir -p $BACKUP_FILE

# Dumb the database
mysqldump --force --opt --user=$DB_USER -p$DB_PASSWD --skip-lock-tables --events --databases $DB_NAME > "$BACKUP_FILE/$BACKUP_NAME.sql"

# Remove files older than X days
find $BACKUP_FILE/* -mmin +$RETENTION -delete

echo "END - Database backup completed successfully "$IP