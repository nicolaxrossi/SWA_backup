package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class Task {
    private int id;
    private String nome;
    private String descrizione;
    private boolean attivo;
    private static int cont = 1;
    
    List<Skill> skill_richieste;
    List<UtenteMinimale> collaboratori;

    public Task() {
        id = cont;
        cont++;
        
        nome = "";
        descrizione = "";
        attivo = true;

        skill_richieste = new ArrayList<>();
        collaboratori = new ArrayList<>();
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
    
    @JsonIgnore
    public List<Skill> getSkills() {
        return skill_richieste;
    }
    
    public void setSkills (List<Skill> skills) {
        this.skill_richieste = skills;
    }

    @JsonIgnore
    public List<UtenteMinimale> getCollaboratori() {
        return collaboratori;
    }

    public void setCollaboratori(List<UtenteMinimale> collaboratori) {
        this.collaboratori = collaboratori;
    }
    
    public static Task dummyTask (String nome) {
        
        Task t = new Task();
        t.setNome(nome);
        
        return t;
    }
}
