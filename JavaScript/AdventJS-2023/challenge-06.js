// function maxDistance(movements) {
//   let right = 0
//   let left = 0  

//   for (let move of movements) {
//     if (move === ">") right++ 
//     else if (move === "<") left++
//   }

//   let asterisk = movements.length - (right + left)
//   return right > left ? right + asterisk - left : left + asterisk - right
// }

// function maxDistance(movements) {
//   movements = movements.split("")
//   const right = movements.reduce((total, move) => 
//     move === ">" ? total + 1 : total, 0)
  
//   const left = movements.reduce((total, move) =>
//     move === "<" ? total + 1 : total, 0)

//   let asterisk = movements.length - (right + left)
//   return right > left ? right + asterisk - left : left + asterisk - right
// }

const movements = '>>*<'
const result = maxDistance(movements)
console.log(result) // -> 2

const movements2 = '<<<>'
const result2 = maxDistance(movements2)
console.log(result2) // -> 2

const movements3 = '>***>'
const result3 = maxDistance(movements3)
console.log(result3) // -> 5

