$(document).ready(function() {
	$.getJSON( "data/estados.json", function( data ) {
			var itemsStates = [];
		  $.each(data, function( index, value ) {
			  $.each(value, function( iindex, ivalue ) {
				  itemsStates.push({id:iindex, text:ivalue});
				});
			});
		  $("#selectState").select2({ data: itemsStates });
		});
});