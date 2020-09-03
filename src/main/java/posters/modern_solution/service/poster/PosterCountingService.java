package posters.modern_solution.service.poster;

import posters.modern_solution.model.Building;

public interface PosterCountingService {

    int count(int totalBuildings, Building[] buildings);
}
