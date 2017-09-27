package nz.otot.UrPhase1.model.graph;


import nz.otot.UrPhase1.model.Player;


import java.util.*;


/**
 * Created by Main on 13-Jul-17.
 *
 * This class currently only ever needs to make one graph.
 *
 * If the need occurs this can be expanded to make an arbitrary graph, this is not a priority for the project.
 *
 *
 this takes:
    - an int for the number of nodes
    - an int for which start nodes are the start nodes the first n nodes are the start nodes.
    - an 2D showing the edges where each row is an edge the left column is the parent and the right is the child.
    -


 Again at this time it is only producing one graph so the constructors for arbitrary graphs are not implemented at this
    time. So the class has a constructor with no parameters and provides the required parameters to proiduce the below

 S = start square, joined to squares below, . = empty, j = join parents are side square children is below, s = split,
 parent above child to the side, n = normal tile, child below unless it's a join

 {'S' 0,     '.',        'S' 1},                  v   v
 {'n' 2,     '.',        'n' 3},                  v   v
 {'n' 4,     '.',        'n' 5},                  v   v
 {'n' 6,     'j' 7,      'n'8},                   > v <
 {'.',       'n' 9,      '.'},                      v
 {'.',       'n' 10,      '.'},                      v
 {'.',       'n' 11,     '.'},                      v
 {'.',       'n' 12,     '.'},                      v
 {'.',       'n' 13      '.'},                      v
 {'.',       'n' 14      '.'},                      v
 {'n' 15,    's' 16,     'n' 17},                 v <>v
 {'n' 18,    '.' ,      'n' 19}                  .   .


 *
 */
public class GraphBuilder<T> {

    private int numNodes;
    private ArrayList<Node> startNodes;
    private int[][] edges;


    // with no parameters the builder creaters the above graph
    public GraphBuilder(){
        this.numNodes = 20;
        int numStartNodes = 2; //first two nodes are start nodes.

        this.edges = new int[][]{
                    {0,2},{2,4},{4,6},{6,7},
                    {1,3},{3,5},{5,8},{8,7},
                    {7,9},{9,10},{11,12},{12,13},{13,14},{14,16},
                    {16,15}, {15,18},
                    {16,17},{17,18}
        };

        ArrayList<Node> nodes = genNodes(numNodes);
        addEdges(nodes);
        // set start nodes
        startNodes = new ArrayList<Node>();
        for(int i = 0; i < numStartNodes; i++) startNodes.add(nodes.get(i));

    }

    private ArrayList<Node> genNodes(int numNodes){

        ArrayList<Node> nodes = new ArrayList<>();

        for(int n = 0; n < numNodes; n++) nodes.add(new Node<T>());

        return nodes;
    }

    private void addEdges(ArrayList<Node> nodes){

        for(int[] edge : edges){
            Node parent = nodes.get(edge[0]);
            Node child = nodes.get(edge[1]);

            parent.addChild(child);
        }
    }

    public ArrayList<Node> getStartNodes(){
        return this.startNodes;
    }

    public void assignNodesToPlayer(Player player, Node node){
        // iterativly proceeds down the tree to make a path of nodes for that player
        // if there is only one child it adds itself to the players of that node
        // if there are multiple it adds itself to one of them

        ArrayList<Node> children = node.getChildren();

        if(children.size() == 1){
            children.get(0).addPlayer(player);

        }
        //If there are is more than one route assign the player to the first available route
        if(children.size() > 1){
            for (Node n: children) {
                if(n.getPlayers().isEmpty()){
                    n.addPlayer(player);
                    break;
                }
            }
        }
    }


    public Node[][] gen2PGrid(ArrayList<Node> nodes){
        // returns a grid representation of the graph as based on the shape of the Ur board
        // see below diagram, with arrow symbols, S = start , E = end
        /* > v <
           ^ v ^
           ^ v ^
           S v S
           . v .
           . v .
           E v E
           ^ <>^
           Unconnected nodes are added in as place hodlers for the '.'s.
         */



        final Node[][] grid = { {nodes.get(6),nodes.get(7),nodes.get(8)},
                                {nodes.get(4),nodes.get(9),nodes.get(5)},
                                {nodes.get(2),nodes.get(10),nodes.get(3)},
                                {nodes.get(0),nodes.get(11),nodes.get(1)},
                                {new Node<T>(), nodes.get(12),new Node<T>()},
                                {new Node<T>(), nodes.get(13),new Node<T>()},
                                {nodes.get(18),nodes.get(14),nodes.get(19)},
                                {nodes.get(15),nodes.get(16),nodes.get(17)}
                        };
        return grid;
    }





}