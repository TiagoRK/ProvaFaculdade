package ProvaFaculdade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        Scanner leitorDeEntrada = new Scanner(System.in);
        List<Album> albuns = new ArrayList<>();
        imprimeMenuPrincipal(albuns, leitorDeEntrada);
        
    }
//Métodos

    public static void imprimeMenuPrincipal(List<Album> albuns, Scanner leitorDeEntrada) {
        int comando = 0;
        while (comando != 5) {
            System.out.println("1-Ver tudo\n2-Adicionar Album\n3-Editar Album\n4-Remover album\n5-Sair");
            comando = leitorDeEntrada.nextInt();
            boolean digitouCerto = comando == 1 || comando == 2 || comando == 3 || comando == 4 || comando == 5;
            while (!digitouCerto) {
                System.out.println("ESCOLHA UM DOS NUMEROS INDICADOS!");
                System.out.println("1-Ver tudo\n2-Adicionar Album\n3-Editar Album\n4-Remover album\n5-Sair");
                comando = leitorDeEntrada.nextInt();
                digitouCerto = comando == 1 || comando == 2 || comando == 3 || comando == 4 || comando == 5;
            }
            switch (comando) {
                case 1:
                    imprimirTudo(albuns, leitorDeEntrada);
                    break;
                case 2:
                    adicionarAlbum(albuns, leitorDeEntrada);
                    break;
                case 3:
                    imprimeMenuAlbum(albuns, leitorDeEntrada);
                    break;
                case 4:
                    removerAlbum(albuns, leitorDeEntrada);
                    break;

            }
        }
    }

    public static void imprimeMenuAlbum(List<Album> albuns, Scanner leitorDeEntrada) {
        if (albuns.isEmpty()){
            System.out.println("NÃO EXISTEM ALBUNS PARA EDITAR!");
            return;
        }
        int comando;
        for (int i = 0; i < albuns.size(); i++) {
            Album albumDaLista = albuns.get(i);
            System.out.println(i + "- " + albumDaLista.getTitulo());
        }
        System.out.println("Qual album deseja editar?");
        int albumEscolhido = leitorDeEntrada.nextInt();
        Album albumDaLista = albuns.get(albumEscolhido);
        
        System.out.println("1-Editar atributos do album\n2-Adicionar música\n3-Editar música\n4-Remover música");
        comando = leitorDeEntrada.nextInt();
        boolean digitouCerto = comando == 1 || comando == 2 || comando == 3 || comando == 4;
        while (!digitouCerto) {
            System.out.println("ESCOLHA UM DOS NUMEROS INDICADOS!");
            System.out.println("1-Editar atributos do album\n2-Adicionar música\n3-Editar música\n4-Remover música");
            comando = leitorDeEntrada.nextInt();
            digitouCerto = comando == 1 || comando == 2 || comando == 3 || comando == 4;
        }
        switch (comando) {
                case 1:
                    editarAlbum(albumDaLista, leitorDeEntrada);
                    break;
                case 2:
                    adicionarMusica(albumDaLista, leitorDeEntrada);
                    break;
                case 3:
                    editarMusicaDoAlbum(albumDaLista, leitorDeEntrada);
                    break;
                case 4:
                    removerMusica(albumDaLista, leitorDeEntrada);
                    break;

            }
    }

    public static void imprimirTudo(List<Album> albuns, Scanner leitorDeEntrada) {
        for (int i = 0; i < albuns.size(); i++) {
            Album albumDaLista;
            albumDaLista = albuns.get(i);
            System.out.println("O título do album é: " + albumDaLista.getTitulo());
            System.out.println("O ano de lançamento do album é: " + albumDaLista.getAnoDeLancamento());
            List<Musica> musicasDoAlbum;
            musicasDoAlbum = albumDaLista.getMusicas();
            for (int j = 0; j < musicasDoAlbum.size(); j++) {
                Musica musicaDaLista = musicasDoAlbum.get(j);
                System.out.println("        MUSICA:");
                System.out.println("        O titulo é: " + musicaDaLista.getTitulo());
                System.out.println("        A duração é: " + musicaDaLista.getDuracao());
                System.out.println("        A qualidade é: " + musicaDaLista.getQualidade());
                System.out.println("        O formato é: " + musicaDaLista.getFormato());
                System.out.println("        O ano de lançamento é: " + musicaDaLista.getAno());
                System.out.println("        O intérprete é: " + musicaDaLista.getInterprete().getNome() + " Do tipo: " + musicaDaLista.getInterprete().getClass().getSimpleName());
                System.out.println("        O estilo é: " + musicaDaLista.getEstilo().getDescricao());
                System.out.println("========================================================");
            }
        }
    }

    public static void adicionarAlbum(List<Album> albuns, Scanner leitorDeEntrada) {
        Album novoAlbum = new Album();
        System.out.println("Qual será o título do album?");
        novoAlbum.setTitulo(leitorDeEntrada.next());
        leitorDeEntrada.nextLine();
        System.out.println("Qual será o ano de lançamento do album?");
        novoAlbum.setAnoDeLancamento(leitorDeEntrada.nextInt());
        int testeAdicionarMusicas;
        System.out.println("Quer adicionar músicas neste album? 1-SIM 2-NÃO");
        testeAdicionarMusicas = leitorDeEntrada.nextInt();
        if (testeAdicionarMusicas == 1) {
            adicionarMusica(novoAlbum, leitorDeEntrada);
        }
        albuns.add(novoAlbum);
    }

    public static void removerAlbum(List<Album> albuns, Scanner leitorDeEntrada) {
        for (int i = 0; i < albuns.size(); i++) {
            Album albumDaLista = albuns.get(i);
            System.out.println(i + "- " + albumDaLista.getTitulo());
        }
        System.out.println("Qual album deseja remover?");
        int albumQueVaiSerRemovido = leitorDeEntrada.nextInt();
        albuns.remove(albumQueVaiSerRemovido);
    }

    public static void editarAlbum(Album album, Scanner leitorDeEntrada) {
        System.out.println("1 - Editar título\n2 - Ano de lançamento");
        int comando = leitorDeEntrada.nextInt();
        if (comando == 1) {
            System.out.println("Digite o novo título");
            album.setTitulo(leitorDeEntrada.next());
        } else if (comando == 2) {
            System.out.println("Digite o novo ano de lançamento");
            album.setAnoDeLancamento(leitorDeEntrada.nextInt());
        }
    }

    public static void adicionarMusica(Album album, Scanner leitorDeEntrada) {
        Musica novaMusica = new Musica();
        System.out.println("Qual será o título da música?");
        novaMusica.setTitulo(leitorDeEntrada.next());
        leitorDeEntrada.nextLine();
        System.out.println("Qual será a duração da música?");
        novaMusica.setDuracao(leitorDeEntrada.nextFloat());
        System.out.println("Qual será a qualidade? 1-BAIXA 2-ALTA");
        int testeQualidade = leitorDeEntrada.nextInt();
        while (testeQualidade != 1 && testeQualidade != 2) {
            System.out.println("DIGITE APENAS 1 OU 2");
            System.out.println("Qual será a qualidade? 1-BAIXA 2-ALTA");
            testeQualidade = leitorDeEntrada.nextInt();
        }
        switch (testeQualidade) {
            case 1:
                novaMusica.setQualidade("BAIXA");
                break;
            case 2:
                novaMusica.setQualidade("ALTA");
                break;
        }
        System.out.println("Qual será o formato?");
        novaMusica.setFormato(leitorDeEntrada.next());
        System.out.println("Qual é o ano da música?");
        novaMusica.setAno(leitorDeEntrada.nextInt());

        //Interprete
        Interprete interprete = new Interprete();
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
        switch (testeInterprete) {
            case "cantor":
                interprete = new Cantor();
                break;
            case "cantora":
                interprete = new Cantora();
                break;
            case "dupla":
                interprete = new Dupla();
                break;
            case "trio":
                interprete = new Trio();
                break;
            case "conjunto":
                interprete = new Conjunto();
                break;
            case "banda":
                interprete = new Banda();
                break;
        }
        System.out.println("Qual é nome do intérprete?");
        interprete.setNome(leitorDeEntrada.next());
        novaMusica.setInterprete(interprete);

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
        novaMusica.setEstilo(estilo);
        System.out.println("===============================================");

        //Adicionar musica ao album
        album.getMusicas().add(novaMusica);
    }

    private static void editarMusicaDoAlbum(Album album, Scanner leitorDeEntrada) {
        List<Musica> musicas = album.getMusicas();
        if (musicas.isEmpty()){
            System.out.println("NÃO EXISTE MÚSICAS PARA EDITAR!");
            return;
        }
        for (int i = 0; i < musicas.size(); i++) {
            Musica musicaParExibirTitulo = musicas.get(i);
            System.out.println(i + "- " + musicaParExibirTitulo.getTitulo());
        }
        System.out.println("Qual musica deseja editar?");
        int musicaQueVaiSerEditada = leitorDeEntrada.nextInt();
        Musica musicaParaEditar = musicas.get(musicaQueVaiSerEditada);
        editarMusica(musicaParaEditar, leitorDeEntrada);
    }

    private static void editarMusica(Musica musica, Scanner leitorDeEntrada) {
        System.out.println("Editar Música:\n1 - Titulo\n2 - Duração\n3 - Qualidade\n4 - Formato\n5 - Ano\n6 - Intérprete\n7 - Estilo");
        int comando = leitorDeEntrada.nextInt();
        switch (comando) {
            case 1:
                System.out.println("Novo titulo?");
                musica.setTitulo(leitorDeEntrada.next());
                break;
            case 2:
                System.out.println("Nova duração?");
                musica.setDuracao(leitorDeEntrada.nextFloat());
                break;
            case 3:
                System.out.println("Nova Qualidade?");
                musica.setQualidade(leitorDeEntrada.next());
                break;
            case 4:
                System.out.println("Novo Formato?");
                musica.setFormato(leitorDeEntrada.next());
                break;
            case 5:
                System.out.println("Novo ano de lançamento?");
                musica.setAno(leitorDeEntrada.nextInt());
                break;
            case 6:
                Interprete interprete = new Interprete();
                System.out.println("1 - Editar nome\n2 - Editar tipo");
                comando = leitorDeEntrada.nextInt();
                if (comando == 1) {
                    System.out.println("Novo nome: ");
                    interprete.setNome(leitorDeEntrada.next());
                } else if (comando == 2) {
                    System.out.println("Novo tipo: ");
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
                    String nomeInterprete = interprete.getNome();
                    switch (testeInterprete) {
                        case "cantor":
                            interprete = new Cantor();
                            break;
                        case "cantora":
                            interprete = new Cantora();
                            break;
                        case "dupla":
                            interprete = new Dupla();
                            break;
                        case "trio":
                            interprete = new Trio();
                            break;
                        case "conjunto":
                            interprete = new Conjunto();
                            break;
                        case "banda":
                            interprete = new Banda();
                            break;
                    }
                    interprete.setNome(nomeInterprete);
                    musica.setInterprete(interprete);
                }
                break;
            case 7:
                System.out.println("Novo Estilo?");
                musica.getEstilo().setDescricao(leitorDeEntrada.next());
                break;
        }
    }

    private static void removerMusica(Album album, Scanner leitorDeEntrada) {
        List<Musica> musicas = album.getMusicas();
        for (int i = 0; i < musicas.size(); i++) {
            Musica musicaDaLista = musicas.get(i);
            System.out.println(i + "- " + musicaDaLista.getTitulo());
        }
        System.out.println("Qual música deseja remover?");
        int musicaQueVaiSerRemovida = leitorDeEntrada.nextInt();
        musicas.remove(musicaQueVaiSerRemovida);
    }
}
