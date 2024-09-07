const progress = document.getElementById('progress')
const prev = document.getElementById('prev');
const next = document.getElementById('next');
const circles = document.querySelectorAll('.circle');

let widthProgress = 0;
let value = 1;

next.addEventListener('click', () => {
    widthProgress = widthProgress + 33;
    value++

    if (widthProgress > 0) {
        prev.removeAttribute('disabled');
    }
    if (widthProgress > 98) {
        next.setAttribute('disabled', 'true')
    }

    progress.style.width = `${widthProgress}%`

    update()
})

prev.addEventListener('click', () => {
    widthProgress = widthProgress - 33;
    value--

    if (widthProgress < 99) {
        next.removeAttribute('disabled');
    }
    if (widthProgress < 1) {
        prev.setAttribute('disabled', 'true')
    }

    progress.style.width = `${widthProgress}%`

    update()
})

function update() {
    circles.forEach((circle, idx) => {
        if (idx < value) {
            circle.classList.add('active');
        } else {
            circle.classList.remove('active')
        }
    });
}