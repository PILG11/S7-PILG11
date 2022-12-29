<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>
    <link rel="stylesheet" href="../css/reservation.css" >
    <script src="../js/onglets.js"></script>
  </head>

  <?php include "header.php" ?>

  <body>

    <p style="text-align: center; font-size:20px; margin-top:35px;"> Nos Services :</p>

    <div class="onglets">
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
          <p class="titreChambre"><a class="titreChambre" href="">Chambre Double</a></p>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">75€</p>
          <p class="reserver"><a style="color: white;">Réserver</a></p>
        </div>
        <div class="type">
          <img src="../img/reservation/chambres/dortoir.jpg" alt="Dortoir">  
          <p class="titreChambre"><a class="titreChambre" href="">Dortoir</a></p>
          <hr>
          <p style="text-align: center; font-size:18px">24h</p>
          <p style="text-align: center; font-size:18px">30€</p>
          <p class="reserver"><a style="color: white;">Réserver</a></p>
        </div>
      </div>
    </div>
    <div id="SalleDesFetes" style="display: none;">
      <div class="contenu">
          <div class="type">
            <img src="../img/reservation/salle des fetes/salle.jpg" alt="Salle">
            <p class="titreChambre"><a class="titreChambre" href="">Salle de location</a></p>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">650€</p>
            <p class="reserver"><a style="color: white;">Réserver</a></p>
          </div>
          <div class="type">
            <img src="../img/reservation/salle des fetes/bar.jpg" alt="Bar">  
            <p class="titreChambre"><a class="titreChambre" href="">Bar</a></p>
            <hr>
            <p style="text-align: center; font-size:18px">48h</p>
            <p style="text-align: center; font-size:18px">150€</p>
            <p class="reserver"><a style="color: white;">Réserver</a></p>
          </div>
      </div>
    </div>
    <div id="Formules" style="display: none;">
      <div class="contenu">
        <div class="type">
          <img src="../img/reservation/formules/mariage.jpg" alt="mariage">
          <p class="titreChambre"><a class="titreChambre" href="">Formule mariage grand public</a></p>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">1550€</p>
          <p class="reserver"><a style="color: white;">Réserver</a></p>
        </div>
        <div class="type">
          <img src="../img/reservation/formules/bar.jpg" alt="bar">  
          <p class="titreChambre"><a class="titreChambre" href="">Formule bar et chambre double</a></p>
          <hr>
          <p style="text-align: center; font-size:18px">48h</p>
          <p style="text-align: center; font-size:18px">850€</p>
          <p class="reserver"><a style="color: white;">Réserver</a></p>
        </div>
      </div>
    </div>

  </body>

  <?php include 'footer.php' ?>

  
</html>