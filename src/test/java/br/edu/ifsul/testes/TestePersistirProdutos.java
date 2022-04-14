
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produtos;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class TestePersistirProdutos {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Produtos p = new Produtos();
        //p.setId(1);
        p.setNome("Sabão");
        p.setValor(50.0);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
