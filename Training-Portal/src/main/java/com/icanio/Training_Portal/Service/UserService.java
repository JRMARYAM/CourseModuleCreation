package com.icanio.Training_Portal.Service;


import com.icanio.Training_Portal.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{
    private final LoginRepository userRepository;
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {

                return  userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User name not found"));

            }
        };
    }
}

