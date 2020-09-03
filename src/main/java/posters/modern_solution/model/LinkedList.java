package posters.modern_solution.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LinkedList {

    private final Node[] nodes;

    public void initialize(int size, Building[] buildings) {
        // Filling linkedList with empty Nodes
        for (int i = 0; i <= size + 1; ++i) {
            nodes[i] = new Node();
        }
        // Head Initialization
        nodes[0].setPrev(0);
        nodes[0].setNext(1);
        nodes[0].setHeight(-1);

        // Filling Nodes with values
        for (int i = 1; i <= size; ++i){
            nodes[i].setPrev(i - 1);
            nodes[i].setNext(i + 1);
            nodes[i].setHeight(buildings[i - 1].getHeight());
        }
        // Tail Initialization
        nodes[size+1].setPrev(size);
        nodes[size+1].setNext(size+1);
        nodes[size+1].setHeight(-1);
    }

    // Returns Height of Next Node
    public int getNextHeight(int position) {
        return nodes[nodes[position].getNext()].getHeight();
    }

    public void deleteNode(int position){
        nodes[nodes[position].getNext()].setPrev(nodes[position].getPrev());
        nodes[nodes[position].getPrev()].setNext(nodes[position].getNext());
    }
}
