<?php
$emissionAvisFail = false;

if (isset($_POST['avis_submit']) && $_POST['avis_submit'] == 1) {
    if (
        $_POST['nom'] != NULL && $_POST['prenom'] != NULL && isset($_POST['email'])
        && $_POST['message'] != NULL && $_POST['etoile'] != NULL
    ) {

        $nom_escaped = $mysqli->real_escape_string(trim($_POST['nom']));
        $prenom_escaped = $mysqli->real_escape_string(trim($_POST['prenom']));
        $mail_escaped = $mysqli->real_escape_string(trim($_POST['email']));
        $message_escaped = $mysqli->real_escape_string(trim($_POST['message']));
        $etoile_escaped = $mysqli->real_escape_string(trim($_POST['etoile']));

        // Vérifier si un utilisateur a déjà déposé un avis avec cette adresse mail !
        $sql = "SELECT id
        FROM avis
        WHERE email  = '" . $mail_escaped . "'";

        $result = $mysqli->query($sql);

        if (!$result) {
            exit($mysqli->error);
        } else {
            $nb = $result->num_rows;
            if ($nb) {
                // Une personne a déjà mis un avis avec cette adresse mail
                $emissionAvisFail = true;
                $error_message = "Vous avez déjà essayé de déposer un avis";
            }
        }

        // Requête SQL pour ajouter l'avis à la base de donnée
        $sql = "INSERT INTO avis(id, nom, prenom, commentaire, etoile, email)
        VALUES ('" . $id . "', '" . $nom_escaped . "', '" . $prenom_escaped . "'
        , '" . $message_escaped . "' , '" . $etoile_escaped . "' , '" . $mail_escaped . "')";

    }
    else{
        // Manque une information
        $emissionAvisFail = true;
        $error_message = "Merci de renseigner tous les champs";
    }
}

?>