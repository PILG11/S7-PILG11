<!DOCTYPE html>
<html lang="fr">

<head>
  <meta charset="utf-8" />
  <title>Avis et Contact</title>
  <link rel="stylesheet" href="../css/style.css">
</head>

<?php include "./header.php" ?>

<body>
  <div class="container">
    <div class="contact-info">
      <img src="../img/AvisEtContact/logo-adresse.png" alt="Logo adresse">
      <h3>Adresse</h3>
      <p>Chemin des Logis de Beaulieu, Soucelles, 49140, Rives du Loir en Anjou</p>
    </div>
    <div class="contact-info">
      <img src="../img/AvisEtContact/logo-telephone.png" alt="Logo téléphone">
      <h3>Téléphone</h3>
      <p>07 84 14 66 59</p>
    </div>
    <div class="contact-info">
      <img src="../img/AvisEtContact/logo-mail.png" alt="Logo email">
      <h3>Email</h3>
      <p>hugo.blois@reseau.eseo.fr</p>
    </div>
    <div class="contact-info">
      <img src="../img/AvisEtContact/logo-pouce.png" alt="Logo réseaux sociaux">
      <h3>Réseaux Sociaux</h3>
      <p>
        <a href="https://www.facebook.com/Les-Logis-de-Beaulieu-929752433837612"><i class="icon ion-social-facebook"></i></a>
        <a href="https://www.instagram.com/leslogisdebeaulieu/"><i class="icon ion-social-instagram"></i></a>
        <a href="#"><i class="icon ion-social-twitter"></i></a>
      </p>
    </div>
  </div>

  <form>
    <div id="Formulaire" style="display: flex;">
      <div class="type" style="text-align:center;">
        <label for="titreFormulaire" style="text-align: center; font-size:35px; margin-top:10px;">Soyez le prochain à
          témoigner</label>
        <label for="first-name" style="text-align: center; font-size:18px; margin-top:25px;">Prénom:</label>
        <input type="text" id="first-name" name="first-name" style="margin-left:">
        <label for="last-name" style="text-align: center; font-size:18px; margin-top:10px" ;>Nom:</label>
        <input type="text" id="last-name" name="last-name">
        <label for="email" style="text-align: center; font-size:18px; margin-top:10px;">Email:</label>
        <input type="email" id="email" name="email">
        <label for="message" style="text-align: center; font-size:18px; margin-top:10px;">Message:</label>
        <textarea id="message" name="message"></textarea>
        <p class="envoyer"><a style="color: white;">Envoyer</a></p>
      </div>
    </div>
  </form>
</body>

<?php include "./footer.php" ?>

</html>