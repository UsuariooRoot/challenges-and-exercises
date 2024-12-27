public class NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if ((num & 1) == 1) num--;
            else num /= 2;
            steps++;
        }
        return steps;    
    }

    public int numberOfSteps2(int num) {
        if (num == 0) return 0;
        int steps = 0;
        while (num > 0) {
            steps += (num & 1) == 1 ? 2 : 1;
            num >>= 1;
        }
        return steps - 1;
    }
}