package com.qf.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;


import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author ：BinSun
 * @date : 2019/8/20 16:58
 * @description :瑜伽学员实体类
 * @modified By ：
 * @version:
 */
@ApiModel("学员对象")
@Data
public class YogaStudent implements Serializable {
//    学员编号
    private Integer yogaStudentId;
//    学员名称
    private String yogaStudentName;
//    学员密码
    private String  yogaStudentPassword;
//    学员手机
    private String yogaStudentPhone;
//    学员邮箱
    private String yogaStudentEmail;
//    学员微信
    private String yogaStudentWeChat;
//    学员QQ
    private String yogaStudentQq;
//    学员性别
    private String yogaStudentSex;
//    学员头像路径
    private String yogaStudentHead;
//    学员个性签名
    private String yogaStudentAutograph;

    @Override
    public String toString() {
        return "YogaStudent{" +
                "yogaStudentId=" + yogaStudentId +
                ", yogaStudentName='" + yogaStudentName + '\'' +
                ", yogaStudentPassword='" + yogaStudentPassword + '\'' +
                ", yogaStudentPhone='" + yogaStudentPhone + '\'' +
                ", yogaStudentEmail='" + yogaStudentEmail + '\'' +
                ", yogaStudentWeChat='" + yogaStudentWeChat + '\'' +
                ", yogaStudentQq='" + yogaStudentQq + '\'' +
                ", yogaStudentSex='" + yogaStudentSex + '\'' +
                ", yogaStudentHead='" + yogaStudentHead + '\'' +
                ", yogaStudentAutograph='" + yogaStudentAutograph + '\'' +
                '}';
    }

    public Integer getYogaStudentId() {
        return yogaStudentId;
    }

    public void setYogaStudentId(Integer yogaStudentId) {
        this.yogaStudentId = yogaStudentId;
    }

    public String getYogaStudentName() {
        return yogaStudentName;
    }

    public void setYogaStudentName(String yogaStudentName) {
        this.yogaStudentName = yogaStudentName;
    }

    public String getYogaStudentPassword() {
        return yogaStudentPassword;
    }

    public void setYogaStudentPassword(String yogaStudentPassword) {
        this.yogaStudentPassword = yogaStudentPassword;
    }

    public String getYogaStudentPhone() {
        return yogaStudentPhone;
    }

    public void setYogaStudentPhone(String yogaStudentPhone) {
        this.yogaStudentPhone = yogaStudentPhone;
    }

    public String getYogaStudentEmail() {
        return yogaStudentEmail;
    }

    public void setYogaStudentEmail(String yogaStudentEmail) {
        this.yogaStudentEmail = yogaStudentEmail;
    }

    public String getYogaStudentWeChat() {
        return yogaStudentWeChat;
    }

    public void setYogaStudentWeChat(String yogaStudentWeChat) {
        this.yogaStudentWeChat = yogaStudentWeChat;
    }

    public String getYogaStudentQq() {
        return yogaStudentQq;
    }

    public void setYogaStudentQq(String yogaStudentQq) {
        this.yogaStudentQq = yogaStudentQq;
    }

    public String getYogaStudentSex() {
        return yogaStudentSex;
    }

    public void setYogaStudentSex(String yogaStudentSex) {
        this.yogaStudentSex = yogaStudentSex;
    }

    public String getYogaStudentHead() {
        return yogaStudentHead;
    }

    public void setYogaStudentHead(String yogaStudentHead) {
        this.yogaStudentHead = yogaStudentHead;
    }

    public String getYogaStudentAutograph() {
        return yogaStudentAutograph;
    }

    public void setYogaStudentAutograph(String yogaStudentAutograph) {
        this.yogaStudentAutograph = yogaStudentAutograph;
    }
}
