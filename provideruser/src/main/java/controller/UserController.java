package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getuser/{id}")
    public String getUser(@PathVariable String id) {
        User user = userService.findUserById(id);
        return user.toString();
    }
    @GetMapping("/getuser")
    public String getUser() {
        return "No User ID";
    }
}
