function note() {

    const etoile1 = document.getElementsByName("etoile1");
    const etoile2 = document.getElementsByName("etoile2");
    const etoile3 = document.getElementsByName("etoile3");
    const etoile4 = document.getElementsByName("etoile4");
    const etoile5 = document.getElementsByName("etoile5");


    if (etoile1) {
        etoile1.style.color = "green";
    }

    if (etoile2) {
        console.log("etoile2")
        etoile1.style.color = "green";
        etoile2.style.color = "green";
    }

    if (numero === etoile3) {
        etoile3.addEventListener("mouseenter", () => {
            etoile1.style.color = "green";
            etoile2.style.color = "green";
            etoile3.style.color = "green";
        });
    }

    if (numero === etoile4) {
        etoile5.addEventListener("mouseenter", () => {
            etoile1.style.color = "green";
            etoile2.style.color = "green";
            etoile3.style.color = "green";
            etoile4.style.color = "green";
        });
    }

    if (numero === etoile5) {
        etoile5.addEventListener("mouseenter", () => {
            etoile1.style.color = "green";
            etoile2.style.color = "green";
            etoile3.style.color = "green";
            etoile4.style.color = "green";
            etoile5.style.color = "green";
        });
    }
}

note();