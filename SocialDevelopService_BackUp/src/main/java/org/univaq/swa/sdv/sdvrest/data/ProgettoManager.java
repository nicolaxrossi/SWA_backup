/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.univaq.swa.sdv.sdvrest.data;

import java.util.ArrayList;
import java.util.List;
import org.univaq.swa.sdv.sdvrest.model.Progetto;
import org.univaq.swa.sdv.sdvrest.model.Skill;
import org.univaq.swa.sdv.sdvrest.model.Task;

/**
 *
 * @author beato
 */

// la avevo fatta per prova, mi sa che è inutile, nel dubbio la lascio e la cancelliamo dopo
// nel senso, pensavo di usarla per l'op 7 ma alla fine ho fatto senza.
public class ProgettoManager {
    
    public static List<Progetto> listaProgetti = new ArrayList<Progetto>();
    
    public List<Progetto> getListaProgetti() {
        // p1 ha la listTask1 che contiene s1
        Progetto p1 = Progetto.dummyProgetto("progetto1", "descrizione1");
        Progetto p2 = Progetto.dummyProgetto("progetto2", "descrizione2"); 
        Task t1 = Task.dummyTask("task1");
        Task t2 = Task.dummyTask("task2");
        List<Task> listTask1 = p1.getTasks();
        listTask1.add(t1);
        List<Task> listTask2 = p2.getTasks();
        listTask2.add(t2);
        Skill s1 = Skill.dummySkills("skill1");
        Skill s2 = Skill.dummySkills("skill2"); 
        List<Skill> listSkill1 = t1.getSkills();
        listSkill1.add(s1);
        List<Skill> listSkill2 = t2.getSkills();
        listSkill2.add(s2);
        
        listaProgetti.add(p1);
        listaProgetti.add(p1);
        
        return listaProgetti;
    }
}
