package Assignment5;

public class PolynomialSolver {
	/*
	 * Input: powArray is an array of the powers of the polynomial starting from the smallest value
	 * 		  coArray is an array of the coefficients of the polynomial in the corresponding order of their powers 
	 * 		  x is the value of x which you are solving for 
	 * Output: the solution to the polynomial for the given value x 
	 */
	public static int polynomialSolver(int[] coArray, int[] powArray, int x) {
		
		//Sets initial value of x to 1
		int previousX = 1;
		
		//Sets initial value of the solution to 0
		int solution = 0;
		
		//iterates through each power of x
		for(int i = 0; i < powArray.length; i++) {
			//If it is the first iteration this block of code is executed to avoid an out of bounds error
			if (i == 0) {
				//Gets the exponential value of x for the give power
				for(int j = 0; j < powArray[i]; j++) {
					previousX = previousX * x;
					//Adds x to the given power times its coefficient to the solution
					solution = solution + (previousX * coArray[i]);
				}
			}if (1 <= i) {
				/*
				 * Given that previous powers of x have already been calculated this for loop only runs for the difference of powers between the current and 
				 * last index of powArray
				 */
				for(int k = 0; k < (powArray[i]-powArray[i-1]); k++) {
					//Calculates the given power of X
					previousX = previousX * x;
					//Adds x to the given power times its coefficient to the solution
					solution = solution + (previousX * coArray[i]);
				}
			}
		}
		return solution;
	}
	
	public static void main(String[] args) {
		int[] coArray = new int[] {1,2,3,7};
		
		int[] powArray = new int[] {1,2,3,7};
		
		int x = 2;
		
		System.out.print(polynomialSolver(coArray, powArray, x));
	}
}
