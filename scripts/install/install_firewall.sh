#!/bin/bash

LOG_FILE="/vagrant/logs/install_firewall.log"

# IP du reverse-proxy
PROXY_IP="192.168.56.82"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"

source $ALL_CONF_FILE

echo "START - install firewall - "$IP

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

# Autoriser les connexions entrantes depuis l'IP du reverse-proxy
iptables -A INPUT -s $PROXY_IP -j ACCEPT \
>> $LOG_FILE 2>&1

# Autoriser les connexions SSH entrantes
iptables -A INPUT -p tcp --dport 22 -j ACCEPT \
>> $LOG_FILE 2>&1

echo "=> [3]: Saves iptables rules"
# Enregistrer les règles du firewall
iptables-save \
>> $LOG_FILE 2>&1