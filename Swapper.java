
//Mansour Elsharawy
//APCS1 pd3
//HW39 -- Put it Together
//2016-12-04

/*-----------------------------------------------------------
SUMMARY OF OPERATIONS:
1. The main method creates an instance of class Swapper, which upon construction, creates a randomized string Array
2.
  -------------------------------------------------------------*/


import cs1.Keyboard;

public class Swapper{
    public final String alpha = "qwertyuiopasdfghjklzxcvbnm";

    //instance vars
    public String alphabet;
    public String[][] array = new String[5][5];

    //constructor
    public Swapper(){
	alphabet = alpha;
	populate(array);
    }

    //prints contents of an array
    public static String matrixPrint(String[][] arr){
	String retStr = "";
	for(int y = 0;y < arr.length;y++){
	    retStr += y + ": "
	    for(int x = 0;x < arr[y].length;x++){
		retStr += arr[y][x] + " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }    

    //returns a randomized string to have 3 or 4 characters
    public String randomString(){
	String retStr = "";
	int numChar = 3;
	if(Math.random() < 0.5){
	    numChar = 4;
	}
	
	for(int x = 0; x < numChar;x++){
	    String letter;
	    int alphaPos = (int)(Math.random()*alphabet.length());
	    if (alphaPos == 25){
		letter = "m";
	    }
	    else{
	    letter  = alphabet.substring(alphaPos, alphaPos + 1);
	    }
	    retStr += letter;
	}
	return retStr;
	    }

    //populates a given array with random strings
    public void populate(String[][] a){
	for (int y = 0; y < a.length; y++){
	    for(int x =0; x < a[y].length; x++){
		a[y][x] = randomString();

	    }
	}
    }
    
    //swaps two items of an array given the coordinates of each candidate
    public boolean swap(int x1, int y1, int x2, int y2, String[][] a){
	try{
	    String savedString = a[x1][y1];
	    a[x1][y1] = a[x2][y2];
	    a[x2][y2] = savedString;
	    return false;
	}
	catch(Exception e){
	    System.out.println("Invalid Input. Try again\n\n");
	    return true;
	}
	}

    public static void main(String[] args){
	//Driver code
	System.out.println("Import completed.\n");
	Swapper swappy = new Swapper();
	String[][] systemArray = swappy.array;
	boolean doAgain = true;
	while (doAgain == true){
	    System.out.println(matrixPrint(systemArray)+ "\n");
	System.out.println("Row # of 1st swap slot?\n");
	int x1 = Keyboard.readInt();
	System.out.println("Column # of 1st swap slot?\n");
	int y1 = Keyboard.readInt();
	System.out.println("Row # of 2nd swap slot?\n");
	int x2 = Keyboard.readInt();
	System.out.println("Column # of 2nd swap slot?\n");
	int y2 = Keyboard.readInt();
	System.out.println("Swapping...\n");
	doAgain = swappy.swap(x1,y1,x2,y2,systemArray);
	}

        System.out.println(matrixPrint(systemArray) + "\n");

	
	
    }
}
