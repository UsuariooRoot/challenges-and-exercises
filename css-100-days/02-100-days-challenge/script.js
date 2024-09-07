// const div = document.querySelector('.center');

// div.addEventListener('click', () => {
//   div.classList.toggle('equis')
//   if (!div.classList.contains('equis')) {
//     div.classList.add('rev-animation')
//   } else {
//     div.classList.remove('rev-animation')
//   }
// })


function toggleHamburguesa(div) {
  div.classList.toggle('equis')
  if (!div.classList.contains('equis')) {
    div.classList.add('rev-animation')
  } else {
    div.classList.remove('rev-animation')
  }
}