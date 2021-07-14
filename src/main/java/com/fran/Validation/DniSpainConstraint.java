package com.fran.Validation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DniSpainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DniSpainConstraint {

	  String message() default "Son 8 números y 1 letra"; 

	  Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};

}
