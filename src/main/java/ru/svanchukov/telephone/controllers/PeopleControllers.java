package ru.svanchukov.telephone.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.svanchukov.telephone.dto.CreatePersonDTO;
import ru.svanchukov.telephone.dto.UpdatePersonDTO;
import ru.svanchukov.telephone.models.Person;
import ru.svanchukov.telephone.service.PeopleService;

import java.util.List;

@RequestMapping("/people")
@RestController
public class PeopleControllers {

    private final PeopleService peopleService;

    public PeopleControllers(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = peopleService.findAll();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
        Person person = peopleService.findOne(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody @Valid CreatePersonDTO personDTO) {
        peopleService.save(personDTO);
        return ResponseEntity.ok("Person created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable("id") int id, @RequestBody @Valid UpdatePersonDTO updatePersonDTO) {
        peopleService.update(id, updatePersonDTO);
        return ResponseEntity.ok("Person updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id) {
        peopleService.delete(id);
        return ResponseEntity.ok("Person deleted successfully");
    }
}
