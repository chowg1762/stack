package Assignment3;
/**
 * 
 * @author Wonguen Cho
 * Student ID : 109461283, Recitation No.R04
 * This class has three enum values. Each enum values has BRACE '{', '(', 'for('.
 * When JavascriptFormatter Class is executed, and the format method meets the corresponded character, 
 * This enum value will be used.   
 * This class has one constructor. 
 * 
 * Constructor
 *  - This constructor is just used for declaring enum class. 
 */
public enum BlockType {
	BRACE, 
	PAREN, 
	FOR;	
	/**
	 * This constructor helps the declaring the enum object to use it on stack.
	 */
	BlockType(){
	}
}
