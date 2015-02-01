/**
 * Created by santiago on 1/31/15.
 */
public class UnDirectedGraph extends Graph {

    @Override
    public boolean insertEdge(Object fromp, Object top, Object valuep) {

        return this.putSingleEdge(fromp,top,valuep)  && this.putSingleEdge(top,fromp,valuep);

    }

    @Override
    public boolean removeEdge(Object from, Object to) {
        return false;
    }



}
