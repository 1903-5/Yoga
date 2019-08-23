package com.qf.com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ：BinSun
 * @date : 2019/8/21 19:23
 * @description :
 * @modified By ：
 * @version:
 */
@ApiModel("广告对象")
@Data
public class YogaAdvertisement {

    //广告编号
    private Integer yogaId;
    //广告名称
    private String yogaName;
    //广告来源
    private String yogaSource;
    //发布时间
    private String yogaReleaseTime;
    //阅读次数
    private String yogaReadingNumber;
    //导读
    private String yogaGuideReading;
    //广告正文
    private String yogaText;

    @Override
    public String toString() {
        return "YogaAdvertisement{" +
                "yogaId=" + yogaId +
                ", yogaName='" + yogaName + '\'' +
                ", yogaSource='" + yogaSource + '\'' +
                ", yogaReleaseTime='" + yogaReleaseTime + '\'' +
                ", yogaReadingNumber='" + yogaReadingNumber + '\'' +
                ", yogaGuideReading='" + yogaGuideReading + '\'' +
                ", yogaText='" + yogaText + '\'' +
                '}';
    }

    public Integer getYogaId() {
        return yogaId;
    }

    public void setYogaId(Integer yogaId) {
        this.yogaId = yogaId;
    }

    public String getYogaName() {
        return yogaName;
    }

    public void setYogaName(String yogaName) {
        this.yogaName = yogaName;
    }

    public String getYogaSource() {
        return yogaSource;
    }

    public void setYogaSource(String yogaSource) {
        this.yogaSource = yogaSource;
    }

    public String getYogaReleaseTime() {
        return yogaReleaseTime;
    }

    public void setYogaReleaseTime(String yogaReleaseTime) {
        this.yogaReleaseTime = yogaReleaseTime;
    }

    public String getYogaReadingNumber() {
        return yogaReadingNumber;
    }

    public void setYogaReadingNumber(String yogaReadingNumber) {
        this.yogaReadingNumber = yogaReadingNumber;
    }

    public String getYogaGuideReading() {
        return yogaGuideReading;
    }

    public void setYogaGuideReading(String yogaGuideReading) {
        this.yogaGuideReading = yogaGuideReading;
    }

    public String getYogaText() {
        return yogaText;
    }

    public void setYogaText(String yogaText) {
        this.yogaText = yogaText;
    }
}
