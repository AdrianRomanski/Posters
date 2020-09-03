package posters.modern_solution.service.poster;

import posters.modern_solution.model.Building;
import posters.modern_solution.model.LinkedList;
import posters.modern_solution.model.Node;

import java.util.Arrays;

public class PosterCountingServiceImpl implements PosterCountingService {

    @Override
    public int count(int totalBuildings, Building[] buildings) {
        var linkedList = new LinkedList(new Node[totalBuildings+2]);
        linkedList.initialize(totalBuildings, buildings);

        Arrays.sort(buildings);

        var result = 0;

        for (int i = 0; i < totalBuildings; ++i) {

            var buildingNumber = buildings[i].getNumber();
            if (linkedList.getNodes()[buildingNumber].getHeight() != linkedList.getNextHeight(buildingNumber)) {
                result++;
            }
            linkedList.deleteNode(buildingNumber);
        }
        return result;
    }

}
