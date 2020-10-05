package com.mycompany.userregistry;

import java.io.Serializable;
import java.util.Objects;

/**
 * Пользователь. Содержит данные и поведение пользователя.
 * 
 * @author Vladimir
 */
public class User implements Serializable {
    // ID уникальный идентификатор
    private Integer id;
    // ФИО
    private String name;
    private String surname;
    private String patronymic;
    // Контактная инфомрация
    private ContactInfo contactInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Переопределяем встроенный метод toString 
    // для вывода данных пользователя в виде строки
    @Override
    public String toString() {
        return String.format("%d | %s | %s | %s | %s", getId(), getName(), getSurname(), getPatronymic(), getContactInfo());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.surname);
        hash = 73 * hash + Objects.hashCode(this.patronymic);
        hash = 73 * hash + Objects.hashCode(this.contactInfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.contactInfo, other.contactInfo)) {
            return false;
        }
        return true;
    }

    
}
