package com.sharebooks.common;

import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController {

    @GetMapping("/error")
    public String about() {
        return "error";
    }
}
