<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>

    <!-- Calendrier -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../calendar-13/fonts/icomoon/style.css">
    <link rel="stylesheet" href="../calendar-13/css/classic.css">
    <link rel="stylesheet" href="../calendar-13/css/classic.date.css">
    <!-- Fin calendrier -->

    <link rel="stylesheet" href="../css/reservation.css" >
    <script src="../js/onglets.js"></script>
    <script src="../js/calendrier.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet"/>

  </head>

  <?php include '../core/formulaire_reservation.php'  ?>
  <?php include "header.php" ?>

  <body>

  <?php if($form){ ?>
    <p style="text-align: center; font-size:15px; color:red;">Merci de renseigner tous les champs</p>
  <?php } ?>

  <?php if($num){ ?>
    <p style="text-align: center; font-size:15px; color:red;">Veuillez rentrer un vrai numéro de téléphone</p>
  <?php } ?>

  <?php if($emailVerif){ ?>
    <p style="text-align: center; font-size:15px; color:red;">Veuillez rentrer une vraie adresse email</p>
  <?php } ?>

    <p style="text-align: center; font-size:20px; margin-top:35px;"> Nos Services :</p>

    <div class="onglets" id="onglets">
      <ul class="choix">
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('chambres')">Chambres</a></p>
          <hr class="buttonActive" name="indication">
        </li>
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('salledesfetes')">Salle des fêtes</a></p>
          <hr class="buttonNotActive" name="indication">
        </li>
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('formules')">Formules</a></p>
          <hr class="buttonNotActive" name="indication">
        </li>
      </ul>
    </div>

    <div id="Chambres" style="display: flex;">
      <div class="contenu">
        <div class="type">
          <img src="../img/reservation/chambres/chambre_double.jpg" alt="chambre double">
          <button onclick="afficherdeplacer()" class="titre">Chambre Double</button>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">75€</p>
          <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
        </div>
        <div class="type">
          <img src="../img/reservation/chambres/dortoir.jpg" alt="Dortoir">  
          <button onclick="afficherdeplacer()" class="titre">Dortoir</button>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">30€</p>
          <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
        </div>
      </div>
    </div>
    <div id="SalleDesFetes" style="display: none;">
      <div class="contenu">
          <div class="type">
            <img src="../img/reservation/salle des fetes/salle.jpg" alt="Salle">
            <button onclick="afficherdeplacer()" class="titre">Salle de location</button>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">650€</p>
            <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
          </div>
          <div class="type">
            <img src="../img/reservation/salle des fetes/bar.jpg" alt="Bar">  
            <button onclick="afficherdeplacer()" class="titre">Bar</button>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">150€</p>
            <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
          </div>
      </div>
    </div>
    <div id="Formules" style="display: none;">
      <div class="contenu">
        <div class="type">
          <img src="../img/reservation/formules/mariage.jpg" alt="mariage">
          <button onclick="afficherdeplacer()" class="titre">Formule mariage grand public</button>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">1550€</p>
          <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
        </div>
        <div class="type">
          <img src="../img/reservation/formules/bar.jpg" alt="bar">  
          <button onclick="afficherdeplacer()" class="titre">Formule Bar et chambre double</button>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">850€</p>
          <button onclick="afficherdeplacer()" class="reserver">Réserver</button>
        </div>
      </div>
    </div>

    <hr style="margin-top: 40px;">

    <div id="bloc" style="display: block; padding-top:60px;">
    <p id="titre_reservation" style="font-size: 20px; text-align:center;">Réservation</p>
      <div style="width: 100%;  padding-right: 15px;  padding-left: 15px;  margin-right: auto;  margin-left: auto; margin-top:50px; margin-bottom:70px; text-align: left !important;">
        <div style="display: flex; flex-wrap: wrap; margin-right: -15px; margin-left: -15px; justify-content: center !important;">
          <div style="flex: 0 0 58.333333%; max-width: 58.333333%;">
            <form method="post" action="#" style="display: flex; flex-wrap: wrap;">
              <div style="flex: 0 0 50%; max-width: 50%;">
                  <div style="margin-bottom: 1rem">
                    <label for="input_from" style="margin: 15px;">De</label>
                    <input type="text" name="input_from" style="display: block;
                                              width: 100%;
                                              padding: .375rem .75rem;
                                              font-size: 1rem;
                                              line-height: 1.5;
                                              color: #495057;
                                              background-color: #fff;
                                              background-clip: padding-box;
                                              border: 1px solid rgb(183, 183, 183);
                                              border-radius: 5px;"
                                              id="input_from" placeholder="Début">
                  </div>
              </div>
              <div style="flex: 0 0 50%; max-width: 50%; margin-bottom:10px;">
                  <div style="margin-bottom: 1rem;">
                      <label for="input_to" style="margin: 15px;">À</label>
                    <input type="text" name="input_to" style="display: block;
                                              width: 100%;
                                              padding: .375rem .75rem;
                                              font-size: 1rem;
                                              line-height: 1.5;
                                              color: #495057;
                                              background-color: #fff;
                                              background-clip: padding-box;
                                              border: 1px solid rgb(183, 183, 183);
                                              border-radius: 5px;"
                                              id="input_to" placeholder="Fin">
                  </div>
              </div>
              <div class="formulaire">
                  <label for="nom">Nom : </label>
                  <input id="nom" name="nom" placeholder="Nom" type="text">
                  <label for="prenom">Prénom : </label>
                  <input id="prenom" name="prenom" placeholder="Prénom" type="text">
                  <label for="email">Email : </label>
                  <input id="email" name="email" placeholder="Email" type="text">
                  <label for="numero">Numero : </label>
                  <input id="numero" name="numero" placeholder="Numero de téléphone" type="text">
                  <label for="event">Type d'évènement : </label>
                  <input name="event" id="event" placeholder="Type d'évènement" type="text">
                  <div style="display: flex; margin-top:10px; justify-content:center;">
                    <label for="chambre" style="height: 100%; white-space: nowrap;">Chambres : </label>
                    <select id="chambre" name="chambre">
                      <option value="1">Chambre double - Chêne</option>
                      <option value="2">Chambre double - Peuplier</option>
                      <option value="3">Chambre double - Abricot</option>
                      <option value="4">Dortoir - Forêt</option>
                      <option value="5">L'ensemble</option>
                    </select>
                  </div>
                  <div style="display: flex; margin-top:10px; justify-content:center;">
                    <label for="salle" style="height: 100%; white-space: nowrap;">Salle : </label>
                    <select id="salle" name="salle">
                      <option value="1">Salle des fêtes</option>
                      <option value="2">Bar</option>
                      <option value="3">L'ensemble</option>
                    </select>
                  </div>
                  <button name="submit" value="1" type="submit" class="reserver" style="margin-top: 20px; margin-bottom:0;">Demander la réservation</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <script src="../js/calendrier.js"></script>

    <script src="../calendar-13/js/jquery-3.3.1.min.js"></script>
    <script src="../calendar-13/js/popper.min.js"></script>
    <script src="../calendar-13/js/bootstrap.min.js"></script>
    <script src="../calendar-13/js/picker.js"></script>
    <script src="../calendar-13/js/picker.date.js"></script>

  </body>

  <?php include 'footer.php' ?>

  
</html>