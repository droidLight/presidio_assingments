window.onload = initAll;

function initAll() {	

	var ans = prompt("Enter a positive number","");	
	try{
		if(ans < 0 || isNaN(ans) || ans == null){
			throw new Error("Invalid number");
		}			
		var sqrt = Math.sqrt(ans);
		var msg = `Square root of ${ans} is ${sqrt}`;
		document.write(msg);
		alert(msg);
	}catch(error){
		alert(error.message);
	}
}