package com.duffiye.core.utils;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.duffiye.core.security.SecurityContext;
import com.duffiye.sys.dto.UserDTO;



public final class SecurityUtils {

    /** 
     *获取当前操作数据
    * @return
    */
    public static UserDTO currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication == null ? null : authentication.getPrincipal();
        return principal instanceof UserDTO ? (UserDTO) principal : null;
    }

    /** 
     * 当前登陆用户是否有权限访问指定的URL
    * @param url
    * @return
    */
    public static boolean hasAuthorize(String url) {
        if (StringUtils.isBlank(url)) {
            return true;
        }
        UserDTO oper = currentUser();
        if (null == oper) {
            return false;
        }
        if (!url.startsWith("/")) {
            url = "/" + url;
        }
        if (url.indexOf("?") != -1) {
            url = url.substring(0, url.indexOf("?"));
        }
        //指定的URL无权限控制
        Set<String> set = SecurityContext.instance().get(url);
        if (CollectionUtils.isEmpty(set)) {
            return true;
        }
        //判断是否授权
        Collection<GrantedAuthority> authorities = oper.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (set.contains(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}
