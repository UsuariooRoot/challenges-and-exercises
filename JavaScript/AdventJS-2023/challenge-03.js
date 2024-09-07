// function findNaughtyStep(original, modified) {
//   let letter = "";
//   const arrOriginal = original.split("")
//   const arrModified = modified.split("")

//   let lenghtOriginal = arrOriginal.length
//   let lenghtModified = arrModified.length

//   if (lenghtOriginal > lenghtModified) {
//     for (let i = 0; i < lenghtOriginal; i++) {
//       if (arrOriginal[i] !== arrModified[i]) {
//         letter += arrOriginal[i]
//         break
//       }
//     }  
//   } else if (lenghtModified > lenghtOriginal) {
//     for (let i = 0; i < lenghtModified; i++) {
//       if (arrOriginal[i] !== arrModified[i]) {
//         letter += arrModified[i]
//         break
//       }
//     }  
//   }

//   return letter
// }

// function findNaughtyStep(original, modified) {
//   if (original.length === modified.length) return ""
//   let arrOriginal = original.split("");
//   let arrModified = modified.split("");
//   let idx = 0;
//   for (let i = 0; ((arrOriginal[idx] === arrModified[idx])); i++) {
//     idx++
//   }
//   return ((arrOriginal.length > arrModified.length) ? arrOriginal : arrModified)[idx]
// }

// function findNaughtyStep(original, modified) {
//   // code here
//   const [longerChars,shorterChars] = modified.length > original.length ? 
//   [[...modified],[...original]] :
//   [[...original],[...modified]]

//   return longerChars.find((char, i) => char !== shorterChars[i]) ?? ''
// }


function findNaughtyStep(original, modified) {
  let modifiedSteps = new Set(original.split(""));
  modified
    .split("")
    .forEach((char) => modifiedSteps.delete(char) || modifiedSteps.add(char));
  return Array.from(modifiedSteps)[0] ?? "";
}
const original = 'abcd'
const modified = 'abcde'
console.log(findNaughtyStep(original, modified)) // 'e'

const original2 = 'stepfor'
const modified2 = 'stepor'
console.log(findNaughtyStep(original2, modified2)) // 'f'

const original3 = 'abcde'
const modified3 = 'abcde'
console.log(findNaughtyStep(original3, modified3)) // ''