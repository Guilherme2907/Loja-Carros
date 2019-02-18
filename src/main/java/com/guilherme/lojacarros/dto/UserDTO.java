package com.guilherme.lojacarros.dto;

import com.guilherme.lojacarros.domain.User;
import java.io.Serializable;

/**
 *
 * @author Guilherme
 */
public class UserDTO implements Serializable {

    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
