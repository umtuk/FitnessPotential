package org.seoultech.fitnesspotential.global.util.validator.internal.constraintvalidators.replaceallsize;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.seoultech.fitnesspotential.global.util.validation.constraints.ReplaceAllSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.invoke.MethodHandles;

/**
 * Check that the length of a character sequence when replace all is between min and max.
 *
 * @author umtuk
 */
public class ReplaceAllSizeValidatorForCharSequence implements ConstraintValidator<ReplaceAllSize, CharSequence> {

    private static final Log LOG = LoggerFactory.make( MethodHandles.lookup() );

    private int min;
    private int max;

    private String regex;
    private String replacement;


    @Override
    public void initialize(ReplaceAllSize parameters) {
        min = parameters.min();
        max = parameters.max();
        regex = parameters.regex();
        replacement = parameters.replacement();
        validateParameters();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null) {
            return true;
        }
        String replacedAll = charSequence.toString().replaceAll(regex, replacement);
        int length = replacedAll.length();
        return length >= min && length <= max;
    }

    private void validateParameters() {
        if (min < 0) {
            throw LOG.getMinCannotBeNegativeException();
        }
        if (max < 0) {
            throw LOG.getMinCannotBeNegativeException();
        }
        if (max < min) {
            throw LOG.getLengthCannotBeNegativeException();
        }
    }
}
