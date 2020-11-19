

package champollion;
import java.util.*;
        
public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    
    private Set<Intervention> mesInterventions = new HashSet<>();
    private final List<ServicePrevu> servicesPrevus = new LinkedList<>();


    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public Set<Intervention> getMesInterventions() {
        return mesInterventions;
    }
    
    
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *@return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        // throw new UnsupportedOperationException("Pas encore implémenté");
        double somme = 0;
        for (ServicePrevu s: servicesPrevus){
            somme = somme + s.getVolumeTP()*0.75 + s.getVolumeTD() + s.getVolumeCM()*1.5;
        }
        return (int) Math.round(somme);
        }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        double somme = 0;
        for (ServicePrevu s: servicesPrevus){
            if (ue.equals(s.getUe())){
                somme = somme + s.getVolumeTP()*0.75 + s.getVolumeTD() + s.getVolumeCM()*1.5;
            }
        }
        return (int) Math.round(somme);
    }
    

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        ServicePrevu enseignement = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
        this.servicesPrevus.add(enseignement);
    }
    
    public int heuresPlanifiees(){
        throw new UnsupportedOperationException("Pas encore implémenté");
        
    }
    
    public boolean enSousService(){
        //throw new UnsupportedOperationException("Pas encore implémenté");
        if (this.heuresPrevues() < 192){
            return true;
        }
        return false;
    }
    
    public void ajouteIntervention(Intervention e){
        //throw new UnsupportedOperationException("Pas encore implémenté");
        this.mesInterventions.add(e);
    }
    
}
