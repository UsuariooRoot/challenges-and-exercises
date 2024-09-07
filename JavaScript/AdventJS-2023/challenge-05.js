function cyberReindeer(road, time) {
  let arr = road.split('')
  let list = [road]
  let idx = 0;
  let prev = '.';

  for (let i = 0; i < time - 1; i++) {
    if (i === 4) {
      let newRoad = arr.join('').replace(/\|/g, "*")
      arr = newRoad.split('')
    }
    
    if (arr[idx+1] === '.') {
      arr[idx+1] = 'S'
      arr[idx] = prev
      prev = '.'
      list.push(arr.join(''))
      idx++
    } else if (arr[idx+1] === '*') {
      arr[idx+1] = 'S'
      arr[idx] = prev
      prev = '*'
      list.push(arr.join(''))
      idx++
    } else {
      list.push(arr.join(''))
    }
  } 

  return list
}

const road = 'S..|...|..'
const time = 10
const result = cyberReindeer(road, time)
console.log(result)




/* -> result:
[
  'S..|...|..', // estado inicial
  '.S.|...|..', // avanza el trineo la carretera
  '..S|...|..', // avanza el trineo la carretera
  '..S|...|..', // el trineo para en la barrera
  '..S|...|..', // el trineo para en la barrera
  '...S...*..', // se abre la barrera, el trineo avanza
  '...*S..*..', // avanza el trineo la carretera
  '...*.S.*..', // avanza el trineo la carretera
  '...*..S*..', // avanza el trineo la carretera
  '...*...S..', // avanza por la barrera abierta
]
*/