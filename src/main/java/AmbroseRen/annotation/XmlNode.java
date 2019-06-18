package AmbroseRen.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlNode {
	/**对应请求xml的节点**/
    String reqFiled()default "";
    /**对应生成xml的节点**/
    String resFiled()default "";
    /**是否判断空**/
    boolean isNUll() default false;
}
