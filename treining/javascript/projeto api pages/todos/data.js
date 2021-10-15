const url = "https://jsonplaceholder.typicode.com/todos?userId=" + localStorage.getItem("id");
const todos = document.querySelector(".list");

fetch(url)
.then(resp => { return resp.json() })
.then(data => { 
    data.forEach(todo => {
        generateHtml(todo.title, todo.completed);
    }) 
})
.catch(err => { console.log(err) });

function generateHtml(title, completed){
    let todo = document.querySelector(".todo").cloneNode(true);
    todo.classList.remove("model");
    todo.querySelector("p").innerHTML = title;
    if(completed) todo.querySelector("input").checked = true;
    todos.appendChild(todo);
}