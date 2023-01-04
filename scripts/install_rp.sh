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
# Créer un fichier de configuration NGINX pour le reverse-proxy
cat > /etc/nginx/conf.d/reverse-proxy.conf << EOF
http {
    # ...
    include /etc/nginx/proxy_params;
    # ...
}

server {
    listen 80;
    server_name 192.168.56.82;

    location / {
        proxy_pass http://192.168.56.82;
        # ...
    }
}

upstream backend {
    server backend1.example.com;
    server backend2.example.com;
    # ...
}
EOF

# Redémarrer NGINX pour appliquer les changements de configuration
sudo service nginx restart

echo "END - Install reverse-proxy Server "$IP