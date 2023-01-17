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


  document.addEventListener("DOMContentLoaded", function() {

    var from_$input = $('#input_from').pickadate(),
      from_picker = from_$input.pickadate('picker')
  
    var to_$input = $('#input_to').pickadate(),
      to_picker = to_$input.pickadate('picker')
  
  
    // Check if there’s a “from” or “to” date to start with.
    if ( from_picker.get('value') ) {
      to_picker.set('min', from_picker.get('select'))
    }
    if ( to_picker.get('value') ) {
      from_picker.set('max', to_picker.get('select'))
    }
  
    // When something is selected, update the “from” and “to” limits.
    from_picker.on('set', function(event) {

      if ( event.select ) {
        to_picker.set('min', from_picker.get('select')) 
      }
      else if ( 'clear' in event ) {
        to_picker.set('min', false)
      }
    })
    to_picker.on('set', function(event) {

      if ( event.select ) {
        from_picker.set('max', to_picker.get('select'))
      }
      else if ( 'clear' in event ) {
        from_picker.set('max', false)
      }
    })
  
    document.querySelector('[aria-label="19 Janvier, 2023"]').classList.add("selected-date");

  });
 
