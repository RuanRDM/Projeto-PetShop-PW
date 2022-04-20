
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Servico;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class TestePersistirServico {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Servico s = new Servico();
        //s.setId(1);
        
        s.setNome("Serviço de limpeza");
        s.setValor(1000000.00);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
