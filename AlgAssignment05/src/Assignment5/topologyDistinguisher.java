package Assignment5;
import java.util.Arrays;

public class topologyDistinguisher {

	public static String topologyType(Boolean Array[][]) {
		
		//Creates an array to store the number of neighbors for each node
		int numNeighbors[] = new int[Array.length];
		
		//Sets initial number of neighbors for each node to 0
		Arrays.fill(numNeighbors, 0);
		
		//Iterates through each index of Array
		for(int i = 0; i < Array.length; i++) {
			for(int j = 0; j < Array.length; j++) {
				if(j == i) {
					//If a node is its own neighbor returns false as none of the defined topology types have a node with itself as a neighbor
					if(Array[i][j] == true) {
						return "None";
					}
				}else if(j!=i) {
					//If the current index's value is true adds one to the current node's neighbor count
					if(Array[i][j] == true) {
						numNeighbors[i] += 1;
					} } } } 
		
		//If the first node has 2 neighbors checks to see if all other nodes have 2 neighbors
		if(numNeighbors[0] == 2) {
			//Iterates through the rest of the indices 
			for(int k = 1; k < numNeighbors.length; k++) {
				//If any node does not have exactly 2 neighbors none is returned
				if(numNeighbors[k] != 2) {
					return "None";
					//Checks to see if it is the last index of the array
				}else if (k == numNeighbors.length-1) {
					//If the last index is 2 returns ring
					if(numNeighbors[k] == 2) {
						return "Ring";
					}
				}
			}
			//Checks to see if the first index has n-1 neighbors
		}else if(numNeighbors[0] == numNeighbors.length-1) {
			//If the first two indices have n-1 neighbors checks to see if all indices have n-1 neighbors
			if(numNeighbors[1] == numNeighbors.length-1) {
				for(int m = 2; m < numNeighbors.length; m++) {
					//If any index does not have n-1 neighbors returns none
					if(numNeighbors[m] != numNeighbors.length-1) {
						return "None";
						//If the last index has n-1 neighbors returns mesh
					}else if(m == numNeighbors.length-1) {
						if(numNeighbors[m] == numNeighbors.length-1) {
							return "Mesh";
						}
					}
				}
				//If the second index has 1 neighbors checks to see if it is a star
			}else if(numNeighbors[1] == 1) {
				for(int n = 2; n < numNeighbors.length; n++) {
					//If any node doesn't have exactly one neighbor returns none
					if(numNeighbors[n] != 1) {
						return "None";
						//If the last index has exactly 1 neighbors returns star
					}else if(n == numNeighbors.length-1) {
						if(numNeighbors[n] == 1) {
							return "Star";
						}
					}
				}
			}
			//If the first index is 1 checks to see if it is a star
		}else if(numNeighbors[0] == 1) {
			//Creates a boolean to keep track if the center of the star has been found or not
			boolean centerLocated = false;
			//Iterates through every index of numNeighbors
			for(int p = 1; p < numNeighbors.length; p++) {
				//If the current node has n-1 neighbors checks to see if another node also has n-1 neighbors, if so returns "none"
				if(numNeighbors[p] == numNeighbors.length-1) {
					if(centerLocated == false) {
						centerLocated = true;
					}else if(centerLocated = true) {
						return "None";
					}
					//If a node doesn't have a value of 1 returns "none"
				}else if(numNeighbors[p] != 1) {
					return "None";
					//Checks the value of the last index
				}else if(p == numNeighbors.length-1) {
					//If the last index has n-1 neighbors and a center has already been located returns "none"
					if(numNeighbors[p] == numNeighbors.length-1 && centerLocated == true) {
						return "None";
					//If the last index has n-1 neighbors and a center hasn't already been located returns "star"
					}else if(numNeighbors[p] == numNeighbors.length-1 && centerLocated == false) {
						return "Star";
					//If the last index has 1 neighbor and a center has already been located returns "Star"
					}else if(numNeighbors[p] == 1 && centerLocated == true) {
						return "Star";
					}
				}
			}
		}
		return "None";
	}
	
	public static void main(String[] args) {
		Boolean Array[][] = new Boolean[5][5];
		
		Array[0][0] = false;
		Array[0][1] = true;
		Array[0][2] = false;
		Array[0][3] = false;
		Array[0][4] = false;
		Array[1][0] = true;
		Array[1][1] = false;
		Array[1][2] = true;
		Array[1][3] = true;
		Array[1][4] = true;
		Array[2][0] = false;
		Array[2][1] = true;
		Array[2][2] = false;
		Array[2][3] = false;
		Array[2][4] = false;
		Array[3][0] = false;
		Array[3][1] = true;
		Array[3][2] = false;
		Array[3][3] = false;
		Array[3][4] = false;
		Array[4][0] = false;
		Array[4][1] = true;
		Array[4][2] = false;
		Array[4][3] = false;
		Array[4][4] = false;
		
		System.out.print(topologyType(Array));

	}

}
