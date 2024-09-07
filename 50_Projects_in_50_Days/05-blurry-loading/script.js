const loading = document.querySelector('.loading-text');

let percentage = 0
let backdrop = 100

const intPercentage = setInterval(updatePercentage, 30)
const intBackdrop = setInterval(updateBackdrop, 30)

function updatePercentage() {
    percentage++
    loading.textContent = `${percentage}%`
    
    if (percentage > 99) {
        clearInterval(intPercentage)
    }
}

function updateBackdrop() {
    backdrop--
    loading.style.backdropFilter = `blur(${backdrop/5}px)`

    if (backdrop < 50) {
        loading.style.opacity = `${backdrop/30}`
    }

    if (backdrop < 1) {
        clearInterval(intBackdrop)
    }
}


