package pl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stock.entity.User;
import pl.stock.repository.UserRepository;
import pl.stock.service.UserService;
import pl.stock.validator.NewUserValidator;
import pl.stock.validator.UserLogValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NewUserValidator newUserValidator;

    @Autowired
    UserLogValidator userLogValidator;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult,
                               HttpServletRequest request,
                               HttpSession session) {

        newUserValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.save(userForm);
        session.setAttribute("currentUser", userForm);

        return "redirect:"+request.getContextPath()+"/stock/wallet";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLog", new User());

        return "user/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("userLog") User userLog,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        HttpSession session){

        userLogValidator.validate(userLog, bindingResult);

        if (bindingResult.hasErrors()){
            return "user/login";
        }

        User currentUser = userRepository.findByUsername(userLog.getUsername());
        session.setAttribute("currentUser", currentUser);

        return "redirect:"+request.getContextPath()+"/stock/wallet";
    }

    @GetMapping("/account")
    public String showAccount(){
        return "user/account";
    }
}
