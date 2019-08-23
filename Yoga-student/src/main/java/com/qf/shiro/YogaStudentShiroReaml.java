package com.qf.shiro;



import com.qf.domain.YogaStudent;
import com.qf.service.impl.YogaStudentService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class YogaStudentShiroReaml extends AuthorizingRealm {
    @Autowired
    private YogaStudentService yogaStudentService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();//获取用户信息
//        char[] credentials =(char[]) token.getCredentials();
//        String password = ((char[]) token.getCredentials()).toString();//获取凭证信息
        //根据用户信息查询数据库获取后端的用户身份，转交给securityManager判定
        YogaStudent yogaStudent = yogaStudentService.findYogaStudentName(username);//从数据库直接取
        System.out.println(yogaStudent);
        if (yogaStudent != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(yogaStudent.getYogaStudentName(), yogaStudent.getYogaStudentPassword(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }

}
