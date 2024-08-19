import java.util.Scanner;


public class Agenda {

    static Scanner input = new Scanner(System.in);
    static int indiceDeContagem = 0;
    static int nLinhas = 15;
    static int contadorId = 0;
    static String[][] matriz = new String[nLinhas][4];
    static int numeroDeRegistro = 0;


    public static boolean numeroDeRegistro() {
        if (numeroDeRegistro == 0) {
            System.out.printf(" Nenhum registro armazenado.%n");
            return false;
        }
        return true;
    }

    public static String validacaoDeInt(String question, String messageError) {
        String result;

        while(true) {
            try {
                System.out.printf(question);
                result = input.nextLine();
                // int resultado = Integer.parseInt(result);
                Integer.parseInt(result);
                break;
            } catch (Exception e) {
                System.out.printf(messageError);
            }
        }

        return result;
    }

    public static boolean telefoneContaNaBase(String telefone) {
        boolean telefoneJaCadastrado = false;

        for (int i = 0; i < matriz.length; i++) {
            //if (matriz[i][0] != null && !matriz[i][0].isEmpty() && matriz[i][2] != null && matriz[i][2].equals(telefone)) {
            if (matriz[i][2] != null && matriz[i][2].equals(telefone)) {
                telefoneJaCadastrado = true;
                System.out.printf("%n Esse telefone já está cadastrado por outro usuário, por favor disponibilize outro telefone: %n");
                break;
            }
        }

        return telefoneJaCadastrado;
    }

    public static void adicionarContato() {
        int id = contadorId + 1;
        numeroDeRegistro = numeroDeRegistro + 1;

        matriz[contadorId][0] = String.valueOf(id);

        System.out.println("Digite o nome do usuário:");
        matriz[contadorId][1] = input.nextLine();

        boolean telefoneJaCadastrado;
        String telefone;

        do {
            telefone = validacaoDeInt("Informe um número: %n", "Número inválido, digite novamente!");
            telefoneJaCadastrado = telefoneContaNaBase(telefone);
        } while (telefoneJaCadastrado);

        matriz[contadorId][2] = telefone;

        System.out.println("Digite o email:");
        matriz[contadorId][3] = input.nextLine();

        System.out.printf("%n Registro inserido com sucesso. ID: %s%n ", id);
        contadorId++;
    }

    public static void exibirContatos() {

        if (!numeroDeRegistro())
            return;

        System.out.printf("%n Registros armazenados: %d%n", numeroDeRegistro);
        for (int i = 0; i < matriz.length; i++) {

            if(matriz[i][0] != null && matriz[i][0] != "") {
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        ", telefone: " + matriz[i][2] + ", Email: " + matriz[i][3]);
                System.out.println("--------------------------------------------------------------------------");

            }
        }

    }

    public static void buscarContato() {

        if (!numeroDeRegistro()) {
            return;
        }

        String pesquisarTel = validacaoDeInt("%nDigite o Telefone Registrado:  %n", "Número inválido, digite novamente! %n");
        boolean usuarioEncontrado = false;

        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTel)) {
                usuarioEncontrado = true;
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        ", telefone: " + matriz[i][2] + ", Email: " + matriz[i][3]);
                System.out.println("--------------------------------------------------------------------------");
                break;
            }

        }
        if (!usuarioEncontrado) {
            System.out.println();
            System.out.println("Registro com o telefone " + pesquisarTel + " não encontrado.");
            System.out.println();
        }
    }

    public static void editarContato() {

        if (!numeroDeRegistro()) {
            return;
        }

        String pesquisarTelefone = validacaoDeInt("Digite o Telefone do registro a ser editado: ", "Número incorreto");
        boolean telefoneJaCadastrado;
        boolean usuarioEncontrado = false;
        String telefone;
        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTelefone)) {
                usuarioEncontrado = true;

                System.out.print("Novo Nome: ");
                matriz[i][1] = input.nextLine();

                do {
                    telefone = validacaoDeInt("Novo número: %n", "Número inválido, digite novamente!");
                    telefoneJaCadastrado = telefoneContaNaBase(telefone);
                }while(telefoneJaCadastrado);

                matriz[i][2] = telefone;

                System.out.print("Novo Email: ");
                matriz[i][3] = input.nextLine();

                System.out.printf("%n Registro atualizado com sucesso.");
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.printf("%n Esse usuário não está registrado. %n");
            System.out.println("--------------------------------------");
        }
    }

    public static void removerContato() {

        if (!numeroDeRegistro()) {
            return;
        }


        String pesquisarTel = validacaoDeInt("Digite o número a ser removido: ", "Número inválido");
        boolean usuarioEncontrado = false;




        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(pesquisarTel)) {
                usuarioEncontrado = true;
                String[] tempContato = matriz[i];
                matriz[i] = new String[]{"","","",""};
                System.out.printf(" %n Usuário deletado com sucesso => tel: %s %n" , tempContato[2]);
                numeroDeRegistro--;
                break;
            }

        }
        if (!usuarioEncontrado) {
            System.out.println();
            System.out.println("Registro com o telefone " + pesquisarTel + " não encontrado.");
            System.out.println();
        }
    }


}
