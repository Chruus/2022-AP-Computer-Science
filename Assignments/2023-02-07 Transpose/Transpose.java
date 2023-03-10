public class Transpose {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int[][] transposed = new int[5][5];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                arr[r][c] = (int) (Math.random() * 201 - 100);
            }
        }

        System.out.println("Original Matrix");
        for (int[] r : arr) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println("\nTranspose");
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(arr[c][r] + " ");
                //transposed[c][r] = arr[r][c];
            }
            System.out.println();
        }
    }
}