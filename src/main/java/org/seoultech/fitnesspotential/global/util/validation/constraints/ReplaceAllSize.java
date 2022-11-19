package org.seoultech.fitnesspotential.global.util.validation.constraints;

import org.seoultech.fitnesspotential.global.util.validator.internal.constraintvalidators.replaceallsize.ReplaceAllSizeValidatorForCharSequence;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated char sequence size when replace all must be between the specified boundaries (included).
 * <p>
 * Supported types are:
 * <ul>
 *     <li>{@code CharSequence} (length of character sequence is evaluated)</li>
 * </ul>
 * <p>
 * {@code null} elements are considered valid.
 *
 * @author umtuk
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { ReplaceAllSizeValidatorForCharSequence.class })
public @interface ReplaceAllSize {


    String message() default "replaceAll() 메서드 적용 후 크기가 올바르지 않습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * @return size the element must be higher or equal to
     */
    int min() default 0;

    /**
     * @return size the element must be lower or equal to
     */
    int max() default Integer.MAX_VALUE;

    /**
     * @return regular expression the replaceAll method executed
     */
    String regex() default "";

    /**
     * @return replacement the replaceAll method executed
     */
    String replacement() default "";
}
