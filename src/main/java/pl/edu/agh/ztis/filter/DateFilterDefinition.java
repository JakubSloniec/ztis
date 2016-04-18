package pl.edu.agh.ztis.filter;

import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public class DateFilterDefinition<T> extends SingleValueFilterDefinition<T, Date> {

    private DateFilterDefinition(Function<T, Date> mapperFunction, BiPredicate<Date, Date> evaluationPredicate, Date value) {
        super(mapperFunction, evaluationPredicate, value);
    }

    public static <T> DateFilterDefinition<T> createLessOrEqualFilterDefinition(Function<T, Date> mapperFunction, Date value) {
        return new DateFilterDefinition<>(mapperFunction, (d1, d2) -> d1.compareTo(d2) <= 0, value);
    }

    public static <T> DateFilterDefinition<T> createGreaterOrEqualFilterDefinition(Function<T, Date> mapperFunction, Date value) {
        return new DateFilterDefinition<>(mapperFunction, (d1, d2) -> d1.compareTo(d2) >= 0, value);
    }


}
