package tcc.com.br.tea.model;

import java.io.Serializable;

public class Dependente implements Serializable {

    private int id = 0;
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String contato;

    public Dependente(String nome, String dataNascimento, String endereco, String contato) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Dependente(){

    }

     public void  setNome(String nome) {
         this.nome = nome;
     }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean temIdValido(){
        return id > 0;
    }

    @Override
    public String toString() {
        return nome;
    }

}
