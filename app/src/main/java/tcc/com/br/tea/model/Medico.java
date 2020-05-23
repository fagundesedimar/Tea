package tcc.com.br.tea.model;

public class Medico {
    private final String nome;
    private final String crm;
    private final String senha;


    public Medico(String nome, String crm, String senha) {
        this.nome = nome;
        this.crm = crm;
        this.senha = senha;
    }

    public String toString(){
        return nome;
    }

}
