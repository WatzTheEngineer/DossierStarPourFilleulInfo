window.onload = () => {
    console.log("onload")
};
document.getElementById("img1").onmouseenter = () => {
    //console.log("onover")
    document.getElementById("img1").setAttribute("src","https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Fsundaytimes%2Fprod%2Fweb%2Fbin%2Fe6496bba-3356-11ec-91da-063c6e372e74.jpg?crop=2667%2C1500%2C0%2C0")
};
document.getElementById("but").onclick = () => {
    console.log("clic")
    document.body.style.backgroundColor = "red";
    document.getElementById("but").style.color = "blue";
    document.getElementById("but").style.backgroundColor = "whitesmoke";
}
document.getElementById("r").onclick = () => {
    document.body.style.backgroundColor = "";
    document.getElementById("but").style.color = "";
    document.getElementById("but").style.backgroundColor = "";
}
document.onkeydown = () => {
    alert("key")
}
document.getElementById("img1").onmouseleave = () => {
    //console.log("onleave")
    document.getElementById("img1").setAttribute("src","https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg")
};