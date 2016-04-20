package pl.edu.agh.ztis.filter;

import java.util.function.Function;

/**
 * Created by kkicinger on 17/04/16.
 */
public abstract class AbstractFilterDefinition<T, E> implements IFilter<T> {

    protected final Function<T, E> mapperFunction;

    protected AbstractFilterDefinition(Function<T, E> mapperFunction) {
        this.mapperFunction = mapperFunction;
    }

}
