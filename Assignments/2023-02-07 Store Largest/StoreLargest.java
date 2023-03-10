public class StoreLargest {
    public static void main(String[] args) {
        int[][] arr1 = new int[4][4];
        int[][] arr2 = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                arr1[r][c] = (int) (Math.random() * 10);
                arr2[r][c] = (int) (Math.random() * 10);
            }
        }

        System.out.println("\nMatrix 1");
        for (int[] r : arr1) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix 2");
        for (int[] r : arr2) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        int[][] arrCombined = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (arr1[r][c] > arr2[r][c])
                    arrCombined[r][c] = arr1[r][c];
                else
                    arrCombined[r][c] = arr2[r][c];
            }
        }

        System.out.println("\nLargest Elements");
        for (int[] r : arrCombined) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}