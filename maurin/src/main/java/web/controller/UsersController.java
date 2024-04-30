package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("allusers")
    public String getAllUsers ( Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allusers";
    }
    @GetMapping("/user")
public  String getuser (@RequestParam (value="id") long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return  "user";
}

}
