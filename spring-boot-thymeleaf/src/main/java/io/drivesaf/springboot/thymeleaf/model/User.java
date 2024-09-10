package io.drivesaf.springboot.thymeleaf.model;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 18:38
 * @description:
 **/
public class User {
    private Long id;
    private String name;
    private String email;

    public User(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
