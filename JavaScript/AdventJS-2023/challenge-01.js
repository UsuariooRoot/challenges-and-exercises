// function findFirstRepeated(gifts) {
//   const seenNumbers = {};
  
//   for (const number of gifts) {
//     if (seenNumbers[number]) return number;
    
//     seenNumbers[number] = true;
//   }
  
//   return -1;
// }

// function findFirstRepeated2(gifts) {
//   const seenNumbers = [];

//   for (const number of gifts) {
//     if (seenNumbers.includes(number)) {
//       return number
//     }
//     seenNumbers.push(number)
//   }

//   return -1
// }

// function findFirstRepeated3(gifts) {
//   const set = new Set(gifts)
//   const index = gifts.findIndex((gift, i) => gift !== [...set][i])
//   return gifts[index] ?? -1
// }

// function findFirstRepeated(gifts) {
//   let setG = []

//   for (const g of gifts) {
//     if (setG.includes(g))
//       return g
//     setG.push(g)
//   }
//   return -1;
// }

const gifts = new Array(100000).fill(0);

for (let i = 0; i < 100000; i++) {
  gifts[i] = Math.floor(Math.random() * 100000);
}

console.time()
findFirstRepeated(gifts)
console.timeEnd()

console.time()
findFirstRepeated2(gifts)
console.timeEnd()

console.time()
findFirstRepeated3(gifts)
console.timeEnd()
