package io.satori.controller;

import io.satori.model.ApplicationUser;
import io.satori.service.EmailVerificationService;
import io.satori.service.UserService;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailVerificationController {

    @Autowired
    private EmailVerificationService verificationService;
    @Autowired
    private UserService userService;

    @GetMapping("/verify/email")
    public String verifyEmail(@RequestParam String id) {
    	byte[] actualId = Base64.getDecoder().decode(id.getBytes());
        String username = verificationService.getUsernameForVerificationId(new String(actualId));
        if(username != null) {
            ApplicationUser user = userService.findByUsername(username);
            user.setVerified(true);
            userService.save(user);
            return "redirect:/login-verified";
        }
        return "redirect:/login-error";
    }
}
