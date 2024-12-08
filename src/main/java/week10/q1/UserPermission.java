package week10.q1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface UserPermission {
    String value();
}
