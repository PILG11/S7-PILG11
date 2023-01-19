const indication = document.getElementsByName("indication");

function onglet(option){

    const chambreDiv = document.getElementById("Chambres"); 
    const salleDesFetesDiv = document.getElementById("SalleDesFetes");
    const formulesDiv = document.getElementById("Formules");


    // 1 --- CHAMBRES
    // 2 --- SALLE DES FETES
    // 3 --- FORMULES

    if(option === 'chambres'){

        indication[0].classList.remove("buttonNotActive");
        indication[0].classList.add("buttonActive");

        indication[1].classList.remove("buttonActive");
        indication[2].classList.remove("buttonActive");

        indication[1].classList.add("buttonNotActive");
        indication[2].classList.add("buttonNotActive");

        formulesDiv.style.display = "none";
        salleDesFetesDiv.style.display = "none";
        chambreDiv.style.display = "flex";
    }

    if(option === 'salledesfetes'){

        indication[1].classList.remove("buttonNotActive");
        indication[1].classList.add("buttonActive");

        indication[2].classList.remove("buttonActive");
        indication[0].classList.remove("buttonActive");

        indication[0].classList.add("buttonNotActive");
        indication[2].classList.add("buttonNotActive");

        formulesDiv.style.display = "none";
        salleDesFetesDiv.style.display = "flex";
        chambreDiv.style.display = "none";
    }

    if(option === 'formules'){

        indication[2].classList.remove("buttonNotActive");
        indication[2].classList.add("buttonActive");

        indication[1].classList.remove("buttonActive");
        indication[0].classList.remove("buttonActive");

        indication[1].classList.add("buttonNotActive");
        indication[0].classList.add("buttonNotActive");

        formulesDiv.style.display = "flex";
        salleDesFetesDiv.style.display = "none";
        chambreDiv.style.display = "none";
    }
}