package com.ric.netctoss.config;

import com.ric.netctoss.service.AdminInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdminInfoService adminInfoService;

    @Override
    public String getName() {
        return "AdminRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AdminToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();

        this.adminInfoService.login(username, password);

        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
