#!/bin/bash

## install base system
## [JCG] creation d'un script system de base commun à toutes les VMS


LOG_FILE="/vagrant/logs/install_sys.log"

#Fichier config all
ALL_CONF_FILE="/vagrant/scripts/config/config_all.sh"

source $ALL_CONF_FILE

echo "START - Install Base System on "$IP

echo "=> [1]: Installing required packages..."
apt-get update $APT_OPT \
  >> $LOG_FILE 2>&1

apt-get install $APT_OPT \
  wget \
  gnupg \
  unzip \
  >> $LOG_FILE 2>&1

echo "=> [2]: Server configuration"
# Ajout de contrib et non-free pour les depots
sed -i 's/main/main contrib non-free/g' /etc/apt/sources.list
# Ajout de la ligne pour le proxy ESEO mais descativé par défaut
echo "#Acquire::http::Proxy \"http://scully.eseo.fr:9999\";" >> /etc/apt/apt.conf

/usr/bin/localectl set-keymap fr

echo "END - Install Base System on "$IP
