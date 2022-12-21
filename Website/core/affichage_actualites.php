<?php 

include_once 'core.php';

$result = $mysqli->query("SELECT * FROM `actualites`");

// var_dump($result);

if(!$result) {
    exit($mysqli->error);
}
else{
    $row = $result->fetch_assoc();
    var_dump($row);
    $nb = $result->num_rows;
    while($row != NULL){
        $post = $row['Id'];
        while($post == $row['Id']){
            echo '<p>'.$row['Nom'].'</p>';
            echo '<p>'.$row['Description'].'</p>';
            echo '<p>'.$row['PremiereImage'].'</p>';
            $row = $result->fetch_assoc();
        }
    }
}

?>