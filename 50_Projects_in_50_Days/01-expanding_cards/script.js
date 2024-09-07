let divs = document.querySelectorAll(".panel");


divs.forEach(div => {
    div.addEventListener("click", function() {
        removeActiveClasses()
        div.classList.add('active');
    });
})


function removeActiveClasses() {
    divs.forEach(div => {
        div.classList.remove('active')
    })
}