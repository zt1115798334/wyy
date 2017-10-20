package com.zt.controller;

import com.zt.base.controller.BaseController;
import com.zt.beans.AjaxResult;
import com.zt.constants.SysConst;
import com.zt.mysql.entity.Images;
import com.zt.mysql.services.ImagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhangtong
 */
@Controller
@RequestMapping("/images")
public class ImagesController extends BaseController {

    @Autowired
    private ImagesServices imagesServices;

    @RequestMapping(value = "/searchImages", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult searchImages() {
        String createdUser = SysConst.DEFAULT_USER_ACCOUNT;
        List<Images> result = imagesServices.findByCreatedUser(createdUser);
        return success(result);
    }

}
