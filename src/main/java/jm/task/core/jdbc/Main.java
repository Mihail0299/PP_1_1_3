package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
        //userService.dropUsersTable();
        userService.saveUser("Mihail", "Berezin", (byte) 23);
        userService.saveUser("Alexandra", "Berezina", (byte) 24);
        //userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
    }
}
