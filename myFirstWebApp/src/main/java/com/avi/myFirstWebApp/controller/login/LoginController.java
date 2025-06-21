package com.avi.myFirstWebApp.controller.login;

import com.avi.myFirstWebApp.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // http://localhost:8080/login
    // By default it will be -GET & -POST, so make it GET only
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String gotoLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        if (authenticationService.authentication(name,password)){
            modelMap.put("name", name);
            return "welcomePage";
        }
        modelMap.put("errorMessage","Invalid credentials! Please try again.");
        return "login";
    }
}
