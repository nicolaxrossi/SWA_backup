package org.univaq.swa.sdv.sdvrest.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stefa
 */
public class UtenteTask {
    private int id;
    private Integer voto;
    private Utente utente; // l'utente che riceve il voto
    private Task task;
    private static int cont = 1;

    public UtenteTask() {
        id = cont;
        cont++;
        voto = null;
        utente = new Utente();
        task = new Task();
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
