package pl.edu.agh.ztis.filter;

import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public class CollectionFilterDefinition<T, E> extends AbstractFilterDefinition<T, E> {

    protected final BiPredicate<Collection<E>, E> evaluationPredicate;
    protected final Collection<E> value;

    public CollectionFilterDefinition(Function<T, E> mapperFunction, BiPredicate<Collection<E>, E> evaluationPredicate, Collection<E> value) {
        super(mapperFunction);
        this.evaluationPredicate = evaluationPredicate;
        this.value = value;
    }

    @Override
    public boolean implies(T element) {
        return evaluationPredicate.test(value, mapperFunction.apply(element));
    }

    public static <T, E> CollectionFilterDefinition<T, E> createInFilterDefinition(Function<T, E> mapperFunction, Collection<E> value) {
        return new CollectionFilterDefinition<>(mapperFunction, Collection::contains, value);
    }

}
