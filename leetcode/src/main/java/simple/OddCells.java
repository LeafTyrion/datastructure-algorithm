package simple;

/**
 * @author YeYaqiao
 * 1252. 奇数值单元格的数目
 */
public class OddCells {

    public int oddCells(int n, int m, int[][] indices) {

        int result = 0;
        int[][] matrix = new int[n][m];

        for (int[] index : indices) {

            for (int x = 0; x < n; x++) {

                matrix[x][index[1]]++;

            }

            for (int y = 0; y < m; y++) {
                matrix[index[0]][y]++;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result += matrix[i][j] % 2;
            }
        }

        return result;
    }

}
