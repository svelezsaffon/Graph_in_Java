import java.util.*;

/**
 * Created by santiago on 1/29/15.
 */
public abstract class Graph<NodeVal,EdgeVal> {

    public HashMap<GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>> Central;

    public abstract boolean insertEdge(NodeVal from,NodeVal to,EdgeVal value);

    public abstract boolean removeEdge(NodeVal from,NodeVal to);

    public abstract boolean BFS(NodeVal start);

    public abstract boolean DFS(NodeVal start);



    public Graph(){
        this.Central=new HashMap<GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>>();
    }

    @Override
    public String toString() {
        StringBuffer buffer=new StringBuffer();

        Iterator iter=this.Central.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry< GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>  > entry=(Map.Entry< GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>  >)iter.next();

            NodeVal val=(NodeVal)((GraphNode)entry.getKey()).getValue();

            buffer.append(val.toString());

            Set<GraphNode<NodeVal>> map=entry.getValue().keySet();

            for(GraphNode<NodeVal> i:map){
                buffer.append(i.getValue().toString());
            }



            buffer.append("\n");
        }

        return buffer.toString();
    }

    public boolean insertNode(NodeVal nodeVal){
        GraphNode<NodeVal> node=new GraphNode<NodeVal>(nodeVal);

        boolean ret=false;

        if(!this.Central.containsKey(node)){
            //Only if the graph does not contain the node
            HashMap<GraphNode<NodeVal>, EdgeVal> insideMap=new HashMap<GraphNode<NodeVal>, EdgeVal>();
            this.Central.put(node,insideMap);
            ret=true;
        }


        return ret;
    }

    public boolean removeNode(NodeVal nodeVal){
        GraphNode<NodeVal> node=new GraphNode<NodeVal>(nodeVal);
        boolean ret=true;

        if(this.Central.remove(node)==null){
            ret=false;
        }

        return ret;
    }

    public Iterator< Map.Entry < GraphNode<NodeVal>, EdgeVal> >  getSucessorEnumerator(NodeVal nodeVel){
        GraphNode<NodeVal> node=new GraphNode<NodeVal>(nodeVel);

        if(this.Central.containsKey(node)){
            return this.Central.get(node).entrySet().iterator();
        }

        return null;
    }


    public boolean containsNode(NodeVal node){
        return this.Central.containsKey(new GraphNode<NodeVal>(node));
    }




}