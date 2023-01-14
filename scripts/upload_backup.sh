DATE=$(date +"%d.%m.%Y_%Hh%M")
#Fichier config DB
DB_CONF_FILE="/vagrant/scripts/config/config_db.sh"

source $DB_CONF_FILE
BACKUP_FILE="/vagrant/backups"
BACKUP_NAME="$DATE-$DB_NAME"

AWS_CONF_FILE="/vagrant/scripts/config/config_aws.sh"

#Dump actual database
mysqldump --force --opt --user=$DB_USER -p$DB_PASSWD --skip-lock-tables --events --databases $DB_NAME > "$BACKUP_FILE/$BACKUP_NAME.sql"

#Config AWS credentials
bash $AWS_CONF_FILE

#Upload database file to AWS
aws s3 cp "$BACKUP_FILE/$BACKUP_NAME.sql" s3://pilg11-db-backup/