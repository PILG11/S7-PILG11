<?php

    echo '<p> Hello </p>';

    error_reporting(E_ALL);
    ini_set('display_errors', 'On');
    ini_set('display_startup_errors', 'On');


    $user = 'admin';
    $password = 'mdpgite';
    $db = 'gite';
    $host = '192.168.56.81';
    $port = 3306;

    $link = mysqli_init();
    $success = mysqli_real_connect($link,$host,$user,$password,$db,$port);

    $infoBdd = [
        'server' => '192.168.56.81',
        'login' => 'admin',
        'password' => 'mdpgite',
        'db_name' => 'gite',
    ];
    
    $mysqli = new mysqli($infoBdd['server'], $infoBdd['login'],
                            $infoBdd['password'],$infoBdd['db_name'],3306);
    if ($mysqli->connect_errno) {
     exit("Problème de connexion à la BDD");
    }

    $result = $mysqli->query("INSERT INTO `Actualites` (`Id`,`Nom`,`Description`) 
                            VALUES (2,'Mariage', 'Premier mariage Champetre');");
