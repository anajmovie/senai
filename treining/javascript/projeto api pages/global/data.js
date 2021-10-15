var username = document.querySelector("#userName");
username.innerHTML = localStorage.getItem("name");

let totodos = document.querySelector("#totodos");
let toalbuns = document.querySelector("#toalbuns");
let toposts = document.querySelector("#toposts");

if(totodos != null){
    totodos.addEventListener("click", () => {
        window.location.href = "/todos";
    });
}

if(toalbuns != null){
    toalbuns.addEventListener("click", () => {
        window.location.href = "/albuns";
    });
}

if(toposts != null){
    toposts.addEventListener("click", () => {
        window.location.href = "/posts";
    });
}
