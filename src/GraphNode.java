/**
 * Created by santiago on 1/29/15.
 */


public class GraphNode<NodeVal> {

        private NodeVal value;

        public GraphNode(){

        }

        public NodeVal getValue(){
            return this.value;
        }

        public GraphNode(NodeVal val)
        {
            this.value=val;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;

        GraphNode graphNode = (GraphNode) o;

        if (value != null ? !value.equals(graphNode.value) : graphNode.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
