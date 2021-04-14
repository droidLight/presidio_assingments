window.onload = initAll;

function initAll() {

    var ans = prompt("Do you want to tell something?");
    console.log(ans);
    if(ans != null){
        var st = `You said, ${ans}`;
        alert(st)
        document.write(st);
    }else{
        var st = "You did not say anything";
        alert(st);
        document.write(st);
    }
}