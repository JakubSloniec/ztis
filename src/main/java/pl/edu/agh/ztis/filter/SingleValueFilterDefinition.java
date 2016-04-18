package pl.edu.agh.ztis.filter;

import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public class SingleValueFilterDefinition<T, E> extends AbstractFilterDefinition<T, E> {

    protected final BiPredicate<E, E> evaluationPredicate;
    protected final E value;

    public SingleValueFilterDefinition(Function<T, E> mapperFunction, BiPredicate<E, E> evaluationPredicate, E value) {
        super(mapperFunction);
        this.evaluationPredicate = evaluationPredicate;
        this.value = value;
    }

    @Override
    public boolean implies(T element) {
        return evaluationPredicate.test(mapperFunction.apply(element), value);
    }
}
