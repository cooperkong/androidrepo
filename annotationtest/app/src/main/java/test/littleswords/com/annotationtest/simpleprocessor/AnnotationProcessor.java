package test.littleswords.com.annotationtest.simpleprocessor;

import java.lang.reflect.Constructor;

/**
 * Created by wenchaokong on 6/02/2017.
 */

public class AnnotationProcessor {
    public static void init(Object object){
        if(object instanceof Person){
            Constructor[] constructors = object.getClass().getConstructors();
            for(Constructor constructor : constructors){
                if(constructor.isAnnotationPresent(UserMeta.class)){
                    UserMeta userFill = (UserMeta) constructor.getAnnotation(UserMeta.class);
                    int age = userFill.age();
                    int id = userFill.id();
                    String name = userFill.name();
                    ((Person) object).setAge(age);
                    ((Person) object).setId(id);
                    ((Person) object).setName(name);
                }
            }
        }
    }
}
