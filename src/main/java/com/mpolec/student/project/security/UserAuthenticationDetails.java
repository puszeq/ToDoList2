package com.mpolec.student.project.security;

import com.mpolec.student.project.entity.UserEntity;
import com.mpolec.student.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login);
        if (user != null) {
            List<GrantedAuthority> group;
            group = new ArrayList<>();
            group.add(new SimpleGrantedAuthority("normalUser"));
            return new
                    org.springframework.security.core.userdetails.User(user.getLogin(),
                    user.getPassword(), true,
                    true, true, true, group);
        } else {
            throw new UsernameNotFoundException("Wrong username or password.");
        }
    }
}
