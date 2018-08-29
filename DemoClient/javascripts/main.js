$(function() {

	var $list = $('#list');
	var $name =$('#name');
	var $price =$('#price');
	var $quantity = $('#quantity');

	function addProduct(temp) {
	     $list.append('<li>name : ' + temp.name + ', price: ' + temp.price + ', quantity :' + temp.quantity + '</li>');
	}
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8888/api/products',
        success: function(list) {
            $.each(list, function(i, temp) {
            	addProduct(temp);
            });
        },
        error: function(){
        	alert('error loading list');
        }
    });
    $('#add-product').on('click', function(){
    	var temp = {
    		name: $name.val();
    		price: $price.val();
    		quantity: $quantity.val();
    	};
    	$.ajax({
    		type: 'POST', 
    		url: 'http://localhost:8888/api/products',
    		data: temp,
    		success: function(newProduct) {
    			addProduct(temp);
    		},
    		error: function() {
    			alert('error saving product');
    		}
    	});
    });
});
