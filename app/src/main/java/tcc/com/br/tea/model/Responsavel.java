package tcc.com.br.tea.model;

public class Responsavel {
    private  String uid;
    private  String nome;
    private  String contato;
    private  String login;
    private  String senha;

    public Responsavel(String nome, String contato, String login, String senha) {
        this.uid = uid;
        this.nome = nome;
        this.contato = contato;
        this.login = login;
        this.senha = senha;
    }

    public Responsavel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        return nome;
    }

}
