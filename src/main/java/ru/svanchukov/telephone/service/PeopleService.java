package ru.svanchukov.telephone.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.svanchukov.telephone.dto.CreatePersonDTO;
import ru.svanchukov.telephone.dto.UpdatePersonDTO;
import ru.svanchukov.telephone.exceptions.PersonNotFoundException;
import ru.svanchukov.telephone.mapper.CreatePersonMapper;
import ru.svanchukov.telephone.mapper.UpdatePersonMapper;
import ru.svanchukov.telephone.models.Person;
import ru.svanchukov.telephone.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final CreatePersonMapper createPersonMapper;
    private final UpdatePersonMapper updatePersonMapper;

    public PeopleService(PeopleRepository peopleRepository, CreatePersonMapper createPersonMapper, UpdatePersonMapper updatePersonMapper) {
        this.peopleRepository = peopleRepository;
        this.createPersonMapper = createPersonMapper;
        this.updatePersonMapper = updatePersonMapper;
    }

    @Transactional(readOnly = true)
    public Person findOne(int id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with id: " + id + " not found"));
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional
    public void save(@Valid CreatePersonDTO createPersonDTO) {
        Person person = createPersonMapper.toEntity(createPersonDTO);
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, @Valid UpdatePersonDTO updatePersonDTO) {
        Person person = peopleRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with id: " + id + " not found"));

        Person updatedPerson = updatePersonMapper.toEntity(updatePersonDTO);
        peopleRepository.save(updatedPerson);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}

























