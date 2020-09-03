package posters.modern_solution.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building implements Comparable<Building>{

    private int number;
    private int height;

    //Comparing heights of buildings - descending order
    @Override
    public int compareTo(Building otherBuilding) {
        return -Integer.compare(height, otherBuilding.height);
    }
}
