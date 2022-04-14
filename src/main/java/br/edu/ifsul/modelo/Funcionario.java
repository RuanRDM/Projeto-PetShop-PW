package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.edu.ifsul.modelo.Pessoa;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{
    
    @Id
    @NotBlank(message = "O nome do usuário deve ser informado")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres")   
    @Column(name = "nomeUsuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha não pode ficar em branco")
    @Length(max = 50, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    


    
    public Funcionario(){
        
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
