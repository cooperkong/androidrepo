package test.littleswords.com.annotationtest.simpleprocessor;

/**
 * Created by wenchaokong on 6/02/2017.
 */

public class Person {

    private int id;
    private int age;
    private String name;

    @UserMeta(id = 1, name = "wenchao", age = 12)
    public Person(){

    }

    public Person(int id, int age, String name) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
