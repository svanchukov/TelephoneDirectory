package ru.svanchukov.telephone.mapper;

import org.mapstruct.Mapper;
import ru.svanchukov.telephone.dto.CreatePersonDTO;
import ru.svanchukov.telephone.models.Person;

@Mapper(componentModel = "spring")
public interface CreatePersonMapper {

    CreatePersonDTO toDTO(Person person);

    Person toEntity(CreatePersonDTO createPersonDTO);
}
