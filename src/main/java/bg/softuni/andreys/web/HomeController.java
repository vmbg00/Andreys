package bg.softuni.andreys.web;

import bg.softuni.andreys.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(){
        if (currentUser.isAnonymous()){
            return "index";
        }

        return "home";
    }


}
