import org.testng.TestNG;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        TestNG runner = new TestNG();
        runner.setTestSuites(Arrays.asList("src/main/resources/suite.xml"));
        runner.run();
    }
}
