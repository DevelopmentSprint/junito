package com.developmentsprint.junito;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides a marker to identify methods that should be run before or after others.
 * 
 * @author torr
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Order {

    /**
     * The order weight. Methods with higher weight will be executed after methods with lower weight.
     */
    int weight();

}
