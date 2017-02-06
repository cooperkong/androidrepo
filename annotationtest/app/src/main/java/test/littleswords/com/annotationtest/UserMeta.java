package test.littleswords.com.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wenchaokong on 6/02/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface UserMeta {
    public int id() default 0;
    public int age() default 0;
    public String name() default "";
}
