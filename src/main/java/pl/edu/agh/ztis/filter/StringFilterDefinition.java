package pl.edu.agh.ztis.filter;

import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public class StringFilterDefinition<T> extends SingleValueFilterDefinition<T, String> {

    private StringFilterDefinition(Function<T, String> mapperFunction, BiPredicate<String, String> evaluationPredicate, String value) {
        super(mapperFunction, evaluationPredicate, value);
    }

    public static <T> StringFilterDefinition<T> createEqualsFilterDefinition(Function<T, String> mapperFunction, String value) {
        return new StringFilterDefinition<T>(mapperFunction, String::equals, value);
    }

    public static <T> StringFilterDefinition<T> createContainsFilterDefinition(Function<T, String> mapperFunction, String value) {
        return new StringFilterDefinition<T>(mapperFunction, String::contains, value);
    }


}
