# Projet Infrastructure et Logiciels

Dépôt opérationnel "Ops" pour les étudiants Cloud, System & Sécurité (CSS) de ESEO Angers (2022-2023):

## Overview 

Les fichiers d'injections SQL pour la DB sont dans le répertoire `files/`  
Les scripts BASH utilisées pour configurer les VMs sont dans le répertoire `scripts/`

Fichiers et répertoires spécifiques :

* ``./Vagrantfile`` : qui contient l'ensemble des déclarations pour la construction du Labs
* ``scripts/install_sys.sh`` : mise en place des configurations de base sur toutes les VMs
* ``scripts/install_bdd.sh`` : Mise en place de la base de données mysql
* ``scripts/install_moodle.sh`` : Mise en place de l'application Moodle
* ``scripts/install_myadmin.sh`` : Mise en place de l'application PhpMyAdmin
* ``scripts/install_web.sh`` : Mise en place du serveur Apache2

## Description du Labs

Les machines sont reliées à votre machine réelle par un réseau privé hôte via l'adresse 192.168.56.80

* L'application Moodle est accéssible par l'adresse <http://192.168.56.80/moodle>
* L'application PhpMyAdmin est accéssible par l'adresse <http://192.168.56.80/myadmin>

## Utilisation des commandes vagrant

Activer une VM uniquement (srv-web par exemple)
    ```vagrant up srv-web```

Se connecter à une VM (firewall par exemple)
    ```vagrant ssh srv-web```

Arréter une VM (victime par exemple)
    ```vagrant halt srv-web```

Détruire toutes les VMs (sans demande de confirmation)
    ```vagrant destroy -f```
