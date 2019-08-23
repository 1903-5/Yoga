package com.qf.service;

import com.qf.domain.YogaStudent;

/**
 * @author ：BinSun
 * @date : 2019/8/20 17:52
 * @description :
 * @modified By ：
 * @version:
 */
public interface IYogaStudentService {

    public int phoneStudentAdd(YogaStudent yogaStudent);

    public int emailStudentAdd(YogaStudent yogaStudent);

    public YogaStudent loginName(YogaStudent yogaStudent);

    public YogaStudent loginPhone(YogaStudent yogaStudent);

    public YogaStudent loginEmail(YogaStudent yogaStudent);

    public int updateStudent(YogaStudent yogaStudent);

    public int updateStudentPassword(YogaStudent yogaStudent);

    public YogaStudent findYogaStudentName(String yogaStudentName);

    public YogaStudent findYogaStudentEmail(String yogaStudentEmail);

    public YogaStudent findYogaStudentPhone(String yogaStudentPhone);



}
