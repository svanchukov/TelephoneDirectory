package ru.svanchukov.telephone.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.svanchukov.telephone.models.Person;
import ru.svanchukov.telephone.service.PeopleService;

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleControllers {

    private final PeopleService peopleService;

    @GetMapping("/hello")
    public String showAllPeople(Model model) {
        model.addAttribute("person", peopleService.findAll());

        return "people";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        Person foundUser = peopleService.findOne(id);
        if (foundUser == null) {
            return "error";
        }
        model.addAttribute("person", foundUser);
        return "person";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Person person = peopleService.findOne(id);
        if (person == null) {
            return "error";
        }
        model.addAttribute("person", person);
        return "edit";
    }


    @PostMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id,
                             @ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("person", new Person());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") Person person) {
        peopleService.save(person);

        return "redirect:/people";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);

        return "redirect:/people";
    }
}
















