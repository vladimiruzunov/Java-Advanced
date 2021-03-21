package ArrayCreator;

import ArrayCreator.ArrayCreator;

public class Main {
    public static void main(String[] args) {

    Integer[] array = ArrayCreator.create(13,13);
    String[] arrayInfo = ArrayCreator.create(String.class, 13, "Java");

        for (Integer integer : array) {
            print(integer);
        }

    }
    public static <T> void print(T num){
        System.out.println(num);
    }
}
