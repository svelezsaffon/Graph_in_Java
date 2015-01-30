import java.util.HashMap;

/**
 * Created by santiago on 1/29/15.
 */
public abstract class Graph<NodeVal,EdgeVal> {

    private HashMap<GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>> Central;

    public abstract boolean insertNode(NodeVal nodeVal);

    public abstract boolean removeNode(NodeVal nodeVal);

    public boolean containsNode(NodeVal node){
        return this.Central.containsKey(node);
    }



}