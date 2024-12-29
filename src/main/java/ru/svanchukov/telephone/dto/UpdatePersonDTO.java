package ru.svanchukov.telephone.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdatePersonDTO {

    @NotBlank(message = "ФИО не должно быть пустым")
    private String fio;

    @NotBlank(message = "Адрес не должен быть пустым")
    private String address;

    @NotBlank(message = "Номер телефона не должен быть пустым")
    @Pattern(regexp = "\\+?\\d{10,15}", message = "Некорректный номер телефона")
    private String number;

    @Email(message = "Некорректный email")
    private String email;

    // Геттеры и сеттеры

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
