package bg.softuni.andreys.web;

import bg.softuni.andreys.security.CurrentUser;
import bg.softuni.andreys.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ItemService itemService;

    public HomeController(CurrentUser currentUser, ItemService itemService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("items", this.itemService.getAllItems());
        model.addAttribute("itemCount", this.itemService.itemCount());

        return "home";
    }
    @GetMapping("/items/details/{id}")
    public ModelAndView details(@PathVariable Long id, ModelAndView modelAndView){
        modelAndView.addObject("item", this.itemService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @GetMapping("/items/delete/{id}")
    public String delete(@PathVariable Long id){
        this.itemService.deleteItem(id);

        return "redirect:/";
    }

}
