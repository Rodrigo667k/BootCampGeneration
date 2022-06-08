/*
Por Tag: getElementbyTagName()
por id: getElementByid()
por nome: getElementsByName()
por Classe: getElementByClassName()
por seletor: querySelector()
*/

let nome = window.document.getElementById('nome')
let email = document.querySelector('#email') 
let assunto = document.querySelector('#assunto')
let nomeOk = false
let emailOk = false
let assuntoOk = false
let mapa = document.querySelector("#mapa")

nome.style.width = '100%'
email.style.width = '100%'

function validaNome() {
    let txtNome = document.querySelector("#txtNome")
    if (nome.value.length <= 2){
        txtNome.innerHTML = "nome invalido"
        txtNome.style.color = "red"
    }else{
        txtNome.innerHTML = "nome valido"
        txtNome.style.color = "blue"
        nomeOk = true
    }


}
function validaEmail(){
    let txtEmail = document.querySelector("#txtEmail")
    if (email.value.indexOf("@") == -1 || email.Value.indexOf(".") == -1) {
        txtEmail.innerHTML = "email invalido"
        txtEmail.style.color = "red"
    } else {
    txtEmail.innerHTML = "email valido"
    txtEmail.style.color = "blue"
    emailOk = true

    }
}
function validaAssunto(){
    let txtAssunto = document.querySelector("#txtaAssunto")
    if (assunto.value.length >= 100){
        txtAssunto.innerHTML = "Texto muito grande por favor digite no maximo 100 caracteres"
        txtAssunto.color.Value = "red"
        txtAssunto.style.display = "block"


    }else{
        txtAssunto.style.display = "none"
        assuntoOk = true
    }
}
function enviar(){
    if(nomeOk == true && emailOk == true && assuntoOk == true){
        alert ("Formulario enviado com sucesso ")
    }else{
        alert("preencha o formulario corretamente")
    }
}
function zoom(){
    mapa.style.width = "800px"
    mapa.style.height= "600px"

}
function normal(){
    mapa.style.width = "600px"
    mapa.style.height= "400px"

}
