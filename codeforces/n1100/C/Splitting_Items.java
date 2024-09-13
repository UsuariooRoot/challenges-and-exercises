import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Splitting_Items {
    static FastReader fr = new FastReader();

    public static void main(String[] args) {
        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();

            int[] elements = fr.nextIntArray(n);
            solve(elements, k);
        }

    }

    private static void solve(int[] elements, int k) {
        Arrays.sort(elements);
        int idx = elements.length - 1;
        boolean isPar = elements.length % 2 == 0;
        long alice = 0L;
        long bob = 0L;

        int minIdx = isPar ? 0 : 1;

        while (idx >= minIdx) {
            int a = elements[idx--];
            int b = elements[idx--];
            int curScore = a - b;
            alice += a;
            bob += b + ((curScore > k) ? k : curScore); // parece que por aquí puede estar el error...
        }

        long score = alice - bob;
        long result = isPar ? score : score + elements[0];
        System.out.println(result);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}
