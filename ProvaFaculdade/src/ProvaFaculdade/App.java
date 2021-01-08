package ProvaFaculdade;

import java.util.Scanner;

public class App {

    public static void testar() {
        Scanner leitorDeEntrada = new Scanner(System.in);

        Musica m1 = new Musica();
        Musica m2 = new Musica();
        Musica m3 = new Musica();
        Musica m4 = new Musica();
        Musica m5 = new Musica();
                
        popularMusica(m1, leitorDeEntrada);
        popularMusica(m2, leitorDeEntrada);
        popularMusica(m3, leitorDeEntrada);
        popularMusica(m4, leitorDeEntrada);
        popularMusica(m5, leitorDeEntrada);

        System.out.println("MUSICA INTÉRPRETE DURAÇÃO ESTILO");

        m1.printarMusica();
        m2.printarMusica();
        m3.printarMusica();
        m4.printarMusica();
        m5.printarMusica();

        leitorDeEntrada.close();
        
        
    }

    //Metodos
    public static void popularMusica(Musica musica, Scanner leitorDeEntrada) {
        System.out.println("Qual será o título da música?");
        musica.setTitulo(leitorDeEntrada.next());
        leitorDeEntrada.nextLine();
        System.out.println("Qual será a duração da música?");
        musica.setDuracao(leitorDeEntrada.nextFloat());
        System.out.println("Qual será a qualidade? 1-BAIXA 2-ALTA");
        int testeQualidade = leitorDeEntrada.nextInt();
        while (testeQualidade != 1 && testeQualidade != 2) {
            System.out.println("DIGITE APENAS 1 OU 2");
            System.out.println("Qual será a qualidade? 1-BAIXA 2-ALTA");
            testeQualidade = leitorDeEntrada.nextInt();
        }
        switch (testeQualidade) {
            case 1:
                musica.setQualidade("BAIXA");
                break;
            case 2:
                musica.setQualidade("ALTA");
                break;
        }
        System.out.println("Qual será o formato?");
        musica.setFormato(leitorDeEntrada.next());
        System.out.println("Qual é o ano da música?");
        musica.setAno(leitorDeEntrada.nextInt());

        //Interprete
        Interprete interprete = new Interprete();
        System.out.println("Qual é nome do intérprete?");
        interprete.setNome(leitorDeEntrada.next());
        System.out.println("Qual é o tipo do intérprete? (cantor, cantora, dupla, trio, conjunto ou banda)");
        String testeInterprete = leitorDeEntrada.next().toLowerCase();
        while (!("cantor".equals(testeInterprete)
                || "cantora".equals(testeInterprete)
                || "dupla".equals(testeInterprete)
                || "trio".equals(testeInterprete)
                || "conjunto".equals(testeInterprete)
                || "banda".equals(testeInterprete))) {
            System.out.println("SELECIONE UM DOS INDICADOS");
            System.out.println("Qual é o tipo do intérprete? (cantor, cantora, dupla, trio, conjunto ou banda)");
            testeInterprete = leitorDeEntrada.next().toLowerCase();
        }
        //interprete.setTipo(testeInterprete);
        musica.setInterprete(interprete);

        //Estilo
        Estilo estilo = new Estilo();
        System.out.println("Qual é o estilo da música? (Rock, Samba, Fritadeira)");
        String testeEstilo = leitorDeEntrada.next().toLowerCase();
        while (!("rock".equals(testeEstilo)
                || "samba".equals(testeEstilo)
                || "fritadeira".equals(testeEstilo))) {
            System.out.println("SELECIONE UM DOS INDICADOS");
            System.out.println("Qual é o estilo da música? (Rock, Samba, Fritadeira)");
            testeEstilo = leitorDeEntrada.next().toLowerCase();
        }
        estilo.setDescricao(testeEstilo);
        musica.setEstilo(estilo);
        System.out.println("===============================================");
    }
}
