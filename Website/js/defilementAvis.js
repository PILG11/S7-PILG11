let avis = [
    { prenom: "John", nom: "Doe", commentaire: "Super produit !" },
    { prenom: "Jane", nom: "Doe", commentaire: "Je suis très satisfaite !" },
    { prenom: "Bob", nom: "Smith", commentaire: "Très déçu par ce produit." },
    // ...
];

// Fonction qui ajoute un avis au conteneur
function ajouterAvis(prenom, nom, commentaire) {
    let div = document.createElement("div");
    div.classList.add("avis");
    div.innerHTML = `
      <h2>${prenom} ${nom}</h2>
      <p>${commentaire}</p>
    `;
    document.getElementById("conteneur").appendChild(div);
}

// Fonction qui défile les avis toutes les 5 secondes
function defilerAvis() {
    let conteneur = document.getElementById("conteneur");
    let avisEnCours = conteneur.firstChild;
    let hauteur = avisEnCours.offsetHeight;
    avisEnCours.style.top = `-${hauteur}px`;
    setTimeout(function() {
        conteneur.appendChild(avisEnCours);
        avisEnCours.style.top = "0";
        defilerAvis();
    }, 5000);
}

// Ajout des avis au conteneur et démarrage du défilement
for (let i = 0; i < avis.length; i++) {
    ajouterAvis(avis[i].prenom, avis[i].nom, avis[i].commentaire);
}