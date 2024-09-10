package io.drivesaf.springboot.thymeleaf.model;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/09 15:37
 * @description:
 **/
public class Task {
    private Long id;
    private String name;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false;
    }
}
