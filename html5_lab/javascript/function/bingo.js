window.onload = initAll;

function initAll() {
	if (document.getElementById) {
		document.getElementById("pick").onclick = displayNumber;
	}
	else {
		alert("Sorry, your browser doesn't support this script");
	}
}

function displayNumber() {
	var result = generateNumber();

	document.getElementById("number").innerText = `The next BINGO number is: ${result[0]} - ${result[1]}`;
}

function generateNumber() {
	//return Math.floor(Math.random() * 75) + 1;

	var columnLabel = new Array("B", "I", "N", "G", "O");
	var columnIndex = Math.floor(Math.random() * 5);

	var num = Math.floor(Math.random() * 15) + 1 + (columnIndex * 15);
	return new Array(columnLabel[columnIndex], num);

}
