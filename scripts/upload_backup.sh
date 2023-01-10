DATE=$(date +"%d.%m.%Y_%Hh%M")
DB_NAME="gite"
DB_USER="admin"
DB_PASSWD="mdpgite"

BACKUP_FILE="/vagrant/backups"
BACKUP_NAME="$DATE-$DB_NAME"

#Dump actual database
mysqldump --force --opt --user=$DB_USER -p$DB_PASSWD --skip-lock-tables --events --databases $DB_NAME > "$BACKUP_FILE/$BACKUP_NAME.sql"

#Upload database file to AWS
aws s3 cp "$BACKUP_FILE/$BACKUP_NAME.sql" s3://pilg11-db-backup/