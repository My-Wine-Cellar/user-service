package info.mywinecellar.controller;

import info.mywinecellar.model.User;
import info.mywinecellar.model.UserDto;
import info.mywinecellar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> userAllGet() {
        return userService.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userRegisterPost(@Valid @RequestBody UserDto user) throws Exception {

        if (emailExists(user.getEmail())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else if (usernameExists(user.getUserName())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else if (!user.getPassword().equals(user.getMatchingPassword())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userService.registerNewUserAccount(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userLoginPost(Principal principal) {
        userService.updateLastLogin(principal.getName(), new Date(System.currentTimeMillis()));
        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean emailExists(String email) {
        User user = userService.findUserByEmail(email);
        return user != null;
    }

    private boolean usernameExists(String username) {
        User user = userService.findByUsername(username);
        return user != null;
    }
}
