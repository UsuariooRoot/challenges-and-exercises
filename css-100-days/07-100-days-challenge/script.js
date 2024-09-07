const menuIcon = document.getElementById('menu__icon')
const st = document.getElementById('st')
const menu = document.getElementById("menu")

menuIcon.addEventListener('click', () => {
  st.classList.toggle('st-tranlate')
  menu.classList.toggle('menu-translate')
})
