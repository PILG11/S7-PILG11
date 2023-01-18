#!/bin/bash


LOG_FILE="/vagrant/logs/install_rp.log"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"

source $ALL_CONF_FILE

echo "START - reverse-proxy Server "$IP

echo "=> [1]: Installing required packages..."
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get update $APT_OPT \
  >> $LOG_FILE 2>&1

apt-get install $APT_OPT \
  nginx \
  libnss3-tools \
  >> $LOG_FILE 2>&1

echo "=> [2]: Protocol SSL Configuration"
wget https://github.com/FiloSottile/mkcert/releases/download/v1.4.3/mkcert-v1.4.3-linux-amd64 \
>> $LOG_FILE 2>&1
sudo mv mkcert-v1.4.3-linux-amd64 /usr/bin/mkcert
sudo chmod +x /usr/bin/mkcert

mkcert -install les-logis-de-beaulieu.com 192.168.56.82 localhost \
>> $LOG_FILE 2>&1

sudo mv ./les-logis-de-beaulieu.com+2.pem /etc/ssl/certs/
sudo mv ./les-logis-de-beaulieu.com+2-key.pem /etc/ssl/private/

echo "=> [3]: NGINX Configuration"
echo "upstream backend_apache {
    #requête envoyée au serveur avec le moins de connexions actives
    least_conn;
    server 192.168.56.82 fail_timeout=5s;
    server 192.168.56.83 fail_timeout=5s;
}

server {
    listen    80;
    server_name    www.les-logis-de-beaulieu.com;
    root /var/www/html/les-logis-de-beaulieu;

    return 301 https://\$host\$request_uri;
}

server {
    listen 443 ssl;

    ssl_certificate /etc/ssl/certs/les-logis-de-beaulieu.com+2.pem;
    ssl_certificate_key /etc/ssl/private/les-logis-de-beaulieu.com+2-key.pem;

    root /var/www/html/les-logis-de-beaulieu;

    location / {
        include proxy_params;
        proxy_pass http://backend_apache;
    }
}" >> /etc/nginx/sites-available/les-logis-de-beaulieu.conf

sudo rm /etc/nginx/sites-enabled/default
sudo ln -s /etc/nginx/sites-available/les-logis-de-beaulieu.conf /etc/nginx/sites-enabled/les-logis-de-beaulieu.conf
sudo systemctl restart nginx

echo "END - Install reverse-proxy Server "$IP