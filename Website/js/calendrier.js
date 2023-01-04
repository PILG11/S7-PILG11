var date = new Date();

const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

var renderCalendar = () => {
  date.setDate(1);

  var monthDays = document.querySelector(".jours");

  var lastDay = new Date(
    date.getFullYear(),
    date.getMonth() + 1,
    0
  ).getDate();

  var prevLastDay = new Date(
    date.getFullYear(),
    date.getMonth(),
    0
  ).getDate();

  var firstDayIndex = date.getDay();

  var lastDayIndex = new Date(
    date.getFullYear(),
    date.getMonth() + 1,
    0
  ).getDay();

  var nextDays = 7 - lastDayIndex - 1;

  var months = [
    "Janvier",
    "Février",
    "Mars",
    "Avril",
    "Mai",
    "Juin",
    "Juillet",
    "Aout",
    "Septembre",
    "Octobre",
    "Novembre",
    "Décembre",
  ];

  document.querySelector(".date h1").innerHTML = months[date.getMonth()] + ' ' + date.getFullYear();

//   document.querySelector(".date p").innerHTML = new Date().toLocaleDateString('fr-FR', options);
  document.getElementById("date_aujourdhui").innerHTML = new Date().toLocaleDateString('fr-FR', options);

  let days = "";

  for (let x = firstDayIndex; x > 0; x--) {
    days += `<div class="jours-precedents">${prevLastDay - x + 1}</div>`;
  }

  for (let i = 1; i <= lastDay; i++) {
    if (
      i === new Date().getDate() &&
      date.getMonth() === new Date().getMonth()
    ) {
      days += `<div class="aujourdhui">${i}</div>`;
    } else {
      days += `<div>${i}</div>`;
    }
  }

  for (let j = 1; j <= nextDays; j++) {
    days += `<div class="jours-suivants">${j}</div>`;
  }
  monthDays.innerHTML = days;
};

document.querySelector(".prev").addEventListener("click", () => {
  date.setMonth(date.getMonth() - 1);
  renderCalendar();
});

document.querySelector(".next").addEventListener("click", () => {
  date.setMonth(date.getMonth() + 1);
  renderCalendar();
});

renderCalendar();

function afficherdeplacer(option){
    const titre = document.getElementById('titre_reservation');
    document.getElementById('bloc').style.display = 'block';
    document.getElementById('bloc').scrollIntoView({
        behavior: 'smooth',
        block: 'nearest'
      });
    titre.innerHTML = option;
    titre.style.textAlign = 'center';
    titre.style.fontSize = '18px';
}

window.addEventListener('load', function() {
    const calendrier = document.getElementById('bloc');
    calendrier.style.display = 'none';
  });