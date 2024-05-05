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

    @GetMapping
    public String getAllUsers ( Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }


    @GetMapping ("/adduser")
    public  String adduser (Model model){
        model.addAttribute("user", new User());
        return"adduser";
    }

    @PostMapping("/adduser")
    public  String createUser (@ModelAttribute("user") User user){
    userService.saveUser(user);
    return "redirect:/users";
    }

    @GetMapping("/deleteuser{id}")
    public  String deleteUser (@PathVariable ("id") long id){

        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/updateuser{id}")
    public  String updateUser (@PathVariable ("id") Long id, Model model){
        model.addAttribute("user",userService.getUser(id));

        return "updateuser";
    }
    @PostMapping("/updateuser{id}")
    public  String saveUpdateUser (@PathVariable("id") long id, @ModelAttribute ("user") User user){
user.setId(id);
userService.updateUser(user);
        return "redirect:/users";
    }
}
