import java.io.*;
import java.util.Objects;

public class GlossaryTest {
    String file = "PythonGlossary.csv";
    BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
