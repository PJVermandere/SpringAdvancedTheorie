package com.example.springadvancedtheorie.controllers;

import com.example.springadvancedtheorie.domain.Lid;
import com.example.springadvancedtheorie.restclients.UserClient;
import com.example.springadvancedtheorie.services.LidService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {
    private final LidService service;
    private final UserClient client;

    public IndexController(LidService service, UserClient client) {
        this.service = service;
        this.client = client;
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @GetMapping("beveiligd")
    public ModelAndView beveiligd(@AuthenticationPrincipal OAuth2User user){
        return new ModelAndView("beveiligd", "user", user.getAttribute("login"))
                .addObject("lid", new Lid("","",""));

    }
    @PostMapping("registreren")
    public String registreren(@Valid Lid lid, Errors errors, HttpServletRequest request, RedirectAttributes redirect){
       service.nieuweInschrijving(lid, request.getRequestURL().toString());
       redirect.addAttribute("id", lid.getId());
        return "redirect:/leden/{id}";
    }
    @GetMapping("/leden/{id}")
    public ModelAndView leden(@PathVariable long id){
        return new ModelAndView("leden", "lid", service.findById(id).get());
    }
    @CrossOrigin(exposedHeaders = "Location")
    @GetMapping("/users/{id}")
    ModelAndView getUser(@PathVariable("id") long id){
        return new ModelAndView("user", "user", client.findById(id).get());
    }
}
