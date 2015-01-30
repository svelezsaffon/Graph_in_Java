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
}
