package ru.svanchukov.telephone.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonDTO {

    private int id;

    @NotBlank(message = "FIO can't be empty")
    private String fio;

    @NotBlank(message = "Address can't be empty")
    private String address;

    @NotBlank(message = "Phone number can't be null")
    @Pattern(regexp = "\\+?\\d{10,15}", message = "Incorrect phone number")
    private String number;

    @Email(message = "Incorrect email address")
    private String email;
}
