package com.duffiye.core.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duffiye.core.service.assembler.AssemblerMananger;
import com.duffiye.sys.dao.interfaces.IUserDAO;
import com.duffiye.sys.dto.UserDTO;
import com.duffiye.sys.entity.Authority;
import com.duffiye.sys.entity.Role;
import com.duffiye.sys.entity.User;
import com.duffiye.sys.service.assembler.UserAssembler;



/**
 * step 1
 * 获取登录用户的信息，加载对应的权限
 *
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
    @Autowired
    private IUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    	logger.info("UserDetailsService");
    	System.out.println("      UserDetailsService       ");
        List<User> list = userDAO.findByLoginName(username);
        if (list.size() != 1) {
            throw new UsernameNotFoundException(username + "的用户不存在!");
        } else {
            final User model = list.get(0);
            final UserAssembler assembler = AssemblerMananger.getAssembler(UserAssembler.class);
            final UserDTO dto = assembler.toDTO(model);
            Set<Role> roles = model.getRoles();
            Set<String> set = new HashSet<String>();
            for (Role role : roles) {
                Set<Authority> authorities = role.getAuthorities();
                for (Authority authority : authorities) {
                    set.add(authority.getCode());
                }
            }
            Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            for (String key : set) {
                authorities.add(new SimpleGrantedAuthority(key));
            }
            dto.setAuthorities(authorities);
            return dto;
        }
    }

}
