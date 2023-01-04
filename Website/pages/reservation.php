<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>
    <link rel="stylesheet" href="../css/reservation.css" >
    <script src="../js/onglets.js"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
      rel="stylesheet"
    />
  </head>

  <?php include "header.php" ?>

  <body>

    <p style="text-align: center; font-size:20px; margin-top:35px;"> Nos Services :</p>

    <div class="onglets" id="onglets">
      <ul class="choix">
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('chambres')">Chambres</a></p>
          <hr class="active" name="indication">
        </li>
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('salledesfetes')">Salle des fêtes</a></p>
          <hr class="notActive" name="indication">
        </li>
        <li class="option">
          <p><a style="font-size: 18px;" onclick="onglet('formules')">Formules</a></p>
          <hr class="notActive" name="indication">
        </li>
      </ul>
    </div>

    <div id="Chambres" style="display: flex;">
      <div class="contenu">
        <div class="type">
          <img src="../img/reservation/chambres/chambre_double.jpg" alt="chambre double">
          <button onclick="afficherdeplacer('Réservation chambre double')" class="titre">Chambre Double</button>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">75€</p>
          <button onclick="afficherdeplacer('Réservation chambre double')" class="reserver">Réserver</button>
        </div>
        <div class="type">
          <img src="../img/reservation/chambres/dortoir.jpg" alt="Dortoir">  
          <button onclick="afficherdeplacer('Réservation dortoir')" class="titre">Dortoir</button>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">30€</p>
          <button onclick="afficherdeplacer('Réservation dortoir')" class="reserver">Réserver</button>
        </div>
      </div>
    </div>
    <div id="SalleDesFetes" style="display: none;">
      <div class="contenu">
          <div class="type">
            <img src="../img/reservation/salle des fetes/salle.jpg" alt="Salle">
            <button onclick="afficherdeplacer('Réservation salle de location')" class="titre">Salle de location</button>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">650€</p>
            <button onclick="afficherdeplacer('Réservation salle de location')" class="reserver">Réserver</button>
          </div>
          <div class="type">
            <img src="../img/reservation/salle des fetes/bar.jpg" alt="Bar">  
            <button onclick="afficherdeplacer('Réservation bar')" class="titre">Bar</button>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">150€</p>
            <button onclick="afficherdeplacer('Réservation bar')" class="reserver">Réserver</button>
          </div>
      </div>
    </div>
    <div id="Formules" style="display: none;">
      <div class="contenu">
        <div class="type">
          <img src="../img/reservation/formules/mariage.jpg" alt="mariage">
          <button onclick="afficherdeplacer('Réservation formule mariage grand public')" class="titre">Formule mariage grand public</button>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">1550€</p>
          <button onclick="afficherdeplacer('Réservation formule mariage grand public')" class="reserver">Réserver</button>
        </div>
        <div class="type">
          <img src="../img/reservation/formules/bar.jpg" alt="bar">  
          <button onclick="afficherdeplacer('Réservation formule bar et chambre double')" class="titre">Formule Bar et chambre double</button>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">850€</p>
          <button onclick="afficherdeplacer('Réservation formule bar et chambre double')" class="reserver">Réserver</button>
        </div>
      </div>
    </div>

    <div id="bloc">
      <div class="conteneur">
        <div class="calendrier">
          <div class="mois">
            <i class="fas fa-angle-left prev"></i>
            <div class="date">
              <p id="titre_reservation"></p>
              <h1></h1>
              <p id="date_aujourdhui"></p>
            </div>
            <i class="fas fa-angle-right next"></i>
          </div>
          <div class="semainejours">
            <div>Dim</div>
            <div>Lun</div>
            <div>Mar</div>
            <div>Mer</div>
            <div>Jeu</div>
            <div>Ven</div>
            <div>Sam</div>
          </div>
          <div class="jours"></div>
        </div>
      </div>
    </div>

    <script src="../js/calendrier.js"></script>

  </body>

  <?php include 'footer.php' ?>

  
</html>