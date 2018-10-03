package com.thorxh.xh.common;

import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public interface CommonService<T> {

    List<T> getAll();

    T findById(Integer id);

    T findBy(String fieldName, Object value);

    void save(T model);

    void save(List<T> models);

    void delete(T model);

    void deleteById(Integer id);

    void deleteBy(String fieldName, Object value) throws Exception;

    void deleteByIds(String ids);

    void update(T model);

}
