package com.fundamentosplatzi.springboot.fundamentos.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class UserDto {
    private Long Id;
    private String name;
    private LocalDate birthDate;

    public UserDto(Long id, String name, LocalDate birthDate) {
        Id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

