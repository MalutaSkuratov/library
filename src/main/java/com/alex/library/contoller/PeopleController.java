package com.alex.library.contoller;


import com.alex.library.dao.PeopleDAO;
import com.alex.library.models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleDAO peopleDAO;


    @Autowired
    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping()
    public String indexPeople(Model model){
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPeople(@PathVariable("id") int id, Model model){
        model.addAttribute("people",peopleDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPeople(@ModelAttribute ("people") @Valid People people){

        return "people/new";
    }

    @PostMapping()
    public String createPeople(@ModelAttribute("people") @Valid People people){


        peopleDAO.save(people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPeople(@PathVariable("id") int id, Model model){
        model.addAttribute("people", peopleDAO.show(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String updatePeople(@ModelAttribute("people") @Valid People people,
                               @PathVariable("id") int id ){

        peopleDAO.update(id,people);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePeople(@PathVariable("id") int id){
        peopleDAO.delete(id);
        return "redirect:/people";
    }

}
