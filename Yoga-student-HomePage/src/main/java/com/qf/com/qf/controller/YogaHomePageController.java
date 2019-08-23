package com.qf.com.qf.controller;

import com.qf.com.qf.domain.YogaAdvertisement;
import com.qf.com.qf.service.impl.YogaHomePageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：SunBin
 * @date : 2019/8/22 15:19
 * @description :
 * @modified By ：
 * @version:
 */
@RestController
public class YogaHomePageController {

    @Autowired
    private YogaHomePageService yogaHomePageService;

    /**
     * @Author: BinSun
     * @Description: 显示所有广告接口
     * @Param:
     * @return:
     * @Date: 15:22 2019/8/22
     */
    @RequestMapping(value = "/findAllHomePage", method = RequestMethod.GET)
    @ApiOperation(value = "显示所有广告", notes = "List")
    public List<YogaAdvertisement> findAllHomePage() {
        return yogaHomePageService.findAllHomePage();
    }


}
