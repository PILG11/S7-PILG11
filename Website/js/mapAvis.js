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