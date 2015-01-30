/**
 * Created by santiago on 1/30/15.
 */
public class Main {


    public static void main(String[] args){

        DirectedGraph graph=new DirectedGraph();

        graph.insertNode("a");

        graph.insertNode(10);

        graph.insertNode(910.10);

        System.out.println(graph.toString());


    }


}
