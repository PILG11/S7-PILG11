# Projet Infrastructure et Logiciels

Dépôt développement "dev" pour les étudiants Logiciel et Données (LD) de ESEO Angers (2022-2023).

## Overview 

Les fichiers d'injections SQL pour la DB sont dans le répertoire `DB/`  
L'application java est situé dans `Java/`  
Le code du site web est situé dans `Website/` 

Fichiers et répertoires spécifiques :

* ``/Website/img/``: contient toutes les images utilisées sur le site.  

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
