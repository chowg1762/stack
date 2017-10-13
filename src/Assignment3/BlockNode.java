package Assignment3;
/**
 * 
 * @author Wonguen Cho
 *Student ID : 109461283, Recitation No.R04
 * This class prepare linked lists for stack. 
 * The stack's data will be connected by this class's nodes. 
 * This class has mutators and accesor to manipulate the links and data of node.
 *  
 *  Data field 
 *  	- indicator 
 *  		This BlockType data will hold which enum value is contained in the node.
 *      - link
 *      	Link indicates the next node's reference. In this assignment this link indicates the under value of the current node. 
 * 
 *  Constructor 
 *   - BlockNode
 *   	- This constructor initializes the BlockNode with the parameter. 
 *   	   The parameter has value which indicates the BlockType enum values.
 *        In addition, this constructor initializes the link as null.
 *        
 *  Method
 *   - setData
 *   	- This methods sets the node with the value of Block Type. 
 *   - getData
 *   	- This method gives the Block Type's data which holds PAREN, BRACE, or FOR.
 *   - setLink
 *   	- This method sets the link after the node. In the JSStack class this link indicates the under node of the currently added node on the top.
 *   - getLink
 *    	- This method returns the next node's reference
 */		
public class BlockNode {
	private BlockType indicator;
	private BlockNode link;
	
	/**
	 * This constructor initializes the indicator value by parameters
	 * And This sets the link as null. 
	 * @param indicator
	 */
	BlockNode(BlockType indicator){
		this.indicator = indicator;
		link = null;
	}
	/**
	 * This method sets the indicator value by parameters which holds the enum value(PAREN, BRACE, and FOR)
	 * @param indicator
	 * This parameter was saved on indicator data field of this class
	 */
	public void setData(BlockType indicator){
		this.indicator = indicator;
	}
	/**
	 * This method returns the data which indicators have now.  
	 * @return
	 *  - the enum value which indicator has now.
	 */
	public BlockType getData(){
		return indicator;
	}
	/**
	 * This method sets the link of the nodes which points another node after this node.
	 * @param link
	 *  The reference of node which this node want to be linked.
	 */
	public void setLink(BlockNode link){
		this.link = link;
	}
	/**
	 *  This method returns the reference which the node is linked.
	 * @return
	 * 	The reference which current node is linked.
	 */
	public BlockNode getLink(){
		return link;
	}
}
