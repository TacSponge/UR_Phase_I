package nz.otot.UrPhase1;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Main on 13-Jul-17.
 */
public class GraphBuilder {

    private ArrayList<Node> startNodes = new ArrayList<>();

    // S = start square, . = empty, j = join, s = split, n = normal tile
    char[][] twoPlayerTemplate = {

            {'S', '.', 'S'},
            {'n', '.', 'n'},
            {'n', '.', 'n'},
            {'n', 'j', 'n'},
            {'.', 'n', '.'},
            {'.', 'n', '.'},
            {'.', 'n', '.'},
            {'.', 'n', '.'},
            {'.', 'n', '.'},
            {'.', 'n', '.'},
            {'n', 's', 'n'},
            {'n', '.', 'n'}
    };

    public GraphBuilder(){
        buildFromTemplate(twoPlayerTemplate);

    }

    public ArrayList<Node> getStartNodes(){
        return this.startNodes;
    }
    private void buildFromTemplate(char[][] template){


        //get the start the start points
        Point p;


        for(int i = 0; i < template.length; i++){
            for(int j = 0; j < template[0].length; j++) {
                if (template[i][j] == 'S') {
                     p = new Point(i,j);
                }
            }
        }


        Node<Piece> s = new Node<Piece>(createChildren(Point(p),template));

    }
    private ArrayList<Node> createChildren(Point p, char[][] template){

        ArrayList<Node> children = new ArrayList<>();

        int i = (int) p.getY();
        int j = (int) p.getX();

        //the next action depends on this nodes type
        // if it is a normal node it's child is below it

        //Get the type of the node from the template
        char type = template[i][j];

        //check types and whether there is room in the char[][] for a node to be in the expected slot
        //
        if (type == 'n' && i + 1 < template.length && template[i+1][j] != '.'){
            children.add(new Node<Piece>(createChildren(new Point(j,i+1,),template)));
        }
        if(type == 's'){
            if (j > 0 && template[i][j -1] != '.'){
                children.add(new Node<Piece>(createChildren(new Point(j-1, i),template)));

            }
        }


        /*if (i > 0 && j + 1 < template[0].length  ){


            char canditate = template[i -1 ][j + 1];
            Pointer2D candPos = new Pointer2D(i-1, j+1);

            if(canditate == 'n'){
                children.add(new Node<Piece>(createChildren(candPos,template)));
            }
            if(canditate == 'j'){
                Node<Piece> joiner = new Node<>(createChildren(candPos,template));
                children.add(joiner);
                createParents(joiner);
            }
        }
        */


    }








}
