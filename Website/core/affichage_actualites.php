<?php 

$num_post = $_GET['post'];

if($num_post == NULL){

include_once 'core.php';

$result = $mysqli->query("SELECT * FROM `Actualites`");

if(!$result) {
    exit($mysqli->error);
}
else{
    $row = $result->fetch_assoc();
    $nb = $result->num_rows; ?>

    <div class="publications">

    <?php
    while($row != NULL){
        $post = $row['Id']; 
            while($row != NULL && $post == $row['Id']){
                ?>
                    <div class="publication">
                <?php
                if($row['PremièreImage'] != NULL){ ?>

                    <a href="http://192.168.56.80/pages/actualites.php?post=<?php echo $row['Id'] ?>"><img src= <?php echo $row['PremièreImage'] ?> alt= <?php echo $row['Nom'] ?> class="image"></a> 

                    <?php
                }
                echo '<p style="font-size:20px; margin-left:10px;">'.$row['Nom'].'</p>';
                echo '<p style=margin-left:10px;>'.$row['date'].'</p>';
                $row = $result->fetch_assoc();
                ?>
                    </div>
                <?php
            } 
        } ?>
    </div> 
<?php } 

}else {

    include_once 'core.php';

    $result = $mysqli->query("SELECT * FROM `Actualites` WHERE id = '".$num_post."';");

    if(!$result) {
        exit($mysqli->error);
    }
    else{
        $row = $result->fetch_assoc();
    }

    ?>
        <div class="post">
            <button onclick="defilement_gauche()"><img class="scrollButton Gauche" src="../img/icon/fleche_gauche.png" alt="bouton gauche"></button>
            <div class="photoContainer">
                <img  src=<?php if($row['PremièreImage'] != NULL){ echo $row['PremièreImage'];}?> alt="Image 1" class="active" name=<?php if($row['PremièreImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['SecondeImage'] != NULL){ echo $row['SecondeImage'];}?> alt="Image 2" class="notActive" name=<?php if($row['SecondeImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['TroisiemeImage'] != NULL){ echo $row['TroisiemeImage'];}?> alt="Image 3" class="notActive" name=<?php if($row['TroisiemeImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['QuatriemeImage'] != NULL){ echo $row['QuatriemeImage'];}?> alt="Image 4" class="notActive" name=<?php if($row['QuatriemeImage'] != NULL){ echo "image_post";}?>>                
            </div>
            <button onclick="defilement_droite()"><img class="scrollButton Droit" src="../img/icon/fleche_droite.png" alt="bouton droite"></button>
            <div class="textContainer">
                <p style="font-size:20px; margin-left:10px;"><?php $row['Nom'] ?></p>
                <p style=margin-left:10px;><?php echo $row['date'] ?></p>
                <p style=margin-left:10px;><?php echo $row['Description'] ?></p>
            </div>
        </div>
    <?php
}
?>