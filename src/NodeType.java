//NodeType.java
public class NodeType {
    public ItemType info;
    public NodeType next;

    /**
     * Constructor for NodeType
     */
    public NodeType(ItemType item) {
        info = new ItemType(item.getValue());
    }

    /**
     * This will set the next Node
     * @return 
     */
    public void setNext(NodeType nextOne) {
        next = nextOne;
    }// next

    /**
     * returns next node
     * @return 
     */
    public NodeType getNext() {
        return next;
    } // getNext
}

