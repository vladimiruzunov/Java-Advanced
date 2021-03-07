import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    private static final String FIRST_INPUT_PATH = "src\\Resources\\inputOne.txt";
    private static final String SECOND_INPUT_PATH = "src\\Resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "src\\Resources\\output.txt";
    public static void main(String[] args) throws IOException {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_INPUT_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = firstReader.readLine();
            while (line != null){
               writer.println(line);
                line=firstReader.readLine();
            }
            line = secondReader.readLine();
            while (line != null){
                writer.println(line);
                line = secondReader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
