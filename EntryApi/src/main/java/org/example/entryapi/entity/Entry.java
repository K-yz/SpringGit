package org.example.entryapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="Title")
    private String title;

    @Column(name="Content")
    private String content;

    @Column(name="Rate")
    private String rate;

    @Column(name="Created")
    private String created;

    @Column(name="Author")
    private String author;

    public Entry(int id, String title, String content, String rate, String created, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rate = rate;
        this.created = created;
        this.author = author;
    }
    public Entry(String title, String content, String rate, String created, String author) {
        this.title = title;
        this.content = content;
        this.rate = rate;
        this.created = created;
        this.author = author;
    }

    public Entry() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Entry [id=" + id + ", title=" + title + ", content=" + content + ", rate=" + rate + ", created=" + created + ", author=" + author + "]";
    }
}
