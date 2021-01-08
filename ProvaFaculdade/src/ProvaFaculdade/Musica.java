package ProvaFaculdade;

public class Musica {

    private String titulo;
    private float duracao;
    private String qualidade;
    private String formato;
    private int ano;    
    private Interprete interprete;
    private Estilo estilo;
    private Album album;

//Construtores        
    public Musica() {
    }

    public Musica(String titulo, float duracao, String qualidade, String formato, int ano) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.qualidade = qualidade;
        this.formato = formato;
        this.ano = ano;
    }

    public Musica(String titulo, float duracao, String qualidade, String formato, int ano, Interprete interprete, Estilo estilo, Album album) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.qualidade = qualidade;
        this.formato = formato;
        this.ano = ano;
        this.interprete = interprete;
        this.estilo = estilo;
        this.album = album;
    }

//Getter e setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Interprete getInterprete() {
        return interprete;
    }

    public void setInterprete(Interprete interprete) {
        this.interprete = interprete;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }  

//Metodos
    public void printarMusica() {
        System.out.print(this.getTitulo());
        System.out.print(" " + this.getInterprete().getNome());
        System.out.print(" " + this.getDuracao());
        System.out.print(" " + this.getEstilo().getDescricao());
        System.out.println("");
    }

}
