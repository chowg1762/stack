package Assignment3;
/**
 * 
 * @author Wonguen Cho
 * Student ID : 109461283, Recitation No.R04
 * 
 * This class executes the stack of Block Node.
 * This stack converts unformatted code to neatly formatted comment.
 * 
 *Data field  
 *stack : 
 *	- this value holds a stack for saving the Block Type value
 *indentLevel
 *	- this integer value count how many tap is needed in the output code
 *inFor
 *	- this boolean value decide whether the parenthesis is 'for' or not. 
 *
 *Constructor
 * JavascriptFormatt() : This constructors initialize the stack which is used in this class
 * 
 *Method
 * format
 * 	- This method get the unformatted string from arguments and converts it to formatted string.
 * printTap 
 * 	 - This method print space('tab') as much as its argument value.
 *
 */
public class JavascriptFormatter {
	private JSStack stack;
	private int indentLevel=0;
	private boolean inFor = false;
	/**
	 * This constructor initializes the stack which saves the enum value . 
	 */
	public JavascriptFormatter(){
		stack = new JSStack();
	}
	
	/**
	 * This method converts unformatted code to formatted code
	 * @param input
	 * 	the arguments input has the unformatted string from an specific file.
	 * @return
	 * 	This method returns neatly-formatted code.
	 * <dt><b>Precondition : </b><dd>
	 *  When pop or peek the item from stack, the stack has to have at least one or more value.
	 *  If the stack is empty error message will be displayed.
	 * 
	 */
	public String format(String input){
		String result = "";
		String checkFor = "";
		String errorMessage = "";
		int charCount=0;
		int lineCount=0;
		boolean isNext=false;
		boolean error = false;
		for(charCount=0; charCount<input.length(); charCount++){
			char currentCharacter = input.charAt(charCount);
			
			switch(currentCharacter){
				case '{':	
						stack.push(BlockType.BRACE);
						indentLevel++;
						result +="{\n";
						lineCount++;
						isNext=true;
						break;
	
				case '(' : 
					checkFor = checkFor+input.charAt(charCount-3)+input.charAt(charCount-2)+
							input.charAt(charCount-1);
					if(checkFor.equals("for")){
						stack.push(BlockType.FOR);
						inFor = true;
					}
					else
						stack.push(BlockType.PAREN);
					result = result+"(";
					checkFor="";
					break;
				case '}' :
						
						indentLevel--;
						result=result+printTap(indentLevel);
						result = result+"}\n";
						lineCount++;
						if(stack.isEmpty()){
							error=true;
							errorMessage = "extra brace found. ";
							break;
						}
						if(stack.pop()==BlockType.PAREN){
							error=true;
							errorMessage = "Missing close Paranthesis in ";
							break;
						}
						break;
						
				case ')' :
						result = result+")";
						if(stack.peek()==BlockType.BRACE||stack.isEmpty()){
							error=true;
							errorMessage = "Extra Parenthesis found ";
							lineCount++;
							break;
						}
						if(stack.pop()==BlockType.FOR)
							inFor = false;
				
						break;
				case ';' : if(!inFor){
								result= result+';'+'\n';
								lineCount++;
							}
							else
								result=result+';';
							isNext=true;
							break;
				case '\n':
					break;
				case '\t':
					break;
				default :
					if(isNext){
						result=result+printTap(indentLevel);
						isNext=false;
					}
					result = result+currentCharacter;
			}
		
			if(error){
				result = result+"\n//Error:"+errorMessage+lineCount;
				break;
			}
		}
		if(!stack.isEmpty()&&charCount==input.length()){
			result = result+"\n//Error : missing closing brace found.";
		}
		return result;
	}
	/**
	 * This method print the tab in front of the code as much as the parameter value
	 * @param indentNumber
	 *  The parameter indicates how many space are needed to insert tab.
	 * @return
	 * the spaces of tab which is added as much as parameter's value
	 */
	public String printTap(int indentNumber){
		String tap="";
		for(int i=0; i<indentNumber; i++)
			tap=tap+'\t';
		return tap;
	}
	
}
