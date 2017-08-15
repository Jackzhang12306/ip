package com.cetc.util;

import java.io.Serializable;

import java.util.List;

public interface CrudDao<T extends Serializable> {

    /**
     * 根据id获取实体
     *
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    String save(T entity);

    /**
     * 更新实体
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 删除实体
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据id删除实体
     *
     * @param id
     */
    void delete(String id);

    /**
     * 查找�?有实�?
     *
     * @return
     */
    List<T> findAll();

    /**
     * 指定排序规则查找�?有实�?
     *
     * @param orderby
     * @param desc
     * @return
     */
    List<T> findAll(String orderby, boolean desc);
}
