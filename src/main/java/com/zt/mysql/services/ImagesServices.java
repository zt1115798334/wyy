package com.zt.mysql.services;

import com.zt.mysql.entity.Images;

import java.util.List;

/**
 * @author zhangtong
 */
public interface ImagesServices {

    /**
     * 保存图片信息（不存在id添加，存在id更新）
     *
     * @param images 图片信息
     * @return 返回图片信息
     */
    Images save(Images images);

    /**
     * 批量保存图片信息
     *
     * @param images 图片信息集合
     */
    Iterable<Images> save(List<Images> images);

    /**
     * 根据id删除图片信息
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * 根据创建人查询图片信息
     *
     * @param createdUser 创建人
     * @return 返回图片集合
     */
    List<Images> findByCreatedUser(String createdUser);
}
