package me.luajk.company.model;

import me.luajk.dictionary.model.Dictionary;
import me.luajk.user.model.User;

public class Company {

    private String id;
    private String title;
    private Dictionary dest;
    private Dictionary start;
    private String contact;
    private String date;
    private int last;
    private int num;
    private String desc;
    private User user;

    public Company() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dictionary getDest() {
        return dest;
    }

    public void setDest(Dictionary dest) {
        this.dest = dest;
    }

    public Dictionary getStart() {
        return start;
    }

    public void setStart(Dictionary start) {
        this.start = start;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
