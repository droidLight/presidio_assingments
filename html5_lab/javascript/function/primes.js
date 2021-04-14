window.onload = initAll;

function initAll() {
	var ans = prompt("Enter a positive integer greater than 1","10");
	try {
		if (!ans || isNaN(ans) || ans <= 0 || Math.round(ans) != ans) {
			throw new Error("Not a valid number");
		}
		calculatePrime(ans);		
	}
	catch (errMsg) {
		alert(errMsg.message);
	}
}

function calculatePrime(num){
	var resString = "";
	for(var i = 2; i <= num; i++){
		if(testPrime(i)){
			resString += (i+",");
		}
	}
	var index = resString.lastIndexOf(",");
	if(index != -1){
		resString = resString.substring(0, index);		
	}
	displayNumber(num, resString);
}

function testPrime(num){
	var modval = Math.ceil(Math.sqrt(num));
	for(;modval > 1; modval--){
		if(num % modval == 0){
			return false;
		}
	}
	return true;
}

function displayNumber(maxNum, primeString){
	document.write(`The max number is, ${maxNum}`);
	if(primeString.length == 0){
		document.write("No prime numbers were present");
	}else{
		document.write(`The prime numbers are, ${primeString}`);
	}
}