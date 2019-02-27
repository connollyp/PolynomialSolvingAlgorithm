package Assignment5;

public class StringMatchVisualization {
	
	public static void stringMatch(String text, String key) {
		
		
		text = text.toLowerCase();										//Converts the text to lower case to take away variability
		
		key = key.toLowerCase();										//Converts the target key to lower case to take away variability
		
		char[] textArray = text.toCharArray();							//Converts the text to a character array
		
		char[] keyArray = key.toCharArray();							//Converts the key to a character array
		
		System.out.println(text);										//Echos the text to the console
		
		for(int i = 0; i < textArray.length-1; i++) {					//Iterates through every character of the text
			int textTracker = i;										//Initializes the variable textTracker to keep track of the current index of the text
			for(int k = 0; k < i; k++) {								//Prints a space for the number of text characters already checked
				System.out.print(" ");
			}
			for(int m = 0; m < keyArray.length-1; m++) {				//iterates through every index of the key 
				System.out.print(keyArray[m]);							//Echos the first character of the key to the console
				if(keyArray[m] == textArray[textTracker]) {				//Checks to see if the first key character equals the current text character
					textTracker++;										//Increments textTracker
					for(int m2 = m+1; m2 < keyArray.length-m; m2++) {	//Iterates through the rest of the key
						if(keyArray[m2] == textArray[textTracker]) {	//Checks to see if the current key character matches the current text character
							System.out.print(keyArray[m2]);				//Echos current key character to the console
							textTracker++;								//Increments the textTracker
						}
					}
				}else {													//If the characters don't match
					continue;											//Breaks the current loop
				}
			}
			System.out.println();										//Prints a new line
		}
		
	}
	
	public static void main(String[] args) {
		
		stringMatch("thtthethe", "he");
	}

}
