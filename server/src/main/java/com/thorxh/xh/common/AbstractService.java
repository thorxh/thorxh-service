package com.thorxh.xh.common;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * created on 2018/10/2
 *
 * @author thorxh
 */
public abstract class AbstractService<T> implements CommonService<T> {

    @Resource
    private CommonMapper<T> mapper;

    /**
     * 当前泛型真实的 Class
     */
    private final Class<T> modelClass;

    protected AbstractService() {
        final ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // noinspection unchecked
        this.modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() {
        return mapper.selectAll();
    }

    @Override
    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public void save(T model) {
        mapper.insertSelective(model);
    }

    @Override
    public void save(List<T> models) {
        int i = mapper.insertList(models);
        System.out.println(i);
    }

    @Override
    public void delete(T model) {
        mapper.delete(model);
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBy(String fieldName, Object value) throws Exception {
        try {
            T model = this.modelClass.newInstance();
            Field field = this.modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            mapper.delete(model);
        } catch (final ReflectiveOperationException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public void update(T model) {
        mapper.updateByPrimaryKey(model);
    }

}
