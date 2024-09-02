package io.drivasaf.springboot.quickstart.entity;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 20:48
 * @description:
 **/
public class User {
    private Long id;
    private String name;
    private int age;
    // Constructors, getters, and setters
    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
