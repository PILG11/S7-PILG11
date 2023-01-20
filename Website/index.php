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
      <p> Henri et Christine Blois vous souhaitent la bienvenue </p>
    </div>

    <div class="second_img">
      <img src="./img/Accueil/accueil2.png" alt="Photo gîte">
      <div class="descr">
        <h2> Le Domaine</h2>
        <p> Situé à 15 km d'Angers, les Logis de Beaulieu vous accueillent pour toutes vos manifestations familiales ou professionnelles. Vous pourrez également y organiser la plus belle journée de votre vie, VOTRE MARIAGE dans un cadre champêtre situé au cœur d'une ancienne écurie de chevaux de course, le domaine est entouré de 50 ha de prairies où nos chevaux coulent encore des jours heureux. </p>
        <p> Vous êtes à la recherche d'un cadre champêtre, romantique et élégant, en pleine nature, pour organiser votre réception de mariage ? Un lieu à la fois convivial et agréable, qui vous permettra de profiter d'un moment de fête avec vos proches ? </p>
        <p> Vous profiterez d'installations entièrement rénovées : des salles lumineuses et des chambres originales installées dans nos anciens boxes vous permettront de vous rassembler en toute sérénité. Un grand préau surplombe nos prairies pour accueillir votre vin d'honneur ou vos repas extérieurs. Un cadre champêtre, bucolique et chic pour donner libre court à des moments inoubliables en famille ou entre amis.</p>
      </div>
    </div>

    <div class="sous_titre">
      <p> Les différentes activités près du logis </p>
    </div>
    
    <div class="container">
        <a href="https://www.giffard.com/fr/" target="_blank">
          <img src="./img/Accueil/giffard.jpg" alt="giffard">
          <h3>Distillerie Giffard</h3>
          <p>Personnel accueillant, découverte de l'histoire de cette société familiale et locale super intéressante. Et la dégustation un vrai délice... un incontournable de la région angevine !!</p>
        </a>
      </div>

      <div class="container">
        <a href="https://eseo.fr/" target="_blank">
          <img src="./img/Accueil/eseo.jpg" alt="eseo">
          <h3>ESEO</h3>
          <p>L'Ecole Supérieur d'Electronique de l'Ouest ! A ne pas manquer !!!</p>
        </a>
      </div>
    </div>

      <div class="container">
        <a href="https://www.chateau-angers.fr/" target="_blank">
          <img src="./img/Accueil/chateau.jpg" alt="chateau">
          <h3>Le château d'Angers</h3>
          <p>Château magnifique, unique, avec tellement d'histoire et sa tapisserie à voir absolument !</p>
        </a>
      </div>

    <div>
      <div class="container">
        <a href="https://www.parcoursaventure49.fr/" target="_blank">
          <img src="./img/Accueil/acrobranche.jpg" alt="acrobranche">
          <h3>Acrobranche</h3>
          <p>Quel calme...... Pour la nature, la détente, les parcours dans les arbres, il faut le faire. En plus, le personnel est super sympa. A faire absolument !</p>
        </a>
      </div>

      <div class="container">
        <a href="https://ckca.fr/dev/" target="_blank">
          <img src="./img/Accueil/canoe.jpg" alt="canoe">
          <h3>Canoë - Kayak</h3>
          <p>Très belle promenade sur le Lac de Maine. Les prix sont très abordables 5€/pers pour 1h sinon 8€/pers pour 2h.</p>
        </a>
      </div>

    <div class="sous_titre">
      <p> Où nous situer </p>
    </div>

    <div class="map" id="mapid"> <script src="./js/map.js"></script> </div>

  </body>

  <?php include "./pages/footer.php" ?>

</html>