package com.qf.service.impl;

import com.qf.dao.YogaStudentDao;
import com.qf.domain.YogaStudent;
import com.qf.service.IYogaStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：BinSun
 * @date : 2019/8/20 17:52
 * @description : student业务处理层
 * @modified By ：
 * @version:
 */
@Service
public class YogaStudentService implements IYogaStudentService {

    @Autowired(required = false)
    private YogaStudentDao yogaStudentDao;

    /**
     * @Author: BinSun
     * @Description: 通过手机号注册
     * @Param: 页面传入yogaStudent必填选项
     * @return: 返回1为注册成功否则失败
     * @Date: 17:55 2019/8/20
     * @Modified By:
     */
    @Override
    public int phoneStudentAdd(YogaStudent yogaStudent) {
        return yogaStudentDao.phoneStudentAdd(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过邮箱注册
     * @Param: 页面传入yogaStudent必填选项
     * @return: 返回1为注册成功否则失败
     * @Date: 17:58 2019/8/20
     * @Modified By:
     */
    @Override
    public int emailStudentAdd(YogaStudent yogaStudent) {
        return yogaStudentDao.emailStudentAdd(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过用户名登录
     * @Param: 页面传入yogaStudent用户名和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @Override
    public YogaStudent loginName(YogaStudent yogaStudent) {
        return yogaStudentDao.loginName(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过手机号码登录
     * @Param: 页面传入yogaStudent手机号和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @Override
    public YogaStudent loginPhone(YogaStudent yogaStudent) {
        return yogaStudentDao.loginPhone(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过邮箱登录
     * @Param: 页面传入yogaStudent邮箱和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @Override
    public YogaStudent loginEmail(YogaStudent yogaStudent) {
        return yogaStudentDao.loginEmail(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 学员完成个人信息
     * @Param: 页面传入yogaStudent需要修改的属性
     * @return: 返回1表明修改成功
     * @Date: 19:25 2019/8/20
     * @Modified By:
     */
    @Override
    public int updateStudent(YogaStudent yogaStudent) {
        return yogaStudentDao.updateStudent(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description:  学员修改密码
     * @Param: 页面传入yogaStudent需要修改的属性
     * @return: 返回1表明修改成功
     * @Date: 19:45 2019/8/20
     * @Modified By:
     */
    @Override
    public int updateStudentPassword(YogaStudent yogaStudent) {
        return yogaStudentDao.updateStudentPassword(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过账户名查询对象是否存在
     * @Param: 页面传入需要查询的账户名
     * @return: 返回查询对象
     * @Date: 20:19 2019/8/20
     * @Modified By:
     */
    @Override
    public YogaStudent findYogaStudentName(String yogaStudentName) {
        return yogaStudentDao.findYogaStudentName(yogaStudentName);
    }

    /**
     * @Author: BinSun
     * @Description: 通过邮箱查询对象是否存在
     * @Param: 页面传入需要查询的邮箱
     * @return: 返回查询对象
     * @Date: 20:44 2019/8/20
     * @Modified By:
     */
    @Override
    public YogaStudent findYogaStudentEmail(String yogaStudentEmail) {
        return yogaStudentDao.findYogaStudentEmail(yogaStudentEmail);
    }

    /**
     * @Author: BinSun
     * @Description: 通过手机号查询对象是否存在
     * @Param: 页面传入需要查询的手机号
     * @return: 返回查询对象
     * @Date: 9:39 2019/8/21
     * @Modified By:
     */
    @Override
    public YogaStudent findYogaStudentPhone(String yogaStudentPhone) {
        return yogaStudentDao.findYogaStudentPhone(yogaStudentPhone);
    }


}
