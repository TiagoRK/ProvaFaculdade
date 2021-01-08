package ProvaFaculdade;    

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String titulo;
    private int anoDeLancamento;
    private List<Musica> musicas = new ArrayList<>();
        
//Construtores      

    public Album() {
    }

    public Album(String titulo, int anoDeLancamento) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
    }

//Getter e setter    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
