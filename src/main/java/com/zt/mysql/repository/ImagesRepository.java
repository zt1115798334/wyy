package com.zt.mysql.repository;

import com.zt.mysql.entity.Images;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author zhangtong
 */
public interface ImagesRepository extends CrudRepository<Images,Integer> {

    /**
     * 根据创建人查询图片信息集合
     *
     * @param createdUser 创建人
     * @return 图片信息集合
     */
    List<Images> findByCreatedUser(String createdUser);
}
