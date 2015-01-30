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
    public boolean BFS(Object start) {
        return false;
    }

    @Override
    public boolean DFS(Object start) {
        return false;
    }


}
