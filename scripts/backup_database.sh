#!/bin/bash

IP=$(hostname -I | awk '{print $2}')
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_sauvegarde.log"
DEBIAN_FRONTEND="noninteractive"

DATE=$(date +"%d.%m.%Y_%Hh%M")
PHPMYADMIN_URL=http://192.168.56.80/myadmin
DB_NAME="gite"
DB_USER="admin"
DB_PASSWD="mdpgite"

BACKUP_FILE="/vagrant/backups"

# Nombre de jours à garder les dossiers (seront effacés après X jours)
RETENTION=14

echo "START - Database backup "$IP

echo "=> [1]: Installing required packages..."
apt-get update $APT_OPT \
  >> $LOG_FILE 2>&1

apt-get install $APT_OPT \
  cron \
  curl \
  >> $LOG_FILE 2>&1

echo "=> [2]: Retrieving the database and storing it"
# Créer un dossier de sauvegarde s'il n'existe pas déjà
mkdir -p $BACKUP_FILE/$DATE

# Dumb the database and gzip the .sql file
mysqldump --force --opt --user=$DB_USER -p$DB_PASSWD --skip-lock-tables --events --databases $DB_NAME > "$BACKUP_FILE/$DATE/$DB_NAME.sql"

# Remove files older than X days
find $BACKUP_FILE/* -mtime +$RETENTION -delete

# Récupérer la base de données à partir de PHPMyAdmin et enregistrer le fichier de sauvegarde dans le dossier de sauvegarde
#curl --silent "$PHPMYADMIN_URL/export.php?db=$DB_NAME&server=1&format=sql&username=$DB_USER&password=$DB_PASSWD" -o "$BACKUP_FILE/database_backup_$(date +\%R \%d/\%m/\%Y).sql"
# Configurer une tâche cron pour exécuter ce script tous les jours
echo "0 0 * * * root scripts/backup_database.sh" > /etc/cron.d/database_backup
# Redémarrer cron pour prendre en compte la nouvelle tâche
service cron restart

# Copier la sauvegarde sur GitHub tous les jours à 1h du matin
#echo "0 1 * * * root cd /root/backups && git add . && git commit -m 'Sauvegarde de la base de données $(date)'" >> /etc/cron.d/database-backup
#echo "0 1 * * * root cd /root/backups && git push origin master" >> /etc/cron.d/database-backup

echo "END - Database backup completed successfully "$IP