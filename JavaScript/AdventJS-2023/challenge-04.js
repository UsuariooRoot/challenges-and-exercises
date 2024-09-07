// function decode(string) {
//   return string.slice(string.indexOf('(') + 1, string.indexOf(')'));
// }

function decode(string) {



}
function isParenthesisSyntaxCorrect(string) {
  let text = ""
  let stack = []
  return string.filter((char, i) => {
    if (char === '(') {
      stack.push(char)
      return
    } else if (char === ')') {
      
    }


  }) ;
}

// console.log(isParenthesisSyntaxCorrect('((texto)'))// false
// console.log(isParenthesisSyntaxCorrect('((dsds(dsdsds)sdsds))')) // true
// console.log(isParenthesisSyntaxCorrect('((())')) //false
// console.log(isParenthesisSyntaxCorrect('(()(((()))()()())')) // true


const a = decode('hola (odnum)')
console.log(a) // hola mundo

const b = decode('(olleh) (dlrow)!')
console.log(b) // hello world!

const c = decode('sa(u(cla)atn)s')
console.log(c) // santaclaus

