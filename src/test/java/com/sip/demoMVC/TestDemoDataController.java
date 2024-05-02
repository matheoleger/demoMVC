package com.sip.demoMVC;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sip.demoMVC.entities.Etudiant;
import com.sip.demoMVC.repositories.EtudiantRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestDemoDataController {
	@Autowired
	private EtudiantRepository repo;
	
    @Test
    @Order(1)
    public void testCreateEtudiant()
    {
    	Etudiant savedEtudiant = repo.save(new Etudiant("Mathéo LEGER", 21));
    	
    	assertThat(savedEtudiant.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void testFindProductByNom() {
        Etudiant etudiant = repo.findByNom("Mathéo LEGER");    // findByName 
        assertThat(etudiant.getNom()).isEqualTo("Mathéo LEGER");
    }
    
    @Test 
	  @Order(3) 
	  public void testUpdateEtudiant() { 
	      Etudiant etudiant = repo.findByNom("Mathéo LEGER"); 
		  etudiant.setNom("LEGER Mathéo"); 
		  repo.save(etudiant); 
		  Etudiant updatedEtudiant = repo.findByNom("LEGER Mathéo"); 
		  assertThat(updatedEtudiant.getNom()).isEqualTo("LEGER Mathéo"); 
	  } 
	   
	
	  @Test 
	  @Order(4) 
	  public void testDeleteProduct() { 
	      Etudiant etudiant = repo.findByNom("LEGER Mathéo"); 
		  repo.deleteById(etudiant.getId()); 
		  Etudiant deletedEtudiant = repo.findByNom("LEGER Mathéo"); 
	      assertThat(deletedEtudiant).isNull();        
	  } 
}
