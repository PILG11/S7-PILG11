#!/bin/bash

# IP de la VM web
WEB_IP="192.168.56.80"

# IP du reverse-proxy
PROXY_IP="192.168.56.82"

# Installer iptables
apt-get install iptables -y

# Bloquer toutes les connexions entrantes
iptables -P INPUT DROP

# Autoriser les connexions sortantes
iptables -P OUTPUT ACCEPT

# Autoriser les connexions entrantes établies et les connexions relatives
iptables -A INPUT -m conntrack --ctstate RELATED,ESTABLISHED -j ACCEPT

# Autoriser les connexions entrantes depuis l'IP du reverse-proxy
iptables -A INPUT -s $PROXY_IP -j ACCEPT

# Autoriser les connexions SSH entrantes
iptables -A INPUT -p tcp --dport 22 -j ACCEPT

# Enregistrer les règles du firewall
iptables-save