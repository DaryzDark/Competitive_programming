import java.io.*;

import static java.lang.Math.max;

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
                arr_d[i][j] = max(arr_d[i - 1][j], arr_d[i][j - 1]) + arr[i][j];
            }
        }
        String[] path = new String[n + m - 2];
        int curr_stateX = n - 1, curr_stateY = m - 1;
        for (int i = n + m - 3; i >= 0; i--) {
            if (curr_stateX > 0 && curr_stateY > 0) {
                if (arr_d[curr_stateX-1][curr_stateY] > arr_d[curr_stateX][curr_stateY-1]) {
                    path[i] = "D";
                    curr_stateX--;
                } else {
                    path[i] = "R";
                    curr_stateY--;
                }
            } else {
                break;
            }
        }
        int k = 0;
        while (curr_stateX != 0) {
            path[k] = "D";
            k++;
            curr_stateX--;
        }

        k = 0;
        while (curr_stateY != 0) {
            path[k] = "R";
            k++;
            curr_stateY--;
        }
        writer.write(String.valueOf(arr_d[n - 1][m - 1]));
        writer.write("\n");
        for (int i = 0; i < path.length; i++)
            writer.write(path[i] + " ");
        reader.close();
        writer.close();
    }
}