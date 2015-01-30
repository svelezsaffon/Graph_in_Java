import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by santiago on 1/29/15.
 */
public abstract class Graph<NodeVal,EdgeVal> {

    private HashMap<GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>> Central;

    public abstract boolean insertNode(NodeVal nodeVal);

    public abstract boolean removeNode(NodeVal nodeVal);

    public abstract boolean insertEdge(NodeVal from,NodeVal to,EdgeVal value);

    public abstract boolean removeEdge(NodeVal from,NodeVal to);


    public void getSucessorEnumerator(NodeVal nodeVel){
        GraphNode<NodeVal> node=new GraphNode<NodeVal>(nodeVel);

        if(this.Central.containsKey(node)){

        }else{
            //The node is not in the graph :(

        }

    }


    public boolean containsNode(NodeVal node){
        return this.Central.containsKey(new GraphNode<NodeVal>(node));
    }



}