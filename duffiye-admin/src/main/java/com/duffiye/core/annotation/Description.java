package com.duffiye.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* 类名称：Description 
* 类描述： 
* 创建人：Duffiye
* @version 
* 
*/
@Documented
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    public String[] value() default "";

    public String[] code() default "";
}
