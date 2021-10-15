function login(){
    let email = document.querySelector("#email").value;

    let url = "https://jsonplaceholder.typicode.com/users?email=" + email;
    
    fetch(url)
    .then((resp) => { return resp.json() })
    .then(data => {
        if(data.length > 0){
            localStorage.setItem("id", data[0].id);
            localStorage.setItem("name", data[0].name);
            window.location.href = "/posts";
        }else {
            alert("Usuário não cadastrado");
        }
        
    })
    .catch(err => { console.log(err) });
}