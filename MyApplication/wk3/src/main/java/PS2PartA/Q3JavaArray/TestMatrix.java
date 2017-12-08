package PS2PartA.Q3JavaArray;
// Question 3
// total: 30 points

//===============================================
// todo: complete the following program
//===============================================


public class TestMatrix {
    public static void main(String[] args) {
        double [][] a = {
                {1,2,3},
                {4,5,6}
        };

        double [][] b = {
                {1,2},
                {3,4},
                {5,6}
        };

        double [][] c = matMpy (a,b);

        printMat(c);

        //////

        int [] f = new int [5];
        f[0] = 2;
        f[1] = 5;
        int [] g = {1, 3, 7};

        mergeSortedArray(f, 2, g, 3);

        printMat(f);



    }

    public static void printMat(int [] c) {
        int m;
        m = c.length;
        for (int i = 0; i< m; i++) {
            System.out.print(c[i] + ",  ");
        }
        System.out.println();
    }

    public static void printMat(double [][] c) {
        int m,n;
        m = c.length;
        n = c[0].length;
        for (int i = 0; i< m; i++) {
            for (int j=0; j< n; j++) {
                System.out.print(c[i][j] + ",  ");
            }
            System.out.println();
        }

    }


    public static double [][] matMpy ( double [][] a, double [][] b) {
        //TODO: implement multiplication of the two matrices "a" and "b"
        double[][] c = new double[a.length][b[0].length];
        if (a.length != b[0].length) {
            return null;
        } else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    double add = 0;
                    for (int k = 0; k < a[0].length; k++) {
                        add += a[i][k] * b[k][j];
                    }
                    c[i][j] = add;
                }
            }
            return c;
        }

    }

    public static void mergeSortedArray(int [] a, int m, int [] b, int n) {
        //TODO: implement merging of "b" into "a" to form a single sorted array in ascending order
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(k>=0){
            if(i>=0){
                if(a[i] > b[j]) {
                    a[k] = a[i];
                    i-=1;
                } else {
                    a[k] = b[j];
                    j-=1;
                }
            } else {
                a[k] = b[j];
                j-=1;
            }
            k-=1;
        }
    }
}