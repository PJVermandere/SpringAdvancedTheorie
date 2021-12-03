package com.example.springadvancedtheorie.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @GetMapping("beveiligd")
    public ModelAndView beveiligd(@AuthenticationPrincipal OAuth2User user){
        return new ModelAndView("beveiligd", "user", user.getAttribute("login"));
    }
}
