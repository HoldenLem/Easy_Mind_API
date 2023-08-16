package easy.mind.com.api.DTO.annotation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "cannot be null")
@Min(value = 0, message = "The value cannot be lower than 0")
@Max(value = 3, message = "The value cannot be higher than 3")
public @interface  SpectrumValidation {
}
