#Variable pour déchiffrage
GPG_PASSPHRASE="pilg11projet"
GPG_KEY_FILE="/vagrant/data/gnupg/key.asc"
GPG_FILE="/vagrant/data/gnupg/config.sh.gpg"
#Variable pour config AWS
AWS_FILE="/vagrant/data/gnupg/config.sh"

#Déchiffrage script config AWS
echo "=> [3]: Récupération du fichier conf chiffré"
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE --import $GPG_KEY_FILE
sudo gpg --batch --yes --passphrase $GPG_PASSPHRASE $GPG_FILE

#Récupération last database and download
echo "=> [4]: Récupération de la dernière version de database stocké sur AWS en backup"

echo "=> [4.1]: Config AWS credentials"
source $AWS_FILE
aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID
aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
aws configure set default.region $AWS_REGION

echo "=> [4.2]: Verification identité"
aws sts get-caller-identity