/**
 * Created by santiago on 1/30/15.
 */
public class Main {


    public static void main(String[] args){

        DirectedGraph graph=new DirectedGraph();

        graph.insertNode("a");
        graph.insertNode("b");

        graph.insertNode(10);
        graph.insertNode(3.141516);

        graph.insertEdge("a", "b", 10.9);
        graph.insertEdge("a", 10, 10.9);
        graph.insertEdge("b", 10, 10.9);
        graph.insertEdge(3.141516, 10, 10.9);



        System.out.println(graph.BFS("a").toString());






    }


}


