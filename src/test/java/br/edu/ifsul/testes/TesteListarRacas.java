package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteListarRacas {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("Lista de Raças: ");
        List<Raca> lista = em.createQuery("from Raca order by id").getResultList();
        for (Raca r : lista){
            System.out.println("Id: " + r.getId() + " Nome: " + r.getNome());
        }
      
        em.close();
        emf.close();
    }
    
}