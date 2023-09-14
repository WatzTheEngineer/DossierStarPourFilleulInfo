window.onload = () => {
    alert("loading");
    document.getElementById("isp").hidden = false;
}

function chgVis() {
    var state = ""
    if (document.getElementById("isp").style.visibility == "hidden") {
        state = "visible"
    }else{
        state = "hidden"
    }
    document.getElementById("isp").style.visibility = state;
}