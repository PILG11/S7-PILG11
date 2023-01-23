#!/bin/bash

LOG_FILE="/vagrant/logs/install_firewall.log"
APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"

# IP des VM web
WEB1_IP="192.168.56.82"
WEB2_IP="192.168.56.83"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"

source $ALL_CONF_FILE

echo "START - Install firewall on - "$IP

echo "=> [1]: Installing required packages..."
# Installer iptables
DEBIAN_FRONTEND=$DEBIAN_FRONTEND
apt-get install iptables -y \
>> $LOG_FILE 2>&1

echo "=> [2]: Setup all connexions..."
# Bloquer toutes les connexions entrantes
iptables -P INPUT DROP \
>> $LOG_FILE 2>&1

# Autoriser les connexions sortantes
iptables -P OUTPUT ACCEPT \
>> $LOG_FILE 2>&1

# Autoriser les connexions entrantes établies et les connexions relatives
iptables -A INPUT -m conntrack --ctstate RELATED,ESTABLISHED -j ACCEPT \
>> $LOG_FILE 2>&1

# Autoriser les connexions entrantes depuis l'IP de la VM web1
iptables -A INPUT -s $WEB1_IP -j ACCEPT \
>> $LOG_FILE 2>&1

# Autoriser les connexions entrantes depuis l'IP de la VM web2
iptables -A INPUT -s $WEB2_IP -j ACCEPT \
>> $LOG_FILE 2>&1

# Autoriser les connexions entrantes local sur le port 3306 (pour app JAVA)
iptables -A INPUT -p tcp -m tcp --dport 3306 -j ACCEPT

echo "=> [3]: Saves iptables rules"
# Enregistrer les règles du firewall
iptables-save \
>> $LOG_FILE 2>&1

echo "END - Configuration firewall VM db"