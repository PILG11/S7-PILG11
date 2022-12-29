
const chambreDiv = document.getElementById("Chambres"); 
const salleDesFetesDiv = document.getElementById("SalleDesFetes");
const formulesDiv = document.getElementById("Formules");


function onglet(type){

    alert(type.style);

    if(type == "chambres"){
        chambreDiv.style.display = flex;
        salleDesFetesDiv.style.display = none;
        formulesDiv.style.display = none;
    }
    else if(type = "SalleDesFetes"){
        chambreDiv.style.display = none;
        salleDesFetesDiv.style.display = flex;
        formulesDiv.style.display = none;
    }
    else{
        chambreDiv.style.display = none;
        salleDesFetesDiv.style.display = none;
        formulesDiv.style.display = flex;
    }
}