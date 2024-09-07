const left = document.querySelector('.left')
const right = document.querySelector('.right')
const container = document.querySelector('.container')

left.addEventListener("mouseenter", () => container.classList.add('widen-left'))
left.addEventListener("mouseleave", () => container.classList.remove('widen-left'))

right.addEventListener("mouseenter", () => container.classList.add('widen-right'))
right.addEventListener("mouseleave", () => container.classList.remove('widen-right'))