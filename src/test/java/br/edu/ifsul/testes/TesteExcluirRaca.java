package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteExcluirRaca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 4);
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}