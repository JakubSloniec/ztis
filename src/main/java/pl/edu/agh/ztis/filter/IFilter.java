package pl.edu.agh.ztis.filter;

/**
 * Created by kkicinger on 17/04/16.
 */
public interface IFilter<T> {

    boolean implies(T element);

}
