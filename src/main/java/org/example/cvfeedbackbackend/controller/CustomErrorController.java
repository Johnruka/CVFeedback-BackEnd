package org.example.cvfeedbackbackend.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Insert your logic or template to handle the error
        return "error";  // Return an error view/template
    }
}
