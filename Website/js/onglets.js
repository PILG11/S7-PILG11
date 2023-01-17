const indication = document.getElementsByName("indication");

function onglet(option){

    const chambreDiv = document.getElementById("Chambres"); 
    const salleDesFetesDiv = document.getElementById("SalleDesFetes");
    const formulesDiv = document.getElementById("Formules");


    // 1 --- CHAMBRES
    // 2 --- SALLE DES FETES
    // 3 --- FORMULES

    if(option === 'chambres'){

        indication[0].classList.remove("notActive");
        indication[0].classList.add("active");

        indication[1].classList.remove("active");
        indication[2].classList.remove("active");

        indication[1].classList.add("notActive");
        indication[2].classList.add("notActive");

        formulesDiv.style.display = "none";
        salleDesFetesDiv.style.display = "none";
        chambreDiv.style.display = "flex";
    }

    if(option === 'salledesfetes'){

        indication[1].classList.remove("notActive");
        indication[1].classList.add("active");

        indication[2].classList.remove("active");
        indication[0].classList.remove("active");

        indication[0].classList.add("notActive");
        indication[2].classList.add("notActive");

        formulesDiv.style.display = "none";
        salleDesFetesDiv.style.display = "flex";
        chambreDiv.style.display = "none";
    }

    if(option === 'formules'){

        indication[2].classList.remove("notActive");
        indication[2].classList.add("active");

        indication[1].classList.remove("active");
        indication[0].classList.remove("active");

        indication[1].classList.add("notActive");
        indication[0].classList.add("notActive");

        formulesDiv.style.display = "flex";
        salleDesFetesDiv.style.display = "none";
        chambreDiv.style.display = "none";
    }
}