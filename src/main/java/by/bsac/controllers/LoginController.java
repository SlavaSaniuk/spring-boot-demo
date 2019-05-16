package by.bsac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/login", "/login.html"})
public class LoginController {

    /**
     * Controller handle "GET" request to "/login" path. Also all request without internal context path must be handled in its method.
     * @return - "login.html" view name.
     */
    @GetMapping
    public String getLoginPage() {
        return "login";
    }

}
