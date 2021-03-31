package ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        setAge(age);
        this.town = town;
    }
    private void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("You can not create person with negative age");
        }
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        int res = this.name.compareTo(o.name);
        if (res == 0){
            res = Integer.compare(this.age, o.age);
            if (res == 0){
                res = this.town.compareTo(o.town);
            }
        }
                return res;
    }
}
