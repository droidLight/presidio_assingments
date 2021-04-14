window.onload = initAll;

function initAll() {
	var now = new Date();
	console.log(now.toLocaleDateString);

	if(now.toLocaleDateString){
		var date = now.toLocaleDateString();
		var time = now.toLocaleTimeString();

		var msg = "It is: "+time+" on "+date;
		alert(msg);
		document.getElementById("dateString").innerText = msg;
	}else{
		alert("your browser is not supported");
	}
}
