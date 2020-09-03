package posters.modern_solution.service.reader;

import posters.modern_solution.model.Building;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BuildingsReader {

    Building[] readValues(String path) throws IOException;
}
