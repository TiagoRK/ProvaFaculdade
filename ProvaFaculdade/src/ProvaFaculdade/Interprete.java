package ProvaFaculdade;

public class Interprete {

    private String nome;

//Construtores    
    public Interprete() {
    }

    public Interprete(String nome, String tipo) {
        this.nome = nome;
    }

//Getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
