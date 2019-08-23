package com.qf.com.qf.service.impl;

import com.qf.com.qf.dao.YogaHomePageDao;
import com.qf.com.qf.domain.YogaAdvertisement;
import com.qf.com.qf.service.IYogaHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：BinSun
 * @date : 2019/8/21 20:14
 * @description :
 * @modified By ：
 * @version:
 */
@Service
public class YogaHomePageService implements IYogaHomePageService {

    @Autowired(required = false)
    private YogaHomePageDao yogaHomePageDao;

    /**
     * @Author: BinSun
     * @Description: 显示所有广告
     * @Param:
     * @return: List
     * @Date: 20:20 2019/8/21
     * @Modified By:
     */
    @Override
    public List<YogaAdvertisement> findAllHomePage() {
        return yogaHomePageDao.findAllHomePage();
    }
}
