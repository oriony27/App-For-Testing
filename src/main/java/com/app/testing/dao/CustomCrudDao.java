package com.app.testing.dao;

import java.util.List;

/**
 * Crud dao. Designed to provide main operations for data manipulation.
 *
 * @param <T> Processed value.
 */
public interface CustomCrudDao<T> {

    /**
     * Saves given entity.
     *
     * @param entity must not be {@link null}.
     * @param <S>    entity type.
     * @return the saved entity.
     */
    <S extends T> S save(S entity);

    /**
     * Returns all instances of type.
     *
     * @return all instances.
     */
    List<T> findAll();

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@link null}.
     * @return the entity with given id.
     */
    T findById(long id);

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @return true if entity exists and successfully deleted.
     */
    boolean deleteById(long id);
}