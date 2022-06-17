package org.univaq.swa.sdv.sdvrest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 *
 * @author stefa
 */

/*@JsonAutoDetect(
    fieldVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE
)*/

public class Messaggio {
    private int id;
    private String testo;
    private LocalDateTime dataOra;
    private boolean pubblico;
    //private Progetto p;
    
    // contatore per autoincrement dell'id
    private static int cont = 1;
    
    UtenteMinimale mittente; // Utente che scrive il messaggio

    public Messaggio() {
        id = cont;
        cont++;
        testo = "";
        //dataOra = LocalDateTime.now();
        pubblico = false;
        //mittente = new Utente();
    }
    
    @JsonIgnore
    public int getId() {
        return id;
    }
    
    @JsonIgnore
    public void setId(int id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }
    
    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }
    
    @JsonIgnore
    public boolean isPubblico() {
        return pubblico;
    }

    @JsonIgnore
    public void setPubblico(boolean pubblico) {
        this.pubblico = pubblico;
    }

    @JsonProperty
    public UtenteMinimale getMittente() {
        return mittente;
    }

    @JsonIgnore
    public void setMittente(UtenteMinimale mittente) {
        this.mittente = mittente;
    }
}
