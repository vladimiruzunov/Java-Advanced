import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    private static final String INPUT_PATH = "src\\Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src\\Resources\\output.txt";
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            String line = reader.readLine();
            int number = 1;
            while (line != null){

                writer.println(String.format("%d. %s",number , line));
                number++;
                line = reader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
