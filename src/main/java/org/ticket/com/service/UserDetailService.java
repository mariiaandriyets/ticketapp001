package org.ticket.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.ticket.com.entity.UserEntity;
import org.ticket.com.exceptions.UserNotFoundException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

//    Map<String, String> userStorage = Map.of("admin", "$2a$10$8dvGpNHyUfHAgWMYGoUHPeoAyNC8WmCdimyn4eD3sOOLGMpKSaDTe",
//            "user", "$2a$10$wJQlzN0FteUa3ZflthalE.9ldYjC6p7hD/WLJwbGbCTSp1SufxwZO");

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity;
        try {
            userEntity = userService.getByLogin(username);
        } catch (UserNotFoundException exception) {
            throw new UsernameNotFoundException(exception.getMessage());
        }

        return new User(userEntity.getLogin(), userEntity.getPassword(),
                Collections.singleton(userEntity.getRole()));
    }
}
