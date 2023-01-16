<?php 

include_once 'core.php';

$result = $mysqli->query("SELECT nom, prenom, commentaire, note FROM avis");

    include_once 'core.php';

    if(!$result) {
        exit($mysqli->error);
    }
    else{
        $row = $result->fetch_assoc();
    }

    ?>
        <div class="post">
            <button onclick="defilement_gauche()"><img class="scrollButton" src="../img/icon/fleche_gauche.png" alt="bouton gauche"></button>
            <div class="avisContainer">
                <div  src=<?php if ($row['nom'] != NULL) {
                    echo $row['nom'];
                    echo $row['prenom']; 
                    echo $row['commentaire'];
                    echo $row['note'];}?> class="avis" name=<?php if($row['nom'] != NULL){ echo "avis_post";}?>>              
            </div>
            <button onclick="defilement_droite()"><img class="scrollButton" src="../img/icon/fleche_droite.png" alt="bouton droite"></button>
        </div>
    <?php

?>