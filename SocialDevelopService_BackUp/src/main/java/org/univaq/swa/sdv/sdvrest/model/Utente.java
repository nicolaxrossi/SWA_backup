package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stefa
 */
public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String username;
    private String password;
    private static int cont = 1;
    private List<Skill> skills; // lista di skill che l'utente possiede

    public Utente() {
        id = cont;
        cont++;
        nome = "";
        cognome = "";
        email = "";
        telefono = "";
        username = "";
        password = "";

        skills = new ArrayList<>();
    }
    
    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    @JsonProperty
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    @JsonProperty
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    @JsonProperty
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonIgnore
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @JsonProperty
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + '}';
    }
    
    public static Utente dummyUtente (int id, String nome, String cognome, String email, String telefono, String username, String password) {
        Utente utente = new Utente();
        
        utente.setId(id);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setTelefono(telefono);
        utente.setUsername(username);
        utente.setPassword(password);
        
        return utente;
    }
}
