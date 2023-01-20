// Initialisation et affichage de la map
var map = L.map('mapid').setView([47.579937, -0.430671], 10);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

// Marqueur pour le logis en rouge pour le différencier
var marker = L.marker([47.579937, -0.430671])
    .bindPopup("Les Logis de Beaulieu")
    .addTo(map);
marker.setIcon(L.icon({
    iconUrl: 'https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png',
    popupAnchor: [1, -34],
}));
marker.on("mouseover", function(event) { this.openPopup(); });
marker.on("mouseout", function(event) { this.closePopup(); });

// Affichage des marqueurs pour les lieux des différentes activités (page index)
if (window.location.href == "http://localhost:8888/") {
    var chateau = L.marker([47.469917, -0.560008])
        .bindPopup("Château d'Angers")
        .addTo(map);
    chateau.on("mouseover", function(event) { this.openPopup(); });
    chateau.on("mouseout", function(event) { this.closePopup(); });

    accrobranche = L.marker([47.451603, -0.112016])
        .bindPopup("Accrobranche")
        .addTo(map);
    accrobranche.on("mouseover", function(event) { this.openPopup(); });
    accrobranche.on("mouseout", function(event) { this.closePopup(); });

    canoe = L.marker([47.458451, -0.594786])
        .bindPopup("Canöe - Kayak")
        .addTo(map);
    canoe.on("mouseover", function(event) { this.openPopup(); });
    canoe.on("mouseout", function(event) { this.closePopup(); });

    giffard = L.marker([47.504445, -0.578552])
        .bindPopup("Giffard")
        .addTo(map);
    giffard.on("mouseover", function(event) { this.openPopup(); });
    giffard.on("mouseout", function(event) { this.closePopup(); });

    canoe = L.marker([47.493399, -0.550317])
        .bindPopup("ESEO")
        .addTo(map);
    canoe.on("mouseover", function(event) { this.openPopup(); });
    canoe.on("mouseout", function(event) { this.closePopup(); });
}