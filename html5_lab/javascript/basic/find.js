window.onload = initAll;

function initAll() {
	document.getElementById("findById").onclick = findById;
}

function findById() {
    var id = document.getElementById("id_value").value;    
    var element = document.getElementById(id);

    if(element != null){
        element.style.backgroundColor = "yellow";
    }else{
        alert("Could not find the element");
    }
}

