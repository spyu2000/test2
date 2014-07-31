package com.spyu.common;

import java.util.List;

import com.spyu.exception.ApplyException;


public interface BaseDao<T> {

	T get(Integer id);
    void save(T entity) throws ApplyException;
    void update(T entity) throws ApplyException;
    void delete(T entity) throws ApplyException;
    void delete(int id) throws ApplyException;
    List<T> getAll();
    List<T> getAll(PageModel<T> pageModel);
    int count();
    int count(PageModel pageModel);
}
