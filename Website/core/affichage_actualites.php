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
        $post = $row['id']; 
            while($row != NULL && $post == $row['id']){
                ?>
                    <div class="publication">
                <?php
                if($row['premièreImage'] != NULL){ ?>
                    <a href="https://192.168.56.80/pages/actualites.php?post=<?php echo $row['id'] ?>"><img src= <?php echo $row['premièreImage'] ?> alt= <?php echo $row['nom'] ?> class="image"></a> 
                    <?php
                }
                echo '<p style="font-size:20px; margin-left:10px;">'.$row['nom'].'</p>';
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
                <img  src=<?php if($row['premièreImage'] != NULL){ echo $row['premièreImage'];}?> alt="Image 1" class="active" name=<?php if($row['premièreImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['secondeImage'] != NULL){ echo $row['secondeImage'];}?> alt="Image 2" class="notActive" name=<?php if($row['secondeImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['troisiemeImage'] != NULL){ echo $row['troisiemeImage'];}?> alt="Image 3" class="notActive" name=<?php if($row['troisiemeImage'] != NULL){ echo "image_post";}?>>
                <img  src=<?php if($row['quatriemeImage'] != NULL){ echo $row['quatriemeImage'];}?> alt="Image 4" class="notActive" name=<?php if($row['quatriemeImage'] != NULL){ echo "image_post";}?>>                
            </div>
            <button onclick="defilement_droite()"><img class="scrollButton Droit" src="../img/icon/fleche_droite.png" alt="bouton droite"></button>
            <div class="textContainer">
                <p style="font-size:20px; margin-left:10px;"><?php $row['nom'] ?></p>
                <p style=margin-left:10px;><?php echo $row['date'] ?></p>
                <p style=margin-left:10px;><?php echo $row['description'] ?></p>
            </div>
        </div>
    <?php
}
?>