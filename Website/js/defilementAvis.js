var increment = 0;
var avis = document.getElementsByName("affichage_avis");

var pos = 0;

function goToSectionAfterRefresh(sectionId) {
    console.log('oui')
    window.onload = function () {
        console.log(sectionId)
        var section = document.getElementById(sectionId);
        section.scrollIntoView({ behavior: 'smooth' });
    }
}

function defilement_gauche(){

    var taille_image = avis.length;

    avis[increment].classList.remove("active");
    avis[increment].classList.add("notActive");

    if(increment == taille_image-1){
        increment = -1;
    }

    avis[increment + 1].classList.remove("notActive");
    avis[increment + 1].classList.add("active");

    increment = increment + 1;
    
}

function defilement_droite(){

    var taille_image = avis.length;

    avis[increment].classList.remove("active");
    avis[increment].classList.add("notActive");

    if(increment == 0){
        increment = taille_image;
    }

    avis[increment - 1].classList.remove("notActive");
    avis[increment - 1].classList.add("active");

    increment = increment - 1;

}