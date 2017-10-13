package Assignment3;
import java.util.Stack;
import java.util.EmptyStackException;
/**@author Wonguen Cho
* Student ID : 109461283, Recitation No.R04
*
* This class is for stack of the java script formatter. This class will save the parenthesis and brace into the stack.
* In addition, this class can pop the value from stack which is on top of the stack.
* This stack is constructed by linked list, so there are no capacity of the data. 
* 
* Data Field : 
* top
* -this value indicates the top of data in the stack. (That means the last inserted data on linked list)
* 
* Constructor 
*  JSStack()
*  -this constructor initializes the value of top.
* 
* Method
*  push 
*  	- This method inserts new Block Node into Stack on the top of the stack. 
*  
*  pop 
*   - This method removes the value on the top of the stack.
*  
*  peek
* 	- This method gets an information which is on the top of stack. However, it doesn't affect to the sequence of stack. 
* 
*  isEmpty
*   - This method checks the stack is empty or not.
*
*/
public class JSStack extends Stack{
	private BlockNode top;
	/**
	 * This constructor sets the top as null.
	 */
	public JSStack(){
		top = null;
	}
	/**
	 * This methods push the BlockType node into the stack. The new added node must be on the top of the stack.
	 * <dt><b>Postcondition : </b><dd>
	 * The original node on the top is going down lower than new node. 
	 * @param newBlockNode
	 * -This parameter has information whether this value is 'PAREN', 'BRACE', or 'FOR' 
	 */
	public void push(BlockType newBlockNode){
		BlockNode newBlock = new BlockNode(newBlockNode);
		newBlock.setLink(top);
		top = newBlock;
	}
	/**
	 * This method pops the value which is on the top of stack.
	 *  <dt><b>Precondition : </b><dd>
	 *  If stack is null, the error will be displayed
	 *  <dt><b>Postcondition : </b><dd> 
	 *  The value of the under the top will be the value of the top of stack.
	 *  @return
	 *   the data which is on the top before it is popped will be returned
	 * 
	 */
	public BlockType pop(){
		BlockType topOfStack;
		if(top==null)
			throw new EmptyStackException();
		topOfStack = top.getData();
		top = top.getLink();
		return topOfStack;
	}
	
	/**
	 * This method peeks the value which is on the top of stack but the node of the top is still on the top after this method is executed. 
	 *  <dt><b>Precondition : </b><dd>
	 *  If stack is null, the error will be displayed
	 *  <dt><b>Postcondition : </b><dd> 
	 *  The value is still on the top of stack. The sequence is not changed. 
	 *  @return
	 *   the data which currently is on the top will be returned 
	 */
	public BlockType peek(){
		BlockType topOfStack;
		if(top == null)
			throw new EmptyStackException();
		topOfStack = top.getData();
		return topOfStack;
	}
	/**
	 * This methods check whether the stack is empty or not.
	 *  @return
	 *  If the stack has no value this value will return the true.
	 */
	public boolean isEmpty(){
		return (top==null);
	}
}
