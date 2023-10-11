package uk.sky.jkamp.SpringBoot.controllers;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;


public class CustomErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(Model model, WebRequest request) {
        // Custom error handling logic
        model.addAttribute("errorMessage", "Oops! Something went wrong.");

        return "error"; // Return the name of your error template
    }
}
