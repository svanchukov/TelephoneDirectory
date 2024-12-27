package ru.svanchukov.telephone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.svanchukov.telephone.models.Person;
import ru.svanchukov.telephone.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Transactional(readOnly = true)
    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Optional<Person> person = peopleRepository.findById(id);

        if (person.isPresent()) {
            Person updatingPerson = person.get();

            updatingPerson.setFio(updatedPerson.getFio());
            updatingPerson.setId(updatedPerson.getId());
            updatingPerson.setNumber(updatedPerson.getNumber());
            updatingPerson.setEmail(updatedPerson.getEmail());
            updatingPerson.setAddress(updatedPerson.getAddress());

            peopleRepository.save(updatingPerson);
        } else {
            throw new IllegalArgumentException("Person with id: " + id + " not found");
        }
    }


    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

}























