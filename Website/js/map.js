var map = L.map('mapid').setView([47.579937, -0.430671], 10);
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

var marker = L.marker([47.579937, -0.430671])
    .bindPopup("Les Logis de Beaulieu")
    .addTo(map);
marker.setIcon(L.icon({
    iconUrl: 'https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-red.png',
    popupAnchor: [1, -34],
}));
marker.on("mouseover", function(event) { this.openPopup(); });
marker.on("mouseout", function(event) { this.closePopup(); });

var canoe = L.marker([47.593383, -0.476700])
    .bindPopup("Canoë");
canoe.on("mouseover", function(event) { this.openPopup(); });
canoe.on("mouseout", function(event) { this.closePopup(); });

accrobranche = L.marker([47.580901, -0.373485])
    .bindPopup("Accrobranche");
accrobranche.on("mouseover", function(event) { this.openPopup(); });
accrobranche.on("mouseout", function(event) { this.closePopup(); });

daronne = L.marker([47.549582, -0.398853])
    .bindPopup("La daronne d'Hugo");
daronne.on("mouseover", function(event) { this.openPopup(); });
daronne.on("mouseout", function(event) { this.closePopup(); });

L.layerGroup([canoe, accrobranche, daronne])
    .addTo(map);