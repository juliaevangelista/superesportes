package edu.pw2.superesportes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class LoginControler {
    @GetMapping
    public String loadHome(){
        return "redirect:/atletas";
    }

    @GetMapping("login")
    public String LoafLoginForm(){
        return "login";
    }

    @GetMapping("/logout")
    public String performLogout(Authentication auth, 
                                HttpServletRequest request,
                                HttpServletResponse response){
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, response, auth);
        return "redirect:/login";
    }
}
