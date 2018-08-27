$(function() {

	var $list = $('#list');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/list',
        success: function(list) {
            $.each(list, function(i, temp) {
                $list.append('<li>name : ' + temp.name + ', price: ' + temp.price + ', quantity :' + temp.quantity + '</li>');

            });
        }
    });
});
