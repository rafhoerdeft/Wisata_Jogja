package com.example.bayu.wisata_jogja.Model;

public class Ent_user {
    private String nama;
    private String username;
    private String password;

    public Ent_user(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public Ent_user() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
