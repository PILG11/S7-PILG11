# Projet Infrastructure et Logiciels

Dépôt production "prod" pour le client Les Logis de Beaulieu.  
Pour suivre les versions du projet l'onglet [releases](https://github.com/PILG11/S7-PILG11/releases) est disponible.  


### Overview 

Le site web est situé dans le répertoire `Website/`.  
L'application java est situé dans le répertoire `Java/`.  
L'infra est construite autour de 4 VMs suivant ce diagramme :  

<img width="871" alt="Capture d’écran 2023-01-19 à 20 21 13" src="https://user-images.githubusercontent.com/120210590/213539880-bc2b6596-0cae-4895-a8d0-446aa96c72b0.png">


### Description du Projet

Les machines sont reliées à la machine réelle par un réseau privé hôte

* Afin de monter l'infrastructure il est nécessaire d'exécuter la commande ```vagrant up``` puis d'attendre environ 12 minutes  

* Le site web est accéssible via une adresse IP publique

* L'application java est accessible sur ce répertoire et exécutable via le fichier `Java/GestionSite.java`  


### Commandes Vagrant utiles  

Activer toutes les VMs.  
    ```vagrant up```
    
Lancer les scripts de provision sur une VM (reverse-proxy par exemple).   
    ```vagrant provision reverse-proxy```

Se connecter à une VM (web1 par exemple).   
    ```vagrant ssh web1```

Arréter une VM (db par exemple).   
    ```vagrant halt db```

Détruire toutes les VMs (sans demande de confirmation).   
    ```vagrant destroy -f```
    
### [GitHub Actions](https://github.com/PILG11/S7-PILG11/actions)

Dans ce dépôt, les actions sont utilisées pour exécuter les commandes ```aws s3 list``` automatiquement ou manuellement. 

Vous pouvez en effet utilisé le bouton "Run workflow" pour lancer la lecture des backups présents sur le bucket S3 AWS du projet. 

<img width="1079" alt="Capture d’écran 2023-01-19 à 20 31 15" src="https://user-images.githubusercontent.com/120210590/213541806-ccfc7f6a-07f4-4251-b4d5-c2fed26bb0ba.png">

Vous devriez obtenir un résumé des backups présents sur le cloud AWS comme l'image suivante :  

<img width="1070" alt="Capture d’écran 2023-01-23 à 21 29 46" src="https://user-images.githubusercontent.com/120210590/214143307-163c605d-2359-4034-9ffc-29bcaef970e7.png">

Signification de la liste :  

```diff     
+       2023-01-23 19:35:07    8.9  KiB   test-23.01.2023_20h35-gite.sql
=       [Date/Heure d'upload]  [Taille]   [Nom du backup fichier SQL]    
```

