package tcc.com.br.tea.model;

public class Medico {
    private int id = 0;
    private String nome;
    private String crm;
    private String senha;


    public Medico(String nome, String crm, String senha) {

        this.nome = nome;
        this.crm = crm;
        this.senha = senha;
    }

    public Medico() {

    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        return nome;
    }

    public boolean temIdValido() {
        return id > 0;
    }

}
