/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;
import java.util.*;


/**
 *
 * @author mathi
 */
public class Intervention {
    
    private Date debut;
    private int duree; 
    private boolean annulee = false;
    private UE matiere;
    private Salle lieu;
    

    public Intervention(Salle s, Enseignant e, UE ue, Date debut, int duree) {
        this.debut = debut;
        this.duree = duree;
        this.matiere = ue;
        this.lieu = s;
        
        
    }

    @Override
    public String toString() {
        return "Intervention{" + "debut=" + debut + ", duree=" + duree + ", annulee=" + annulee + '}';
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public Salle getLieu() {
        return lieu;
    }

    public void setLieu(Salle lieu) {
        this.lieu = lieu;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }
    
    public void setMatiere(UE ue){
        matiere = ue;
    }
    
    public UE getMatiere(){
        return matiere;
    }
    
    
}
