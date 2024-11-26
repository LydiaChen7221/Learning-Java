public class Main {
	static int y = 3;
	static double[] arr1 = {4.5,6,9.0,8};
	static boolean[] arr2 = new boolean[100];
	static int[][] board = new int[3][3];
	public static void main(String[] args) {
       System.out.println("Hello World");
	   int x = 6;
	   System.out.println(x +4);
	   System.out.println(x);
	   System.out.println(x % 2 == 0);
	   System.out.println("y:" + y);
	   y = y + 4;
	   System.out.println("new y:" + y);
	   System.out.println(arr1.length);
	   System.out.println(arr2[0]);
	   arr2[3] = true;
	   System.out.println(arr2[0]||arr2[3]);
	   System.out.println(arr2.length);
	   int firstVal = board[0][0];
	   System.out.println(firstVal);
	   int[] fib = {1, 1, 2, 3, 5, 8, 13};
		int sum = 0;
		for (int e : fib) {
			sum = sum + e;
		}
		System.out.println(sum);
	   String s = "";
		for (int i = 0; i < 9; i++) {
			s += "- - - - - - - - -\n";
		}
		System.out.println(s);
		int[] arr = {3,7,3,8,1,2,9,5};
		System.out.println(PracticeProblems.countOccurrences(arr, 3));
		int[] arr1 = {1,2,3,4,5};
		System.out.println(PracticeProblems.reverseArray(arr1));
		double [][] grid = new double[3][3];
		System.out.println(PracticeProblems.sumGrid(grid));
		int n = 5;
		System.out.println(PracticeProblems.fib(n));
	   }
	}