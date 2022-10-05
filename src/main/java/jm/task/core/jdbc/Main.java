package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService user1 = new UserServiceImpl();
        user1.createUsersTable();
        user1.saveUser("Mihail", "Berezin", (byte) 23);
        System.out.println("User с именем – Mihail добавлен в базу данных");
        user1.saveUser("Sasha", "Berezina", (byte) 24);
        System.out.println("User с именем – Sasha добавлен в базу данных");
        user1.saveUser("Svetlana", "Berezina", (byte) 46);
        System.out.println("User с именем – Svetlana добавлен в базу данных");
        user1.saveUser("Svetlana", "Panikhina", (byte) 68);
        System.out.println("User с именем – Svetlana добавлен в базу данных");
        System.out.println(user1.getAllUsers());
        user1.removeUserById(1);
        user1.removeUserById(2);
        user1.removeUserById(3);
        user1.removeUserById(4);
        user1.dropUsersTable();
    }
}
