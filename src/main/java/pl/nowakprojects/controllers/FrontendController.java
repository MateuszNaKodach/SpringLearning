package pl.nowakprojects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Controller
public class FrontendController {

    @RequestMapping("/")
    public String resultPage(@RequestParam(defaultValue = "świecie", required = false) String name, Model model){
        model.addAttribute("message", "Witaj " + name + "!");
        return "resultPage";
    }

    @RequestMapping("/start")
    public String start(){
            return "index";
        }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }
}
