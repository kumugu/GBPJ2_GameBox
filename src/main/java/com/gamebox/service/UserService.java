package com.gamebox.service;

import com.gamebox.dao.UsersDAO;
import com.gamebox.dto.UsersDTO;

public class UserService {
    private UsersDAO usersDAO = new UsersDAO();

    public boolean validateUser(String username, String password) {
        UsersDTO user = usersDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
