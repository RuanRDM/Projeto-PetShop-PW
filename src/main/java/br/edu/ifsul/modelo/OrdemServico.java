
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.ItemServico;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertFalse.List;

@Entity
@Table(name="ordemservico")
public class OrdemServico implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_ordemservico", sequenceName = "seq_ordemservico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordemservico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")	
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false )
    private Pet pet;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "nomeUsuario", nullable = false )
    private Funcionario funcionario;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false )
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "ordemservico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ArrayList<ItemServico> itemservicos = new ArrayList<>();
    
    public void adicionarItemServico(ItemServico obj){
        obj.setOrdemservico(this);
        this.getItemservicos().add(obj);
    }
    
    public void removerItemServico(int index){
        this.getItemservicos().remove(index);
    }
    public OrdemServico(){
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<ItemServico> getItemservicos() {
        return itemservicos;
    }

    public void setItemservicos(ArrayList<ItemServico> itemservicos) {
        this.itemservicos = itemservicos;
    }
    

}
