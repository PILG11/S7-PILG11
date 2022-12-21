<?php

    echo '<p> Hello </p>';

    error_reporting(E_ALL);
    ini_set('display_errors', 'On');
    ini_set('display_startup_errors', 'On');


    $user = 'root';
    $password = 'root';
    $db = 'gite';
    $host = 'localhost';
    $port = 8889;

    $link = mysqli_init();
    $success = mysqli_real_connect($link,$host,$user,$password,$db,$port);

    $infoBdd = [
        'server' => 'localhost',
        'login' => 'root',
        'password' => 'root',
        'db_name' => 'gite',
    ];
    
    $mysqli = new mysqli($infoBdd['server'], $infoBdd['login'],
                            $infoBdd['password'],$infoBdd['db_name'],8889);
    if ($mysqli->connect_errno) {
     exit("Problème de connexion à la BDD");
    }

    $result = $mysqli->query("INSERT INTO `actualites` (`Id`,`Nom`,`Description`) 
                            VALUES (2,'Mariage', 'Premier mariage Champetre');");

?>