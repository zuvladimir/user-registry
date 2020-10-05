package com.mycompany.userregistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

/**
 * Реестр пользователей. Содержит логику работы с реестром.
 * 
 * @author Vladimir
 */
public class UserRegistry implements Serializable {
    
    // Список пользователей
    private List<User> users;
    
    public UserRegistry() {
        // Инициализация списка пользователей
        setUsers(readUsers());
    }
    
    // Добавить пользователя в реестр и сохранение в файле
    public void addUser(BufferedReader br) throws IOException {
        User newUser = new User();
        out.println("Введите имя:");
        newUser.setName(br.readLine());
        out.println("Введите фамилию:");
        newUser.setSurname(br.readLine());
        out.println("Введите отчество:");
        newUser.setPatronymic(br.readLine());
        ContactInfo c = new ContactInfo();
        out.println("Введите email:");
        c.setEmail(br.readLine());
        out.println("Введите мобильный номер:");
        c.setMobilePhoneNumber(br.readLine());
        newUser.setContactInfo(c);
        getUsers().add(newUser);
        saveUsers();
        out.println("Пользователь добавлен! Продолжить(Y/N)?");
        String response = br.readLine().trim().toUpperCase();
        if(response.equals(RESPONSE.Y.toString())) {
            addUser(br);
        }
    }
    
    // Отображение списка пользователей
    public void showUsers() {
        out.println("---------------- Список пользователей ----------------");
        getUsers().forEach((user) -> {
            out.println(user);
        });
        out.println("------------------------------------------------------");
    }

    // Редактирование данных пользователя
    public void editUser() {
        for (User user : users) {
            //if (user.getId().equals(id)) {
                //user = new User(id, name, surname, patronymic, new ContactInfo(email, mobilePhoneNumber));
                //saveUsers();
                //break;
            //}
        }
    }
    
    // Удалить пользователя
    public void removeUser() {
    
    }
    
    // Сохранение данных пользователей в файл
    private void saveUsers() {
        
    }

    // Чтение данных пользователей из файла.
    private List<User> readUsers() {
        return null;
    }
    
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    private enum RESPONSE {
        Y,
        N;
    }
}
