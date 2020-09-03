package posters.modern_solution.service.reader;

import posters.modern_solution.model.Building;

import java.io.*;
import java.util.StringTokenizer;

public class BuildingsReaderImpl implements BuildingsReader {

    @Override
    public Building[] readValues(String path) throws IOException {
        var file = new File(path);
        var br = new BufferedReader(new FileReader(file));
        var line = br.readLine();
        var st = new StringTokenizer(line);
        var totalBuildings = Integer.parseInt(st.nextToken());
        var buildingsArray = new Building[totalBuildings];

        for (int i = 0; i < totalBuildings; ++i) {
            line = br.readLine();
            st = new StringTokenizer(line);
            st.nextToken();
            buildingsArray[i] = new Building();
            buildingsArray[i].setHeight(Integer.parseInt(st.nextToken()));
            buildingsArray[i].setNumber(i + 1);
        }
        return buildingsArray;
    }
}
