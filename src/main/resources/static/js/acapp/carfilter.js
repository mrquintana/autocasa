Number.prototype.formatMoney = function(c, d, t){
var n = this, 
    c = isNaN(c = Math.abs(c)) ? 2 : c, 
    d = d == undefined ? "." : d, 
    t = t == undefined ? "," : t, 
    s = n < 0 ? "-" : "", 
    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
    j = (j = i.length) > 3 ? j % 3 : 0;
   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
 };
 
 
$(document).ready(function() {
	var itemsBrands = [];
	//get states data
	$.getJSON( "data/estados.json", function( data ) {
			var itemsStates = [];
		  $.each(data, function( index, value ) {
			  $.each(value, function( iindex, ivalue ) {
				  itemsStates.push({id:iindex, text:ivalue});
				});
			});
		  $("#selectState").select2({ data: itemsStates });
		});
	
	//get brands
	$.getJSON( "data/marcamodelos.json", function( data ) {
	  $.each(data, function( index, value ) {
		  itemsBrands.push({id:index, text:value.marca, models:value.modelos});
		});
	  $("#selectBrand").select2({ data: itemsBrands });
	});
	
	//given a brand or brands, select their models
	$("#selectBrand").select2().on("change", function(e) {
		if($('#selectBrand').val()){
		var modelsFromBrands = [];
		var brandsSelected = $('#selectBrand').val();
		var index;
		for(index = 0; index < brandsSelected.length; ++index){
			modelsFromBrands = modelsFromBrands.concat(itemsBrands[brandsSelected[index]].models);
		}
		
		//hold previously selected models
		var holdPrevModels = $("#selectModel").val();
		$("#selectModel").empty();
		$("#selectModel").select2({data:modelsFromBrands});
		
		//insert again the previosly selected models
		$("#selectModel").val(holdPrevModels).trigger('change');
		}else{
			$("#selectModel").empty();
		}
    });
	
	var years = [];
	for(var index = new Date().getFullYear()+1; index > 1940; --index){
		years.push(index);
	}
	$("#selectYearMin, #selectYearMax").select2({ data: years });
	
	var prices = [];
	for(var index = 0; index <= 100000; index+=10000){
		prices.push('$'+(index).formatMoney(0));
	}
	for(var index = 125000; index <= 500000; index+=25000){
		prices.push('$'+(index).formatMoney(0));
	}
	for(var index = 600000; index <= 1000000; index+=100000){
		prices.push('$'+(index).formatMoney(0));
	}
	$("#selectPriceMin, #selectPriceMax").select2({ data: prices });
});