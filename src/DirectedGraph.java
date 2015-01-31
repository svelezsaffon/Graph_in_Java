import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Created by santiago on 1/30/15.
 */
public class DirectedGraph extends Graph {

    @Override
    public boolean insertEdge(Object fromp, Object top, Object valuep) {

     return this.putSingleEdge(fromp,top,valuep);

    }

    @Override
    public boolean removeEdge(Object from, Object to) {
        return false;
    }

    @Override
    public Graph BFS(Object start) {
        Graph bfs=new DirectedGraph();



        return bfs;
    }

}
