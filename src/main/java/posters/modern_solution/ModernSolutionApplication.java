package posters.modern_solution;

import posters.modern_solution.service.poster.PosterCountingServiceImpl;
import posters.modern_solution.service.reader.BuildingsReaderImpl;

import java.io.IOException;

public class ModernSolutionApplication {

    public static void main(String[] args) throws IOException {

        var countingService = new PosterCountingServiceImpl();
        var readerService = new BuildingsReaderImpl();

        var start = System.currentTimeMillis();
        var buildings = readerService.readValues("src/main/resources/files/in/pla10b.in");
        var count = countingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        System.out.println(((end - start) * 0.001) + " seconds");
        System.out.println(count);
    }
}
