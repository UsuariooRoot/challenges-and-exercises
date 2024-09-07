const container = document.querySelector('.container');
const btnOpen = document.getElementById('open');
const btnClose = document.getElementById('close')
const nav = document.getElementById('nav')

btnOpen.addEventListener('click', () => {
    container.classList.add('active');
    btnOpen.classList.add('btnOpen');
    btnClose.classList.add('btnClose')
    nav.classList.add('navShow')
})

btnClose.addEventListener('click', () => {
    container.classList.remove('active');
    btnOpen.classList.remove('btnOpen');
    btnClose.classList.remove('btnClose')
    nav.classList.remove('navShow')
})