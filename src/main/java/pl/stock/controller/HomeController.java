package pl.stock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homeSender(HttpSession session, HttpServletRequest request) throws IOException {
        session.invalidate();
        return "redirect:"+request.getContextPath()+"/user/login";
    }
}
