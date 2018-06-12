package com.sharebooks.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller    // This means that this class is a Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request, @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "home";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "aboutus";
    }
}
