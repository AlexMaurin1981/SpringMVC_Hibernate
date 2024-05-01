package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public String getAllUsers ( Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allusers";
    }


    @GetMapping ("/adduser")
    public  String adduser (Model model){
        model.addAttribute("user", new User());
        return"adduser";
    }

    @PostMapping
    public  String createUser (@ModelAttribute("user") User user){
    userService.saveUser(user);
    return "redirect:users/allusers";
    }

    @GetMapping("/deleteUser")
    public  String deleteUser (@RequestParam ("id") long id){
        userService.deleteUser(id);
        return "deletUser";
    }

}
