package in.shantanu.portfolio.controller;

import in.shantanu.portfolio.model.ContactRequest;
import in.shantanu.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping({"", "/", "/home"})
    public String showHomePage(Model model) {

        model.addAttribute("contactRequest", new ContactRequest()); // REQUIRED

        return "index";
    }

    @PostMapping("/send-message")
    public String sendMessage(@ModelAttribute ContactRequest request) {

        emailService.sendContactEmail(request);

        return "redirect:/?success";
    }
}