package org.persistencia;

import java.util.List;

public interface DAO<T> {

    List<T> selectAll() throws Exception;

    void insert(T objeto) throws Exception;

    void delete(T objeto) throws Exception;

    void update(T objeto) throws Exception;

}
