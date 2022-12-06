package fr.systapps.toolbox.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebsiteController {

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("pageName", "HomePage");
        return "homepage";
    }
}
