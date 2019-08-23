package com.qf.controller;

import com.qf.Utils.RedisUtils;
import com.qf.domain.YogaStudent;
import com.qf.service.impl.SendTextMessageService;
import com.qf.service.impl.YogaStudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Random;

/**
 * @author ：BinSun
 * @date : 2019/8/20 19:41
 * @description : 学员Controller
 * @modified By ：
 * @version:
 */

@RestController
@RequestMapping(value = "/YogaStudent")
public class YogaStudentController {

    @Autowired
    private YogaStudentService yogaStudentService;
    @Autowired(required = false)
    private JavaMailSender javaMailSender;
    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(Logger.class);
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SendTextMessageService sendTextMessageService;

    /**
     * @Author: BinSun
     * @Description: 通过手机号注册
     * @Param: 页面传入yogaStudent必填选项
     * @return: 返回1为注册成功否则失败
     * @Date: 17:55 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/phoneStudentAdd", method = RequestMethod.POST)
    @ApiOperation(value = "手机号注册", notes = "返回int类型")
    public int phoneStudentAdd(@RequestBody YogaStudent yogaStudent) {
        return yogaStudentService.phoneStudentAdd(yogaStudent);
    }



    /**
     * @Author: BinSun
     * @Description: 通过邮箱注册
     * @Param: 页面传入yogaStudent必填选项
     * @return: 返回1为注册成功否则失败
     * @Date: 17:58 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/emailStudentAdd", method = RequestMethod.POST)
    @ApiOperation(value = "邮箱注册", notes = "返回int类型")
    public int emailStudentAdd(@RequestBody YogaStudent yogaStudent) {
        return yogaStudentService.emailStudentAdd(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过邮箱激活注册账户使用
     * @Param:
     * @return:
     * @Date: 21:25 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/sendVerifyCod", method = RequestMethod.GET)
    @ApiOperation(value = "发送验证链接", notes = "返回String类型")
    @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱", required = true)
    public String sendVerifyCod(@RequestParam String email) {
        String st = "邮件发送成功，请注意查收。";
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        YogaStudent yogaStudentEmail = yogaStudentService.findYogaStudentEmail(email);
        String ab=yogaStudentEmail.getYogaStudentName()+"-"+verifyCode;
        redisUtils.set(ab, verifyCode);
        redisUtils.expire(ab,86400);
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom("禅音瑜伽");
            //邮件接收人
            simpleMailMessage.setTo(email);
            //邮件主题
            simpleMailMessage.setSubject("禅音");
            //邮件内容
            simpleMailMessage.setText("请勿回复本邮件.点击下面的链接,重设密码" + "http://127.0.0.1:8002/YogaStudent/checkUrlLogin?"+ab+"="+verifyCode + "，该链接有效期为24小时，该链接只能使用一次！【短信签名】");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            st = "服务器正在升级...";
            LOG.error("邮件发送失败", e.getMessage());
        }
        return st;
    }

    /**
     * @Author: BinSun
     * @Description: 验证激活链接是否正确，具有唯一性
     * @Param:
     * @return: boolean
     * @Date: 21:01 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/checkUrlLogin", method = RequestMethod.GET)
    @ApiOperation(value = "验证激活链接是否正确", notes = "返回Boolean类型")
    public boolean checkUrlLogin(String ab){
        boolean b=true;
        Object o = redisUtils.get(ab);
        if (o==null){
            b=false;
        }else {
            b = true;
        }
        return b;
    }

    /**
     * @Author: BinSun
     * @Description: 通过用户名登录
     * @Param: 页面传入yogaStudent用户名和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/loginName", method = RequestMethod.POST)
    @ApiOperation(value = "用户名登录", notes = "返回int类型")
    public YogaStudent loginName(YogaStudent yogaStudent) {
        return yogaStudentService.loginName(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过手机号码登录
     * @Param: 页面传入yogaStudent手机号和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/loginPhone", method = RequestMethod.POST)
    @ApiOperation(value = "手机号登录", notes = "返回int类型")
    public YogaStudent loginPhone(YogaStudent yogaStudent) {
        return yogaStudentService.loginPhone(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 通过邮箱登录
     * @Param: 页面传入yogaStudent邮箱和密码
     * @return: 返回对象携带用户Id
     * @Date: 19:08 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/loginEmail", method = RequestMethod.POST)
    @ApiOperation(value = "邮箱登录", notes = "返回int类型")
    public YogaStudent loginEmail(YogaStudent yogaStudent) {
        return yogaStudentService.loginEmail(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 学员完成个人信息
     * @Param: 页面传入yogaStudent需要修改的属性
     * @return: 返回1表明修改成功
     * @Date: 19:25 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息", notes = "返回int类型")
    public int updateStudent(@RequestBody YogaStudent yogaStudent) {
        return yogaStudentService.updateStudent(yogaStudent);
    }


    /**
     * @Author: BinSun
     * @Description: 找回密码；发送邮件→请求邮件里的URL→验证url→{验证成功修改密码，不成功跳转到失败页面}
     * 一个url只能修改一次密码,当同一帐号发送多封邮件,只有最后一封邮件的url 邮箱
     * @Param: email用户邮箱
     * @return: 字符串
     * @Date: 19:35 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST)
    @ApiOperation(value = "发送验证链接", notes = "返回String类型的六位数字验证码")
    @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱", required = true)
    public String sendVerifyCode(@RequestParam String email){
        String st = "邮件发送成功，请注意查收。";
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        YogaStudent yogaStudentEmail = yogaStudentService.findYogaStudentEmail(email);
        String ab=yogaStudentEmail.getYogaStudentPhone()+"-"+verifyCode;
        redisUtils.set(ab, verifyCode);
        redisUtils.expire(ab,1800);
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom("禅音瑜伽");
            //邮件接收人
            simpleMailMessage.setTo(email);
            //邮件主题
            simpleMailMessage.setSubject("禅音");
            //邮件内容
            simpleMailMessage.setText("请勿回复本邮件.点击下面的链接,重设密码" + "http://127.0.0.1:8002/YogaStudent/checkUrl?"+ab+"="+verifyCode + "，该链接有效期为30分钟，该链接只能使用一次！【短信签名】");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            st = "服务器正在升级...";
            LOG.error("邮件发送失败", e.getMessage());
        }
        return st;
    }

    /**
     * @Author: BinSun
     * @Description: 验证找回密码链接是否正确，具有唯一性
     * @Param:
     * @return: boolean
     * @Date: 21:01 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/checkUrl", method = RequestMethod.GET)
    @ApiOperation(value = "校验找回密码URL正确性", notes = "返回Boolean类型")
    public boolean checkUrl(String ab){
        boolean b=true;
        Object o = redisUtils.get(ab);
        if (o==null){
             b=false;
        }else {
            b = true;
        }
        return b;
    }
    
    /**
     * @Author: BinSun
     * @Description: 验证是否成功修改密码
     * @Param:
     * @return:
     * @Date: 21:12 2019/8/20
     * @Modified By:
     */
    @RequestMapping(value = "/updateStudentPassword", method = RequestMethod.POST)
    @ApiOperation(value = "修改密码", notes = "返回int类型")
    public int updateStudentPassword(YogaStudent yogaStudent) {
        return yogaStudentService.updateStudentPassword(yogaStudent);
    }

    /**
     * @Author: BinSun
     * @Description: 发送短信注册码
     * @Param: 用户手机号码
     * @return: String
     * @Date: 9:43 2019/8/21
     * @Modified By:
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信注册码", notes = "返回String类型")
    public String register(String phone){
        String register = sendTextMessageService.register(phone);
        return register;
    }

    @RequestMapping(value = "/checkRegister", method = RequestMethod.POST)
    @ApiOperation(value = "校验短信注册码是否存在", notes = "返回boolean类型")
    public boolean checkRegister(String phone){
        boolean b=false;
        if ( yogaStudentService.findYogaStudentPhone(phone)!=null) {
            Object o = redisUtils.get(phone);
            if (o != null) {
                b = true;
            }
        }
        return b;
    }


}
