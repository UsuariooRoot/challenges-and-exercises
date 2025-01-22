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

    // Método para leer todas las entradas
    async readInput() {
        for await (const line of this.rl) {
            this.lines.push(line);
        }
        this.isReady = true;
        this.rl.close();
    }

    // Obtener la siguiente línea
    nextLine() {
        return this.lines[this.currentLine++];
    }

    // Obtener el siguiente entero
    nextInt() {
        return parseInt(this.nextLine());
    }

    // Obtener array de enteros de una línea
    nextLineAsIntArray() {
        return this.nextLine().split(' ').map(x => parseInt(x));
    }

    // Verificar si hay más líneas
    hasNext() {
        return this.currentLine < this.lines.length;
    }
}