/* function manufacture(gifts, materials) {
  let toys = []
  const materialSet = new Set(materials)

  gifts.forEach(toy => {
    const toySet = new Set(toy)
    let isIncludes = true
    for (const letra of toySet) {
      if (!materialSet.has(letra)) {
        isIncludes = false
        break
      }
    }

    if (isIncludes) {
      toys.push(toy)
    }
  });

  return console.log(toys)
}
 */

/* 02 */
/* function manufacture(gifts, materials) {
  const materialSet = new Set(materials); 
  let toys = [];

  for (let toy of gifts) {
    let toyArray = [...toy];
    let isIncludes = true;
    
    for (let letter of toyArray) {
      if (!materialSet.has(letter)) {
        isIncludes = false;
        break; 
      }
    }
    
    if(isIncludes) {
      toys.push(toy);
    }
  }

  return toys
} */

/* 03 */
/* function manufacture(gifts, materials) {
  const materialSet = new Set(materials);
  let toys = [];

  for (let toy of gifts) {

    let toyArray = [...toy];
    let idx = 0;
    let isIncludes = true;

    while(idx < toyArray.length) {
      const letter = toyArray[idx];
      if(!materialSet.has(letter)) { 
        isIncludes = false;
        break;  
      }
      idx++;
    }

    if(isIncludes) {
      toys.push(toy);
    }
  }
  return console.log(toys);
} */

/* 04 */
// function manufacture(gifts, materials) {
//   let arr = []
//   let arrL = [...new Set(materials)]
//   for (let gift of gifts) {
//     let spl = [...new Set(gift)]
//     console.log(arrL.includes(spl))
//   }
//   // return arr 
// }

// function manufacture(gifts, materials) {
//   const letters = materials.split('').sort(); 
//   const results = [];
//   for (let gift of gifts) {
//     const giftLetters = gift.split('').sort();
//     if (giftLetters.every(l => letters.includes(l))) {
//       results.push(gift);
//     }
//   }

//   return results;
// }

function manufacture(gifts, materials) {
  const letters = materials.split('').sort();
  
  return gifts.filter(gift => 
    gift.split('').every(l => letters.includes(l))
  );
}

function manufacture(gifts, materials) {

  const regex = new RegExp(`[${materials}]`, 'g');

  return gifts.filter(gift => 
    gift.match(regex)?.join('') === gift
  );
}

function manufacture(gifts, materials) {
  const lettersRegex = new RegExp(`[${materials}]`, 'g');

  return gifts.filter(gift => {
    const sanitized = gift.replace(/[^\w]/g, '');
    return sanitized.length === gift.length;
  }).filter(gift => {
    return gift.match(lettersRegex)?.join('') === gift;
  });
}


const gifts = ['tren', 'oso', 'pelota']
const materials = 'tronesa'

console.log(manufacture(gifts, materials))

const gifts2 = ['juego', 'puzzle']
const materials2 = 'jlepuz'

console.log(manufacture(gifts2, materials2)) // ["puzzle"]

const gifts3 = ['libro', 'ps5']
const materials3 = 'psli'
console.log(manufacture(gifts3, materials3)) // []

// const set = new Set("puzzle")

// console.log(set);
