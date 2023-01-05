<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Les Logis de Beaulieu</title>
    <link rel="stylesheet" href="./css/style.css" >
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"/>
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
  </head>

  <?php include "./pages/header.php" ?>

  <body>

    <div class="first_img">
      <img src="./img/Accueil/accueil.png" alt="Photo gîte">
    </div>

    <div class="sous_titre">
      <p> Henri et Christine Blois vous souhaite la bienvenue </p>
    </div>

    <div class="second_img">
      <img src="./img/Accueil/accueil2.png" alt="Photo gîte">
    </div>

    <div class="sous_titre">
      <p> Les différentes activités près du logis </p>
    </div>

    <div>
      <div class="container">
        <a href="" target="_blank">
          <img src="./img/Accueil/acrobranche.jpg" alt="acrobranche">
          <h3>Acrobranche</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
        </a>
      </div>

      <div class="container">
        <a href="" target="_blank">
          <img src="./img/Accueil/canoe.jpg" alt="canoe">
          <h3>Le Canoë</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,Lorem ipsum dolor sit amet, consectetur adipiscing elit,Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
        </a>
      </div>

      <div class="container">
        <a href="" target="_blank">
          <img src="./img/Accueil/rando.jpg" alt="rando">
          <h3>La Randonnée</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
        </a>
      </div>

      <div class="container">
        <a href="" target="_blank">
          <img src="./img/Accueil/cheval.jpg" alt="cheval">
          <h3>Le Cheval</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
        </a>
      </div>

      <div class="container">
        <a href="" target="_blank">
          <img src="./img/Accueil/trot.jpg" alt="trot">
          <h3>Balade en trotinette</h3>
          <p>Bip Bip la trotinette électrique</p>
        </a>
      </div>
    </div>

    <div class="sous_titre">
      <p> Où nous situer </p>
    </div>

    <div class="map" id="mapid"> <script src="./js/map.js"></script> </div>

  </body>

  <?php include "./pages/footer.php" ?>

</html>