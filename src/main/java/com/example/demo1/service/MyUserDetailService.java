package com.example.demo1.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chensz
 * @CreateTime: 2019-08-16 15:12
 * @Description:
 */
@Component
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private org.slf4j.Logger logger =  LoggerFactory.getLogger(this.getClass());
    /**
     * 根据用户名加载用户信息
     *
     * @param username 用户名
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名:" + username);
        System.out.println("表单登录用户名:" + username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "admin";
            }
        });

        String pWord = passwordEncoder.encode("123");
        System.out.println("表单登录密码:" + pWord);
        logger.info(pWord);
        return new User("test", pWord, true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
