package posters.single_class_solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application implements Runnable{

    public static void main(String[] args){
        new Thread(new Application()).start();
    }

    static class Node {
        public int height;
        public int next;
        public int prev;
    }

    static class Building implements Comparable<Building>{

        public int buildingNumber;
        public int height;

        /**
         Comparing heights of buildings - descending order
         */
        @Override
        public int compareTo(Building otherBuilding) {
            return -Integer.compare(height, otherBuilding.height);
        }
    }

    Node[] linkedList;
    Building[] buildingsArray;
    int totalBuildings;
    int buildingNumber;
    int result;


    void linkedListInitialization(){

        // Nodes Initialization
        for (int i = 0; i <= totalBuildings+1; ++i) {
            linkedList[i] = new Node();
        }

        // Head Initialization
        linkedList[0].prev = 0;
        linkedList[0].next = 1;
        linkedList[0].height = (-1);

        // Filling Nodes with Values
        for (int i = 1; i <= totalBuildings; ++i){
            linkedList[i].prev = i - 1;
            linkedList[i].next = i + 1;
            linkedList[i].height = buildingsArray[i-1].height;
        }
        // Initializing Tail
        linkedList[totalBuildings+1].prev=totalBuildings;
        linkedList[totalBuildings+1].next=totalBuildings+1;
        linkedList[totalBuildings+1].height=(-1);
    }

    // Returns Next Node Height value
    int nextValue(int position) {
        return linkedList[linkedList[position].next].height;
    }

    // Deletes Node with matching position
    void deleteNode(int position){
        linkedList[linkedList[position].next].prev=linkedList[position].prev;
        linkedList[linkedList[position].prev].next=linkedList[position].next;
    }


    public void run(){
        try{
            // Reading Input from Console
            var br = new BufferedReader(new InputStreamReader(System.in));
            var line = br.readLine();
            var st = new StringTokenizer(line);
            totalBuildings = Integer.parseInt(st.nextToken());
            buildingsArray = new Building[totalBuildings];
            linkedList = new Node[totalBuildings+2];
            for (int i = 0; i < totalBuildings; ++i){
                // Filling Array with input
                line = br.readLine();
                st = new StringTokenizer(line);
                st.nextToken();
                buildingsArray[i] = new Building();
                buildingsArray[i].height = Integer.parseInt(st.nextToken());
                buildingsArray[i].buildingNumber = i+1;
            }

            linkedListInitialization();

            Arrays.sort(buildingsArray);

            for (int i = 0; i < totalBuildings; ++i) {
                buildingNumber = buildingsArray[i].buildingNumber;
                // Checking for height if its not equal incrementing result, otherwise deleting current node
                if (linkedList[buildingNumber].height != nextValue(buildingNumber)) {
                    result++;
                }
                deleteNode(buildingNumber);
            }
            System.out.println(result);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
};


