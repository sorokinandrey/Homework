package desktop.p3;

public class Random {

    public static void main(String[] args) {
        int[][] randomArr = new int[4][3];
        for (int i = 0; i < randomArr.length; i++) {
            for (int j = 0; j < randomArr[i].length; j++) {
                randomArr[i][j] = (int) (Math.random() * 10 - 5);
            }
        }
        for (int[] row : randomArr) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

}
