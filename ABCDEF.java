import java.io.*;
import java.util.*;

public class ABCEDF {

    static class Task{
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            HashMap<Long, Long> left = new HashMap<>();
            HashMap<Long, Long> right = new HashMap<>();

            long[] arr = new long[n];
            for(int i = 0; i < n; i++) arr[i] = in.nextLong();

            long count  = 0;
            for(int a = 0; a < n; a++){
                for (int b = 0; b < n; b++){
                    for (int c = 0; c < n; c++){
                        long v = 1, r = (arr[a]*arr[b])+arr[c];
                        if (left.containsKey(r)) v = left.get(r)+1;
                        left.put(r, v);

                        if (arr[c] != 0){
                            v = 1; r = (arr[a]+arr[b])*arr[c];
                            if (right.containsKey(r)) v = right.get(r)+1;
                            right.put(r, v);
                        }
                    }
                }
            }

            for (Long x: left.keySet()){
                if (right.containsKey(x)) count += (left.get(x)*right.get(x));
            }

            System.out.println(count);
        }
    }

    public static void main(String[] args){
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }

    public static class InputReader{
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        InputReader(InputStream inputStream){
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 32768);
            stringTokenizer = null;
        }

        public String next(){
            while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()){
                try{
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                }catch (Exception e){}
            }
            return stringTokenizer.nextToken();
        }

        public String nextLine() throws IOException{
            return bufferedReader.readLine();
        }

        public int nextInt(){
            return  Integer.parseInt(next());
        }

        public long nextLong(){
            return  Long.parseLong(next());
        }

        public float nextFloat(){
            return Float.parseFloat(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
