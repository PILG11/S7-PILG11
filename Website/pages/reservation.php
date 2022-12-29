<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="utf-8" />
    <title>Réservation</title>
    <link rel="stylesheet" href="../css/reservation.css" >
  </head>

  <?php include "header.php" ?>

  <body>

    <p style="text-align: center; font-size:20px; margin-top:3%; margin-bottom:3%;"> Nos Services :</p>

    <div class="onglets">
      <ul class="choix">
        <li class="option">
          <button>Chambres</button>
          <hr class="notActive">
        </li>
        <li class="option">
          <button>Salle des fêtes</button>
          <hr class="notActive">
        </li>
        <li class="option">
            <button>Formules</button>
            <hr class="active">
        </li>
      </ul>
    </div> 
  </body>

  <?php include 'footer.php' ?>

  
</html>