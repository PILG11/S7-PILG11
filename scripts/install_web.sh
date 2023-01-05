#!/bin/bash

## install web server with php

IP=$(hostname -I | awk '{print $2}')

APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
LOG_FILE="/vagrant/logs/install_web.log"
DEBIAN_FRONTEND="noninteractive"

echo "START - install web Server - "$IP

echo "=> [1]: Installing required packages..."
apt-get install $APT_OPT \
  apache2 \
  libapache2-mod-rpaf \
  php \
  libapache2-mod-php \
  php-mysql \
  php-intl \
  php-curl \
  php-xmlrpc \
  php-soap \
  php-gd \
  php-json \
  php-cli \
  php-pear \
  php-xsl \
  php-zip \
  php-mbstring \
>> $LOG_FILE 2>&1

echo "=> [2]: Apache2 configuration"
# Add configuration of /etc/apache2
sudo cp -r /vagrant/Website /var/www/html/les-logis-de-beaulieu

# Attribue les bonnes permissions au répertoire
sudo chmod -R 755 /var/www/html/les-logis-de-beaulieu

# Crée un fichier de configuration Apache pour votre site web
sudo touch /etc/apache2/sites-available/les-logis-de-beaulieu.conf

# Ajoute la configuration suivante au fichier de configuration Apache
echo "<VirtualHost *:80>
  ServerAdmin webmaster@localhost
  DocumentRoot /var/www/html/les-logis-de-beaulieu
  ErrorLog \${APACHE_LOG_DIR}/error.les-logis-de-beaulieu.log
  CustomLog \${APACHE_LOG_DIR}/access.les-logis-de-beaulieu.log combined
</VirtualHost>
" | sudo tee /etc/apache2/sites-available/les-logis-de-beaulieu.conf

# Active le site web
sudo a2dissite 000-default.conf
sudo systemctl restart apache2
sudo a2ensite les-logis-de-beaulieu.conf

# Redémarre Apache pour prendre en compte les changements
sudo systemctl restart apache2
sudo systemctl status apache2
echo "END - install web Server"

