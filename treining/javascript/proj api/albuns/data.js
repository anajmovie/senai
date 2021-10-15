const url = "https://jsonplaceholder.typicode.com/albums?userId=" + localStorage.getItem("id");
const albuns = document.querySelector(".list");

fetch(url)
.then(resp => { return resp.json() })
.then(data => {
    data.forEach(album => {
        generateHtml(album.title);
    })
})
.catch(err => { console.log(err) });

/*fetch(urlfoto)
.then(resp => { return resp.json() })
.then(data => {
    let album = document.querySelector(".album");
    data.forEach(foto => {
        let img = document.createElement("img");
        img.style.width = '100px';
        img.src = foto.url;
        album.appendChild(img);
    })
})
.catch(err => { console.log(err) });
*/

function generateHtml(title){
    let album = document.querySelector(".album").cloneNode(true);
    album.classList.remove("model");
    album.querySelector("p").innerHTML = title;
    album.addEventListener("click", () => {
        
    })
    albuns.appendChild(album);
}

