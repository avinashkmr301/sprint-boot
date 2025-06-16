package com.avi.myFirstWebApp.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // http://localhost:8080/login?name=Avi
    @RequestMapping("/login")
    public String login(@RequestParam String name, ModelMap modelMap){
        modelMap.put("name", name);

        logger.debug("Request Param is {}", name);
        logger.info("Request Param is at info level");
        logger.warn("Request Param is at waring level");

        return "login";
    }
}
