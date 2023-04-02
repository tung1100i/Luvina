package Matrix;

public class detA {
    static void print(float[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

//    static int detMatrix(int[][] X){
//        int det;
//        int tg=0;
//        if(X.length==2)
//            return ;
//        else
//            return detMatrix(int[])
//    }


    public static void main(String[] args) {
        float[][] A = {
                {1, -2, 5, 6, 7},
                {1, 2, 3, 8, 9},
                {3, 1, 52, 12, 13},
                {13, 11, 2, 12, 13},
                {3, 1, 12, 12, 13}};
    }
}
