var productContainer = document.getElementById("proList");
var btn = document.getElementById("btn");

btn.addEventListener("click", function() {

    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8080/api/list', true);
    ourRequest.onload = function() {
        var ourData = JSON.parse(ourRequest.responseText);
        renderHTML(ourData);
    };
    ourRequest.send();
});

function renderHTML(data) {

    var htmlContent = "this is a test insert data but wtf , not printf @@ ";
    productContainer.insertAdjacentHTML('beforeend', htmlContent);
}

