/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="itemservico")
public class ItemServico implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_itemservico", sequenceName = "seq_itemservico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itemservico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A quantidade deve ser informado")
    @Column(name = "quantidade", nullable = false)
    private Double quantidade;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valorUnitario", nullable = false)
    private Double valorUnitario;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false )
    private Servico servico;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ordemservico", referencedColumnName = "id", nullable = false )
    private OrdemServico ordemservico;
    
    public ItemServico(){
        
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.getId());
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
        final ItemServico other = (ItemServico) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemServico getOrdemservico() {
        return ordemservico;
    }

    public void setOrdemservico(OrdemServico ordemservico) {
        this.ordemservico = ordemservico;
    }
    
    
}
