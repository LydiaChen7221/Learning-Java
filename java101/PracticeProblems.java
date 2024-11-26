public class PracticeProblems {
    public static int countOccurrences(int[] arr, int n) {
        int count = 0;
        for(int i=0; i < arr.length; i++) {
            if (arr[i] == n) {
                count += 1;
            }
        }
        return count;
    }
    static int[] arr1 = {1,2,3,4,5};
    public static int[] reverseArray(int[] arr1) {
        int[] arr2 = new int[5];
        for(int a=4; a >= 0; a--) {
            for(int e=0; e < arr2.length; e++) {
                arr1[a] = arr2[e];
            }
        }
        return arr2;
    }
    static double [][] grid = new double[3][3];
    public static double sumGrid(double[][] grid) {
        double sum = 0;
        for(int row=0; row < grid.length; row++) {
            for(int col=0; col < grid[row].length; col++) {
                sum = sum + grid[row][col];
            }
        }
    return sum;
    }
    public static int fib(int n) {
        if (n<=1) {
            return 0;
        }
        if (n==2) {
            return 1;
        }
        int num1=0;
        int num2=1;
        for(int x=3; x < n; x++) {
            int fib=num2;
            num2 += num1;
            num1 = fib;
        }
        return num1+num2;
    }
}
