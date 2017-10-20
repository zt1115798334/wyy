package com.zt.mysql.services.impl;

import com.zt.mysql.entity.Images;
import com.zt.mysql.repository.ImagesRepository;
import com.zt.mysql.services.ImagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtong
 */
@Service
public class ImagesServicesImpl implements ImagesServices {

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Images save(Images images) {
        return imagesRepository.save(images);
    }

    @Override
    public Iterable<Images> save(List<Images> images) {
        return imagesRepository.save(images);
    }

    @Override
    public void delete(Integer id) {
        imagesRepository.delete(id);
    }

    @Override
    public List<Images> findByCreatedUser(String createdUser) {
        return imagesRepository.findByCreatedUser(createdUser);
    }
}
