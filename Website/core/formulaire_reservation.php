<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>
  </head>
    <body>
<?php 

include_once 'core.php';
$form = false;
$num = false;
$emailVerif = false;
$requete = false;

function get_second_word($string) {
    $words = explode("-", $string);
    return trim($words[1]);
}

function isValidEmail($email) {
    $pattern = '/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/';
    return preg_match($pattern, $email);
}

function formatDateToEnglish($date) {
    $french_months = array("Janvier", "Février", "Mars", "avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre");
    $english_months = array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    $new_date = str_replace($french_months, $english_months, $date);
    return $new_date;
}

function formatDate($date) {
    date_default_timezone_set('Europe/Paris');
    $date = new DateTime($date);
    $day = $date->format("j");
    $month = $date->format("F");
    $year = $date->format("Y");
    return "$day $month, $year";
}

function unformatDate($formattedDate) {
    $date = DateTime::createFromFormat("j F, Y", $formattedDate);
    return $date->format("Y-m-d");
}

function calculer_nombre_jours($date1, $date2) {
    $date1 = strtotime($date1);
    $date2 = strtotime($date2);
    $diff = abs($date2 - $date1);
    $result = floor($diff / (60*60*24));
    return $result;
}

function isValidPhoneNumber($phoneNumber) {
    $pattern = '/^[+]?[0-9]{10,14}$/';
    return preg_match($pattern, $phoneNumber);
}

    //-------------Gérer les réservations ------------------

    if(isset($_POST['submit']) && $_POST['submit'] == 1){
        if($_POST['nom'] != NULL && $_POST['prenom'] != NULL && $_POST['email'] != NULL && 
        $_POST['numero'] != NULL && $_POST['event'] != NULL && $_POST['chambre'] != NULL && $_POST['salle'] != NULL
        && $_POST['input_from'] != NULL && $_POST['input_to'] != NULL){
            
            
            $form = false;
            
            $nom = $_POST['nom'];
            $prenom = $_POST['prenom'];
            $email = $_POST['email'];
            $numero = $_POST['numero'];

            $event = $_POST['event'];
            $chambre = $_POST['chambre'];
            $salle = $_POST['salle'];

            $input_from = $_POST['input_from'];
            $date_database = unformatDate(formatDateToEnglish($input_from));

            $input_to = $_POST['input_to'];


            // -----------CLIENT-------------------

            $result = $mysqli->query("SELECT * FROM clients WHERE nom LIKE '".$nom."' AND email LIKE '".$email."';");
            $row = $result->fetch_assoc();


                //------------Créer un CLIENT-------
            if($row === NULL){

                $result = $mysqli->query("SELECT max(id) FROM clients");

                if (!$result) {
                    exit($mysqli->error);
                }
                else{
                    $row = $result->fetch_assoc();
                    $idClient = $row['max(id)'] + 1;
                }
            }
            
                //------------Réutilise un CLIENT-------
            else{

                $result = $mysqli->query("SELECT clients.id FROM clients WHERE email LIKE '".$email."';");
                $row = $result->fetch_assoc();
                $idClient = $row['id'];
            }

            if(isValidPhoneNumber($numero)){

                $num = false;

                if(isValidEmail($email)){

                    $emailVerif = false;

                    $sql = "INSERT INTO clients(id, nom, prenom, email, numero)
                    VALUES ('".$idClient."', '".$nom."', '".$prenom."'
                    , '".$email."', '".$numero."')";
                    
                    $result = $mysqli->query($sql);
                
                }
                else{
                    $emailVerif = true;
                }
            }
            else{
                $num = true;
            }

            //----------Salle------------------

            $list = array("Salle des fêtes", "Bar", "Le site", "Aucune");
            $result = $mysqli->query("SELECT salles.id FROM salles WHERE nom LIKE '".$list[$salle - 1]."';");
            $idSalle = $result->fetch_assoc();

            //-----------Chambre----------------

            $list = array("Chêne", "Peuplier", "Abricot", "Forêt", "Le site", "Aucune");
            $result = $mysqli->query("SELECT chambres.id FROM chambres WHERE nom LIKE '".$list[$chambre - 1]."';");
            $idChambre = $result->fetch_assoc();

            //----------Reservations-------------

            $result = $mysqli->query("SELECT Reservations.dateDebut FROM Reservations WHERE dateDebut LIKE '".$date_database."';");
            $row = $result->fetch_assoc();

            if($row === NULL){
                
                $result = $mysqli->query("SELECT max(id) FROM Reservations");

                if (!$result) {
                    exit($mysqli->error);
                }
                else{
                    $row = $result->fetch_assoc();
                    $idReservation = $row['max(id)'] + 1;
                }

                $Duree = calculer_nombre_jours(unformatDate(formatDateToEnglish($input_from)), unformatDate(formatDateToEnglish($input_to)));

                $sql = "INSERT INTO Reservations(id, evenement, valide, dateDebut, duree, chambres, client, salles)
                VALUES ('".$idReservation."', '".$event."', 0, 
                '".$date_database."'
                , '".$Duree."'
                , '".intval($idChambre['id'])."'
                , '".intval($idClient)."'
                , '".intval($idSalle['id'])."')";

                $result = $mysqli->query($sql);

                if($result){
                    $requete = true;
                    echo   '<p style="text-align: center; font-size:15px; color:green;">Demande de réservation bien envoyée.</p>';
                }
                else{
                    $requete = false;
                }
                }
            
        }
        else{
            $form = true;
        }
    }

    //--------------Changer Calendrier, Jours Reserves-----------------

    $result = $mysqli->query("SELECT * FROM `Reservations`");

    if(!$result) {
        exit($mysqli->error);
    }
    else{

        $row = $result->fetch_assoc();
        $datesReserves = array();

        while($row != NULL){ 

            $date = formatDate($row['dateDebut']);

            for ($i = 0; $i < $row['duree'] + 1; $i++) {
                $datesReserves[] = $date;
                $dateSuivante = date('Y-m-d', strtotime($date . ' +1 day'));
                $date = formatDate($dateSuivante);
            }
        
            $row = $result->fetch_assoc();

        }

        $json = json_encode($datesReserves);

    }?>
    
    <script>

            document.addEventListener("DOMContentLoaded", function() {

                var list = <?php echo $json; ?>;
                var list_fr = formatDatesFr(list);   

                console.log(list_fr);

                date_reservees();

                var calendriers = document.getElementsByClassName("picker__holder");
                calendriers[0].addEventListener("click", date_reservees);
                calendriers[1].addEventListener("click", date_reservees);

                function date_reservees() {

                    var calendriers = document.getElementsByClassName("picker__holder");
                    for (var date of list_fr){
                        // console.log('[aria-label=' + '"' + date + '"' + ']')
                        var date_selected_calendrier1 = calendriers[0].querySelector('[aria-label=' + '"' + date + '"' + ']');
                        var date_selected_calendrier2 = calendriers[1].querySelector('[aria-label=' + '"' + date + '"' + ']');

                        if(date_selected_calendrier1 != null){
                            date_selected_calendrier1.classList.add("selected-date");
                        }
                        if(date_selected_calendrier2 != null){
                            date_selected_calendrier2.classList.add("selected-date");
                        }
                    }
                }

                function formatDatesFr(dates) {
                    const months = {
                        'January,': 'Janvier',
                        'February,': 'Février',
                        'March,': 'Mars',
                        'April,': 'Avril',
                        'May,': 'Mai',
                        'June,': 'Juin',
                        'July,': 'Juillet',
                        'August,': 'Août',
                        'September,': 'Septembre',
                        'October,': 'Octobre',
                        'November,': 'Novembre',
                        'December,': 'Décembre',
                    };

                    return dates.map(date => {
                        const parts = date.split(' ');
                        const day = parts[0];
                        const month = months[parts[1]];
                        const year = parts[2];

                        return `${day} ${month}, ${year}`;
                    });
                }

            });
    

    </script>
    </body>
</html>