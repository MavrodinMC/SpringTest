package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @NotBlank
    @Column(name="title")
    private String title;

    @NotBlank
    @Column(name="content")
    private String content;

    public Blog() {
    }

    public Blog(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
