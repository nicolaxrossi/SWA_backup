package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author stefa
 */
public class Skill {
    private int id;
    private String nome;
    private static int cont = 1;

    public Skill() {
        id = cont;
        cont++;
        nome = "";
    }
    
    public int getId() {
        return id;
    }

    @JsonIgnore
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
    
    public static Skill dummySkills (String nome) {
        
        Skill s = new Skill();
        s.setNome(nome);
        
        return s;
    }
}
