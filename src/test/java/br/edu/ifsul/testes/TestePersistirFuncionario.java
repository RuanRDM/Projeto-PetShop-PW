
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class TestePersistirFuncionario {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Funcionario f = new Funcionario();
        //e.setId(1);
        f.setAtivo(true);
        f.setNomeUsuario("Ruan Delatorre");
        f.setSenha("12345");
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
