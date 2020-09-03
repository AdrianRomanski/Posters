package posters_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posters.modern_solution.service.poster.PosterCountingService;
import posters.modern_solution.service.poster.PosterCountingServiceImpl;
import posters.modern_solution.service.reader.BuildingsReader;
import posters.modern_solution.service.reader.BuildingsReaderImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class PostersTest {

    PosterCountingService posterCountingService;
    BuildingsReader buildingsReader;

    @BeforeEach
    void setUp() {
        posterCountingService = new PosterCountingServiceImpl();
        buildingsReader = new BuildingsReaderImpl();
    }

    @Test
    @DisplayName("Testing input from file = pla0")
    void testMethod1() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla0.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(4);
    }


    @Test
    @DisplayName("Testing input from file = pla1a")
    void testMethod2() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla1a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(41);
    }


    @Test
    @DisplayName("Testing input from file = pla1b")
    void testMethod3() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla1b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(105);
    }


    @Test
    @DisplayName("Testing input from file = pla1c")
    void testMethod4() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla1c.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(1);
    }


    @Test
    @DisplayName("Testing input from file = pla1ocen")
    void testMethod5() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla1ocen.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(5);
    }


    @Test
    @DisplayName("Testing input from file = pla2a")
    void testMethod6() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla2a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(718);
    }


    @Test
    @DisplayName("Testing input from file = pla2b")
    void testMethod7() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla2b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(662);
    }


    @Test
    @DisplayName("Testing input from file = pla2c")
    void testMethod8() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla2c.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(4);
    }


    @Test
    @DisplayName("Testing input from file = pla2ocen")
    void testMethod9() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla2ocen.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(6);
    }


    @Test
    @DisplayName("Testing input from file = pla3a")
    void testMethod10() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla3a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(1190);
    }


    @Test
    @DisplayName("Testing input from file = pla3b")
    void testMethod11() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla3b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(2105);
    }


    @Test
    @DisplayName("Testing input from file = pla3c")
    void testMethod12() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla3c.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(1705);
    }


    @Test
    @DisplayName("Testing input from file = pla3ocen")
    void testMethod13() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla3ocen.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(7);
    }


    @Test
    @DisplayName("Testing input from file = pla4a")
    void testMethod14() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla4a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(2201);
    }


    @Test
    @DisplayName("Testing input from file = pla4b")
    void testMethod15() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla4b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(3449);
    }


    @Test
    @DisplayName("Testing input from file = pla4ocen")
    void testMethod16() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla4ocen.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(125001);
    }


    @Test
    @DisplayName("Testing input from file = pla5a")
    void testMethod17() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla5a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(105834);
    }


    @Test
    @DisplayName("Testing input from file = pla5b")
    void testMethod18() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla5b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(107570);
    }


    @Test
    @DisplayName("Testing input from file = pla6a")
    void testMethod19() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla6a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(122285);
    }


    @Test
    @DisplayName("Testing input from file = pla6b")
    void testMethod20() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla6b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(130604);
    }


    @Test
    @DisplayName("Testing input from file = pla7a")
    void testMethod21() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla7a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(133315);
    }


    @Test
    @DisplayName("Testing input from file = pla7b")
    void testMethod22() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla7b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(149362);
    }


    @Test
    @DisplayName("Testing input from file = pla8a")
    void testMethod23() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla8a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(112754);
    }


    @Test
    @DisplayName("Testing input from file = pla8b")
    void testMethod24() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla8b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(150254);
    }


    @Test
    @DisplayName("Testing input from file = pla9a")
    void testMethod25() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla9a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(174118);
    }


    @Test
    @DisplayName("Testing input from file = pla9b")
    void testMethod26() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla9b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(148540);
    }


    @Test
    @DisplayName("Testing input from file = pla10a")
    void testMethod27() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla10a.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(159396);
    }


    @Test
    @DisplayName("Testing input from file = pla10b")
    void testMethod28() throws IOException {
        var start = System.currentTimeMillis();
        var buildings = buildingsReader.readValues("src/main/resources/files/in/pla10b.in");
        var count = posterCountingService.count(buildings.length, buildings);
        var end = System.currentTimeMillis();
        var totalTime = (end - start) * 0.001;

        System.out.println(totalTime);

        assertThat(totalTime).isLessThan(5.0);
        assertThat(count).isEqualTo(155393);
    }

}

