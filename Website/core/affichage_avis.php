<?php

include_once 'core.php';

$result = $mysqli->query("SELECT nom, prenom, commentaire, note FROM avis");

include_once 'core.php';

if (!$result) {
    exit($mysqli->error);
} else {
    $row = $result->fetch_assoc();
}

?>
<div class="affichageAvis">
    <img src="../img/AvisEtContact/fond-avis.png" alt="Photo livre">
    <div class="imageFond">
    <button onclick="defilement_gauche()"><img class="scrollButton" src="../img/icon/fleche_gauche.png" alt="bouton gauche"></button>
        <div class="avisContainer active" name="affichage_avis">
            <?php if ($row['nom'] != NULL) {
                ?>
                <p style="font-size: 20px; margin-bottom: -15px;"><?php echo $row['nom'];
                echo " ";
                echo $row['prenom']; ?></p>
                <p>_________</p>
                <p style="font-size: 20px; margin-top: 30px;">
                    <?php echo '"';
                    echo $row['commentaire'];
                    echo '"' ?>
                </p>
                <p style="font-size: 20px; margin-top: 25px;"><?php
                echo $row['note'];
                echo "/5"; ?></p>
                <?php
            } ?>
            </p>
        </div>
        <?php $row = $result->fetch_assoc(); ?>
        <div class="avisContainer notActive" name="affichage_avis">
            <?php if ($row['nom'] != NULL) {
                ?>
                <p style="font-size: 20px; margin-bottom: -15px;"><?php echo $row['nom'];
                echo " ";
                echo $row['prenom']; ?></p>
                <p>_________</p>
                <p style="font-size: 20px; margin-top: 30px;">
                    <?php echo '"';
                    echo $row['commentaire'];
                    echo '"' ?>
                </p>
                <p style="font-size: 20px; margin-top: 25px;"><?php
                echo $row['note'];
                echo "/5"; ?></p>
                <?php
            } ?>
            </p>
        </div>
        <?php $row = $result->fetch_assoc(); ?>
        <div class="avisContainer notActive" name="affichage_avis">
            <?php if ($row['nom'] != NULL) {
                ?>
                <p style="font-size: 20px; margin-bottom: -15px;"><?php echo $row['nom'];
                echo " ";
                echo $row['prenom']; ?></p>
                <p>_________</p>
                <p style="font-size: 20px; margin-top: 30px;">
                    <?php echo '"';
                    echo $row['commentaire'];
                    echo '"' ?>
                </p>
                <p style="font-size: 20px; margin-top: 25px;"><?php
                echo $row['note'];
                echo "/5"; ?></p>
                <?php
            } ?>
            </p>
        </div>
        <button onclick="defilement_droite()"><img class="scrollButton" src="../img/icon/fleche_droite.png" alt="bouton droite"></button>
    </div>
</div>
<?php

?>