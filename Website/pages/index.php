<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Les Logis de Beaulieu</title>
    <link rel="stylesheet" href="../css/style.css" >
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"/>
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
  </head>

  <?php include "./header.php" ?>

  <body>

    <div class="first_img">
      <img src="../img/Accueil/accueil.png" alt="Photo gîte">
    </div>

    <div class="sous_titre">
      <p> Henri et Christine Blois vous souhaite la bienvenue </p>
    </div>

    <div class="second_img">
      <img src="../img/Accueil/accueil2.png" alt="Photo gîte">
    </div>

    <div class="sous_titre">
      <p> Les différentes activités près du logis </p>
    </div>

    <div class="activite">
      <div class="container">
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley" target="_blank">
          <img src="../img/Accueil/acrobranche.jpg" alt="acrobranche">
          <h3>Acrobranche</h3>
          <p>Envoyer vous en l'air à l'acrobranche, c'est génial d'après Hugo</p>
        </a>
      </div>

      <div class="container">
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley" target="_blank">
          <img src="../img/Accueil/canoe.jpg" alt="canoe">
          <h3>Le Canoë</h3>
          <p>Le bateau c'est super rigolo surtout avec les copaing et un ricard on s'amuse vraiment bien c'est super sympag la bise a tout le monde- Wawone</p>
        </a>
      </div>

      <div class="container">
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley" target="_blank">
          <img src="../img/Accueil/rando.jpg" alt="rando">
          <h3>La Randonnée</h3>
          <p>La marche c'est vraiment un moment de reconnection avec la nature, Théo Sueur</p>
        </a>
      </div>

      <div class="container">
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley" target="_blank">
          <img src="../img/Accueil/cheval.jpg" alt="cheval">
          <h3>Le Cheval</h3>
          <p>L'équitation c'est ma passion - Clovis 2023</p>
        </a>
      </div>

      <div class="container">
        <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley" target="_blank">
          <img src="../img/Accueil/trot.jpg" alt="trot">
          <h3>Balade en trotinette</h3>
          <p>Bip Bip la trotinette électrique</p>
        </a>
      </div>
    </div>

    <div class="sous_titre">
      <p> Où nous situer </p>
    </div>

    <div class="map" id="mapid"> <script src="../js/map.js"></script> </div>

  </body>

  <?php include "./footer.php" ?>

</html>