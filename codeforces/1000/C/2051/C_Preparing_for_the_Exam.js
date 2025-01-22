class InputReader {
  constructor() {
    const readline = require('readline');
    this.rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
    });
    this.lines = [];
    this.currentLine = 0;
    this.isReady = false;
  }

  async readInput() {
    for await (const line of this.rl) {
      this.lines.push(line);
    }
    this.isReady = true;
    this.rl.close();
  }

  nextLine() {
    return this.lines[this.currentLine++];
  }

  nextInt() {
    return parseInt(this.nextLine());
  }

  nextLineAsIntArray() {
    return this.nextLine().split(' ').map(x => parseInt(x));
  }

  hasNext() {
    return this.currentLine < this.lines.length;
  }
}


async function main() {
  const reader = new InputReader();
  await reader.readInput();

  let t = reader.nextInt();

  while (t-- > 0) {
    const [n, m, k] = reader.nextLineAsIntArray();
    const lists = reader.nextLineAsIntArray();
    const knows = reader.nextLineAsIntArray();

    if (n > k + 1) {
      console.log('0'.repeat(m));
      continue;
    }

    if (n === k) {
      console.log('1'.repeat(m));
      continue;
    }

    solve(m, lists, knows);
  }

  function solve(m, lists, knows) {
    const res = Array(m).fill(0);

    let i = 0;
    let pos = 0;

    while (i < lists.length) {
      let j = pos;
      while (j < knows.length) {
        if (lists[i] <= knows[j]) pos++;
        if (lists[i] === knows[j++]) break; 
      }

      
      if (j === knows.length && lists[i] !== knows[j-1]) {
        res[i]++;
        break;
      }

      i++;
    }

    console.log(res.join(''));
  }
}

main();
