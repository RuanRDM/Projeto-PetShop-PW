package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPet {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class,2);
        Pet p = new Pet();
        //e.setId(1);
        p.setNome("PinscherNervoso");
        p.setRaca(r);
        Calendar cal = Calendar.getInstance();
        cal.set(2010, 11, 23);
        p.setNascimento(cal);
        p.setEspecie("Cachorro");
        p.setPeso(15.0);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}