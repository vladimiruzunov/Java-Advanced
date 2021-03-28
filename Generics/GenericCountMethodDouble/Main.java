package GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(reader.readLine());

        Box box = new Box();
        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(reader.readLine());
            box.addElement(element);
        }
        double elementToCompare = Double.parseDouble(reader.readLine());
        box.compareElement(elementToCompare);
        System.out.println(Box.getCount());
    }
}