package ru.svanchukov.telephone.mapper;

import org.mapstruct.Mapper;
import ru.svanchukov.telephone.dto.UpdatePersonDTO;
import ru.svanchukov.telephone.models.Person;

@Mapper(componentModel = "spring")
public interface UpdatePersonMapper {

    UpdatePersonDTO toDTO(Person person);

    Person toEntity(UpdatePersonDTO updatePersonDTO);
}
