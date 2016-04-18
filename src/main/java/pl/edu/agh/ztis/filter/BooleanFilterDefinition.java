package pl.edu.agh.ztis.filter;

import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public class BooleanFilterDefinition<T> extends SingleValueFilterDefinition<T, Boolean> {

    private BooleanFilterDefinition(Function<T, Boolean> mapperFunction, BiPredicate<Boolean, Boolean> evaluationPredicate, Boolean value) {
        super(mapperFunction, evaluationPredicate, value);
    }

    public static <T> BooleanFilterDefinition<T> createEqualsFilterDefinition(Function<T, Boolean> mapperFunction, Boolean value) {
        return new BooleanFilterDefinition<>(mapperFunction, Boolean::equals, value);
    }

}
