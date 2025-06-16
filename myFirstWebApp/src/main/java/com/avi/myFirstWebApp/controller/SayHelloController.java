package com.avi.myFirstWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //url: http://localhost:8080/say-hello
    @ResponseBody
    @RequestMapping("say-hello")
    public String sayHello(){
        return "Hello...";
    }

    @ResponseBody
    @RequestMapping("say-hello-html")
    public String sayHelloHtml(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title>My First HTML page</title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("My First page with body...");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }


    // src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // src/main/resources/META-INF/resources/WEB-INF/jsp/logout.jsp
    // src/main/resources/META-INF/resources/WEB-INF/jsp/content.jsp


    //@ResponseBody
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
