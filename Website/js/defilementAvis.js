var increment = 0;
const avis = document.getElementsByName("affichage_avis");
    
function defilement_gauche(){

    var taille_avis = avis.length;

    avis[increment].classList.remove("active");
    avis[increment].classList.add("notActive");

    if(increment == taille_avis-1){
        increment = -1;
    }

    avis[increment + 1].classList.remove("notActive");
    avis[increment + 1].classList.add("active");

    increment = increment + 1;

}

function defilement_droite(){

    var taille_avis = avis.length;

    avis[increment].classList.remove("active");
    avis[increment].classList.add("notActive");

    if(increment == 0){
        increment = taille_avis;
    }

    avis[increment - 1].classList.remove("notActive");
    avis[increment - 1].classList.add("active");

    increment = increment - 1;

}
