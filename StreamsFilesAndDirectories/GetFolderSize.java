import java.io.*;

public class GetFolderSize {
    private static final String DIR_PATH = "src\\Resources\\Exercises Resources";
    private static final String OUTPUT_PATH = "src\\Resources\\output.txt";
    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();
            for (File file : files) {
                size += file.length();
            }
            writer.println(String.format("Folder size: %s",size));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
