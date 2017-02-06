package test.littleswords.com.annotationtest;

/**
 * Created by wenchaokong on 6/02/2017.
 */

public class Main {
    public static void main(String... args){
        Person person = new Person();
        AnnotationProcessor.init(person);
        System.out.println(person);
    }
}
