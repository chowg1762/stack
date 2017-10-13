package Assignment3;
import java.util.Scanner;
/**
 * @author Wonguen Cho
*  Student ID : 109461283, Recitation No.R04
 * 
 * This class is driver class for formatting messy Java script code to neatly code.
 * This class get the string from outside file of this java file. 
 * After that this package converts the unformatted String to formatted codes.
 * The converted code will be readable. 
 *  
 *
 */

public class JavascriptFormatterRunner {
	/**
	 * This method is driver method. This method is executed by combining other class such as 
	 * JavascriptFormatter.js, JSStack.js, BlockNode.js, BlockType.js, and TripPlanner.js
	 * 
	 * After executing this class, the unformatted code will be converted to neatly formatted code which is
	 * readable code. 
	 * 
	 * @throws Exception
	 * 	The file has to exist. 
	 */
	public static void main(String[] args) throws Exception{ 
		System.out.println("Welcome to the JavaScript Formatter.");
		System.out.print("Please Enter a filename  : ");
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		boolean isReal = false;
		
		try{
			java.io.File file = new java.io.File(fileName);
			Scanner fromFile = new Scanner(file);
				
			String unformattedString = fromFile.nextLine();
				
			System.out.println(unformattedString);
				
			System.out.println("\n---------------------Properly formatted Program------------------------------\n");
			JavascriptFormatter jsF = new JavascriptFormatter();
			String formattedString = jsF.format(unformattedString);
			
			System.out.println(formattedString);
		}
		catch(Exception ex){
			System.out.println("Invalid FileName\nRestart this program,Please");
		}
		
		System.out.println("--------End--------");
		
	}
	
}
