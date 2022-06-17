package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author nicola
 */
public class UtenteMinimale {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    
    public UtenteMinimale() {
        id = 0;
        nome = "";
        cognome = "";
        email = "";
    }

    @JsonIgnore
    public void setId(int id) {
        this.id = id;
    }
    
    @JsonIgnore
    public int getId(){
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
