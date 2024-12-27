package ru.svanchukov.telephone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.svanchukov.telephone.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
