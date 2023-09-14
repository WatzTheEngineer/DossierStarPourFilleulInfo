/* ======================================================
                        PARTIE 2
======================================================= */

let imgs = ["https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg","https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Fsundaytimes%2Fprod%2Fweb%2Fbin%2Fe6496bba-3356-11ec-91da-063c6e372e74.jpg?crop=2667%2C1500%2C0%2C0"];
let x=0;

function setCustomInterval() {
    console.log("go");
    interv = window.setInterval(() => {
        console.log("+2s")
        x++;
        document.getElementById("isp").setAttribute("src",imgs[x%imgs.length]);
    }, 2000);
}

function stopTM(){
    console.log("stop");
    window.clearInterval(interv);
}