package by.bsac.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/login", "/login.html"})
public class LoginController {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * Controller handle "GET" request to "/login" path. Also all request without internal context path must be handled in its method.
     * @return - "login.html" view name.
     */
    @GetMapping
    public String getLoginPage() {

        //Log
        LOGGER.info("Welcome to login page.");

        //View name
        return "login";
    }

}
