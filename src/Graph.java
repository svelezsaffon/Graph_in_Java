import java.util.*;

/**
 * Created by santiago on 1/29/15.
 */
public abstract class Graph<NodeVal,EdgeVal> {

    public HashMap<GraphNode<NodeVal>, HashMap<GraphNode<NodeVal>, EdgeVal>> Central;

    public abstract boolean insertEdge(NodeVal from,NodeVal to,EdgeVal value);

    public abstract boolean removeEdge(NodeVal from,NodeVal to);

    public abstract Graph BFS(NodeVal start);

    public Graph DFS(NodeVal start){
        Graph bfs=null;

        GraphNode<NodeVal> node=new GraphNode<NodeVal>(start);

        if(this.Central.containsKey(node)){


            bfs=new DirectedGraph();


            Stack<GraphNode<NodeVal>> stack=new Stack<GraphNode<NodeVal>>();


            stack.push(node);


            while(!stack.empty()){

                GraphNode<NodeVal> from=stack.pop();


                if(!this.isNodeMarked(from.getValue())){
                    this.markNode(from.getValue());

                    bfs.insertNode(from.getValue());

                    HashMap<GraphNode<NodeVal>, EdgeVal> map=this.Central.get(from);

                    Set<GraphNode<NodeVal>> set=map.keySet();


                    for(GraphNode<NodeVal> next:set){

                        stack.push(next);

                        if(bfs.insertNode(next.getValue())){
                            bfs.insertEdge(from.getValue(),next.getValue(),map.get(next));
                        }
                    }
                }
            }
        }



        return bfs;
    }


    public void markNode(NodeVal node){
        Set<GraphNode<NodeVal>> set=this.Central.keySet();

        for(GraphNode<NodeVal> iter:set){
            if(iter.getValue().equals(node)){
                    iter.mark();
                break;
            }
        }
    }

    public void unMarkNode(NodeVal node){
        Set<GraphNode<NodeVal>> set=this.Central.keySet();

        for(GraphNode<NodeVal> iter:set){
            if(iter.getValue().equals(node)){
                iter.unMark();
                break;
            }
        }
    }



    public boolean isNodeMarked(NodeVal node){
        Set<GraphNode<NodeVal>> set=this.Central.keySet();

        for(GraphNode<NodeVal> iter:set){
            if(iter.getValue().equals(node)){
                return iter.isMArked();
            }
        }


        return false;
    }



    public boolean putSingleEdge(NodeVal fromp,NodeVal top,EdgeVal valuep) {
        GraphNode from = new GraphNode(fromp);
        GraphNode to = new GraphNode(top);
        boolean ret=false;
        if (this.Central.containsKey(from) && this.Central.containsKey(to)) {

            this.Central.get(from).put(to,valuep);

            ret=true;
        }


        return ret;
    }

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
            buffer.append("[");
            buffer.append(val.toString());
            buffer.append("]");
            Set<GraphNode<NodeVal>> map=entry.getValue().keySet();

            for(GraphNode<NodeVal> i:map){
                buffer.append("->(");
                buffer.append(i.getValue().toString());
                buffer.append(")");
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