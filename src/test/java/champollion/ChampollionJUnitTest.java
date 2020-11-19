package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Salle salle;
        Date debut = new Date();
        int duree = 60;
        Intervention cours;
        

		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                salle = new Salle("207", 50); 
                cours = new Intervention(salle, untel, uml, debut, duree);
                
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testSousServiceVrai(){
            //Un nouvel enseignant est en sous-service
            assertTrue(untel.enSousService(), "Un nouvel enseignant doit être en sous-service");
        }
        
        @Test
        public void testSousServiceFaux(){
            untel.ajouteEnseignement(uml, 0, 300, 0);
            // un enseignant avec 300h de TD ne doit pas être en sous-service
            assertFalse(untel.enSousService(), "un enseignant avec 300h de TD ne doit pas être en sous-service");
        }	
        
        @Test
        public void testHeuresPrevuPourUE(){
            untel.ajouteEnseignement(uml, 0, 10, 0);
            untel.ajouteEnseignement(java, 0, 20 , 0);
            assertEquals(20, untel.heuresPrevuesPourUE(java), " L'enseignant doit avoir 20 heures de prévues pour java");
        }
        
        
        @Test
        public void testAjouteIntervention(){
             untel.ajouteIntervention(cours);
             assertTrue(untel.getMesInterventions().contains(cours));
        }
}
