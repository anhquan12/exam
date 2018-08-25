
// var xxx = document.getElementById("xxx");

// var btn = document.getElementById("btn");

// btn.addEventListener("click", function(){
	var ourRequest = new XMLHttpRequest();
	ourRequest.open('GET', 'http://locahost:8668/api/list');
	ourRequest.onload = function(){
		console.log(ourRequest.responseText);
	// var ourData = JSON.parse(ourRequest.responseText);
};
ourRequest.send();
// 	};
// 	ourRequest.send();
// });

// function renderHTML(data) {

// 	var htmlString = "";
// 	for(i=0; i<data.length; i++) {
// 	}
// 	xxx.insertAdjacentHTML('beforeend', htmlString);
// }