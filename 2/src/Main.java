import java.io.*;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input_nm = reader.readLine().split(" ");
        int n = Integer.parseInt(input_nm[0]);
        int m = Integer.parseInt(input_nm[1]);

        int[][] arr = new int[n][m];
        int[][] arr_d = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input  = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        arr_d[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            arr_d[i][0] = arr[i][0] + arr_d[i-1][0];
        }

        for (int j = 1; j < m; j++) {
            arr_d[0][j] = arr[0][j] + arr_d[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr_d[i][j] = min(arr_d[i - 1][j], arr_d[i][j - 1]) + arr[i][j];
            }
        }
        writer.write(String.valueOf(arr_d[n - 1][m - 1]));
        reader.close();
        writer.close();
    }
}