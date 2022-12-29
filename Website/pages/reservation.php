<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>
    <link rel="stylesheet" href="../css/reservation.css" >
    <script src="../js/onglet.js"></script>
  </head>

  <?php include "header.php" ?>

  <body>

    <p style="text-align: center; font-size:20px; margin-top:3%; margin-bottom:3%;"> Nos Services :</p>

    <div class="onglets">
      <ul class="choix">
        <li class="option">
          <button onclick="onglet(Chambres)">Chambres</button>
          <hr class="notActive">
        </li>
        <li class="option">
          <button onclick="onglet(SalleDesFetes)">Salle des fêtes</button>
          <hr class="notActive">
        </li>
        <li class="option">
          <button onclick="onglet(Formules)">Formules</button>
          <hr class="active">
        </li>
      </ul>
    </div>

    <div id="Chambres"></div>
    <div id="SalleDesFetes"></div>
    <div id="Formules"></div>

  </body>

  <?php include 'footer.php' ?>

  
</html>