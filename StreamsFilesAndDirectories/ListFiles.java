import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) {


        String fileName = "C:/Users/Vladimir/Downloads/" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources " +
                "(1)/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();
        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n",innerFile.getName(),innerFile.length());
            }
        }
    }
}
