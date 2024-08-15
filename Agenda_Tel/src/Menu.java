import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    static int  resposta = 0;



    public static void menu() {
        do {


            System.out.println(">>>> Menu Contato <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Exibir Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Remover Contato");
            System.out.println("5 - Sair");

            resposta = Integer.parseInt(Agenda.input.nextLine());

            switch (resposta) {
                case 1:
                    Agenda.adicionarContato(Agenda.matriz);
                    break;
                case 2:
                    Agenda.exibirContatos();
                    break;
                case 3:
                    Agenda.editarContato(Agenda.matriz);
                    break;
                case 4:
                    Agenda.removerContato();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Insira uma opção válida");

            }
        } while (resposta != 5);


    }

    }



