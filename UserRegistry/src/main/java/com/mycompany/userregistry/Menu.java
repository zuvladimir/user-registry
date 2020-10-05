package com.mycompany.userregistry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;

/**
 * Меню.
 * 
 * @author Vladimir
 */
public class Menu {
    // Реестр с данными пользователей
    private UserRegistry userRegistry = new UserRegistry();
    // Список меню
    private List<MenuItem> menuItems = new ArrayList<>();
    public Menu() {
        // Инициализация списка меню
        menuItems.add(MenuItem.ADD_USER);
        menuItems.add(MenuItem.EDIT_USER);
        menuItems.add(MenuItem.DELETE_USER);
        menuItems.add(MenuItem.SHOW_USERS);
        menuItems.add(MenuItem.EXIT);
    }
    // Запуск меню.
    public void run() {
        // Обработка пунктов меню
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            while(Boolean.TRUE) {
                // Отрисовка пунктов меню
                out.println("------------------- User Registry -------------------");
                menuItems.forEach((menuItem) -> {
                    out.println(menuItem);
                });
                out.println("-----------------------------------------------------");
                
                String enteredText = br.readLine().trim();
                if (!enteredText.matches("^[0-9]+$")) {
                    out.println("Выбранный пункт меню не существует!");
                    continue;
                }
                for (MenuItem menuItem : MenuItem.values()) {
                    if(menuItem.getNum().equals(Integer.valueOf(enteredText))) {
                        switch(menuItem) {
                            case ADD_USER:
                                getUserRegistry().addUser(br);
                                break;
                            case EDIT_USER:
                                getUserRegistry().editUser();
                                break;
                            case DELETE_USER:
                                getUserRegistry().removeUser();
                                break;
                            case SHOW_USERS:
                                getUserRegistry().showUsers();
                                break;
                            case EXIT:
                                return;
                            default: 
                                out.println("Выбранный пункт меню не существует!");
                        }
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }
    
    // Перечисление пунктов меню
    private enum MenuItem {
        ADD_USER(1, "Добавить пользователя"),
        EDIT_USER(2, "Редактировать пользователя"),
        DELETE_USER(3, "Удалить пользователя"),
        SHOW_USERS(4, "Список пользователей"),
        EXIT(5, "Выйти");
        
        private Integer num;
        private String title;
        
        MenuItem(Integer num, String title) {
            this.num = num;
            this.title = title;
        }

        public Integer getNum() {
            return num;
        }

        public String getTitle() {
            return title;
        }
        
        @Override
        public String toString() {
            return String.format("%d. %s", getNum(),getTitle());
        }
    }
}
