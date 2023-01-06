<?php

include_once 'core.php';

$emissionAvisFail = false;

if (isset($_POST['avis_submit'])) {
    if (
        $_POST['nom'] != NULL && $_POST['prenom'] != NULL && isset($_POST['email'])
        && $_POST['message'] != NULL
    ) {

        $nom_escaped = $mysqli->real_escape_string(trim($_POST['nom']));
        $prenom_escaped = $mysqli->real_escape_string(trim($_POST['prenom']));
        $mail_escaped = $mysqli->real_escape_string(trim($_POST['email']));
        $message_escaped = $mysqli->real_escape_string(trim($_POST['message']));

        // Vérifier si un utilisateur a déjà déposé un avis avec cette adresse mail !
        $sql = "SELECT COUNT(*) AS NOMBRE
        FROM avis WHERE email  = '" . $mail_escaped . "'";

        $result = $mysqli->query($sql);
        $resultfinal = $result->fetch_array()['NOMBRE'];

        if ($resultfinal == 0) {
            // Requête SQL pour ajouter l'avis à la base de donnée
            $sql = "INSERT INTO avis (nom, prenom, commentaire, email)
            VALUES ('" . $nom_escaped . "', '" . $prenom_escaped . "'
, '" . $message_escaped . "' , '" . $mail_escaped . "')";
            $mysqli->query($sql);
        } else {
            // Une personne a déjà mis un avis avec cette adresse mail
            $emissionAvisFail = true;
            $error_message = "Vous avez déjà essayé de déposer un avis";
        }
    } else {
        // Manque une information
        $emissionAvisFail = true;
        $error_message = "Merci de renseigner tous les champs";
    }
}

?>