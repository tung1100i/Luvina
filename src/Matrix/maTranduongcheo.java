package Matrix;

public class maTranduongcheo {


    static void print(float[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static float[][] biendoi(float[][] X){
        // A[1,0..2]
        int i;
        float tg;
        int cot;
        for (cot = 0; cot < X.length-1; cot++) {
            //Thêm giá tuyệt đối LN
            //
            for (i = cot + 1; i < X.length; i++) {
                //tg=-1 ==> tg?    // A[1,0]= A[1,0]+A[0][0]*tg=0
                tg = -X[i][cot] / X[cot][cot];
                for (int j = cot; j < X.length; j++) {
                    X[i][j] = X[i][j] + X[cot][j] * tg;
                }
            }
        }
        return X;
    }




    public static void main(String[] args) {
        float[][] A = {
                {1, -2, 5, 6, 7},
                {1, 2, 3, 8, 9},
                {3, 1, 52, 12, 13},
                {13, 11, 2, 12, 13},
                {3, 1, 12, 12, 13}};
        print(A);
        System.out.println("====================");


        biendoi(A);
        print(A);
        System.out.println("====================");

    }
}
