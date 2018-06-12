package com.sharebooks.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        System.out.println("user logged in - " + request.getSession().getAttribute("user"));
        return "dashboard";
    }
}
