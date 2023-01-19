var increment = 0;
const images = document.getElementsByName("image_post");
    
function defilement_gauche(){

    var taille_image = images.length;

    images[increment].classList.remove("active");
    images[increment].classList.add("notActive");

    if(increment == taille_image-1){
        increment = -1;
    }

    images[increment + 1].classList.remove("notActive");
    images[increment + 1].classList.add("active");

    increment = increment + 1;

}

function defilement_droite(){

    var taille_image = images.length;

    images[increment].classList.remove("active");
    images[increment].classList.add("notActive");

    if(increment == 0){
        increment = taille_image;
    }

    images[increment - 1].classList.remove("notActive");
    images[increment - 1].classList.add("active");

    increment = increment - 1;

}