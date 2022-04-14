
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirOrdemServico {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        OrdemServico os = new OrdemServico();
        //p.setId(1);
        os.setDescricao("Ordem numero 1 teste blablabla");
        os.setValorTotal(5000.0);
        os.setData(Calendar.getInstance());
        
        
        os.setPessoa(em.find(Pessoa.class,1));
        os.setPet(em.find(Pet.class,1));
        os.setFuncionario(em.find(Funcionario.class,1));
        
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
