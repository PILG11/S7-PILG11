#!/bin/bash

IP=$(hostname -I | awk '{print $2}')
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_backup.log"
DEBIAN_FRONTEND="noninteractive"

echo "START - reverse-proxy Server "$IP

echo "=> [1]: Installing required packages..."
apt-get update $APT_OPT \
  >> $LOG_FILE 2>&1

apt-get install $APT_OPT \
  nginx \
  >> $LOG_FILE 2>&1

echo "=> [2]: NGINX Configuration"
echo "upstream backend_apache {
    server 192.168.56.80;
}

server {
    listen    80;
    server_name    www.les-logis-de-beaulieu.com;
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