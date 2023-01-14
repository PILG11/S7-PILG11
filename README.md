# Projet Infrastructure et Logiciels

Dépôt production "prod" pour le client Les Logis de Beaulieu.  

## Overview 

Le site web est dans `Website/`.  
L'infra est pour l'instant celle de base.  

## Description du Labs

Les machines sont reliées à votre machine réelle par un réseau privé hôte

* Le site web est accéssible par l'adresse <http://192.168.56.82>


Activer toutes les VMs
    ```vagrant up```

Se connecter à une VM (web par exemple)
    ```vagrant ssh web```

Arréter une VM (db par exemple)
    ```vagrant halt db```

Détruire toutes les VMs (sans demande de confirmation)
    ```vagrant destroy -f```
