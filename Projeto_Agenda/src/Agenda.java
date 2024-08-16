import java.util.Scanner;

public class Agenda {

    //Temos que mudar a remoção para telefone
    //Temos que criar a função Detalhar Contato
    //Temos que criar o readme

    static Scanner input = new Scanner(System.in);
    static int indiceDeContagem = 0;
    static int nLinhas = 15;
    static int contadorId = 0;
    static String[][] matriz = new String[nLinhas][4];


    public static void exibirContatos() {

        for (int i = 0; i < matriz.length; i++) {

            if(matriz[i][0] != null & matriz[i][0] != "") {
                System.out.println("ID: " + matriz[i][0] + ", Nome: " + matriz[i][1] +
                        ", telefone: " + matriz[i][2] + ", Email: " + matriz[i][3]);
                System.out.println("--------------------------------------------------------------------------");

            }
        }
    }

    public static boolean verificarNumero(String telefone){
        boolean telefoneJaCadastrado = false;
        
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null && !matriz[i][0].isEmpty() && matriz[i][2] != null && matriz[i][2].equals(telefone)) {
                telefoneJaCadastrado = true;
                System.out.println("Esse telefone já está cadastrado por outro usuário, por favor disponibilize outro telefone:");
                break;
            }
        }
    
        return telefoneJaCadastrado;
    }
    
    public static void adicionarContato(String[][] matriz) {
        int id = contadorId + 1;
    
        matriz[contadorId][0] = String.valueOf(id);
    
        System.out.println("Digite o nome do usuário:");
        matriz[contadorId][1] = input.nextLine();
    
        boolean telefoneJaCadastrado;
        String telefone;
    
        do {
            System.out.println("Digite o telefone:");
            telefone = input.nextLine();
            telefoneJaCadastrado = verificarNumero(telefone);
        } while (telefoneJaCadastrado);
    
        matriz[contadorId][2] = telefone;
    
        System.out.println("Digite o email:");
        matriz[contadorId][3] = input.nextLine();
    
        System.out.println("Registro inserido com sucesso. ID: " + id);
        contadorId++;
    }
    

    public static void editarContato(String[][] matriz) {
        System.out.print("Digite o Telefone do registro a ser editado: ");
        String editarId = input.nextLine();
        boolean usuarioEncontrado = false;
    
        for (int i = 0; i < contadorId; i++) {
            if (matriz[i][2] != null && matriz[i][2].equals(editarId)) {
                usuarioEncontrado = true;
    
                System.out.print("Novo Nome: ");
                matriz[i][1] = input.nextLine();
    
                System.out.print("Novo Número de telefone: ");
                matriz[i][2] = input.nextLine();
    
                System.out.print("Novo Email: ");
                matriz[i][3] = input.nextLine();
    
                System.out.println("Registro atualizado com sucesso.");
                break;
            }
        }
    
        if (!usuarioEncontrado) {
            System.out.println("Esse usuário não está registrado.");
            System.out.println("--------------------------------------------------------------------------");
        }
    }
    


    public static void removerContato(){
//exibir os contatos e perguntar qual o que queremos remover
        exibirContatos();
//Pedindo o id que é para deletar
        System.out.print("Digite o ID do registro a ser excluído: ");
        String deletarId = input.nextLine();

        for(int i=0 ; i< matriz.length ; i++){
//verifica se o contato é null
            if(matriz[i][0].equals("")){
                continue;
            }else if(matriz[i][0].equals(deletarId)){
                String[] tempContato = matriz[i];
                matriz[i] = new String[]{"","","",""};
                System.out.println("Usuário deletado com sucesso => id: " + tempContato[0]);
                break;
            }
        }


    }

    public static void detalharContato(){}
}
