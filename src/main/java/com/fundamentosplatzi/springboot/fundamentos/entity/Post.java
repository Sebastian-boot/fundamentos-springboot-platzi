package com.fundamentosplatzi.springboot.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_post", nullable = false, unique = true)
    private Long Id;
    @Column(name = "Description", length = 255)
    private String Description;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        Description = description;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", Description='" + Description + '\'' +
                ", user=" + user +
                '}';
    }
}
