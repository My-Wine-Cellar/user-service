package info.mywinecellar.service;

import info.mywinecellar.model.User;
import info.mywinecellar.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.Date;
import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User findUserByEmail(String email);

    List<User> findAll();

    void deleteUserById(Long userId);

    void registerNewUserAccount(UserDto accountDto) throws Exception;

    void updateLastLogin(String username, Date date);

}
