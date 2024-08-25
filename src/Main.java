import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerencia gerenciador = new Gerencia();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n ---- Menu ---- ");
            System.out.println("1. Salvar");
            System.out.println("2. Listar");
            System.out.println("3. Deletar");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, email);
                    gerenciador.salvarPessoa(pessoa);
                    break;
                case 2:
                    gerenciador.listarPessoas();
                    break;
                case 3:
                    System.out.println("Digite o email da pessoa a ser deletada: ");
                    String emailDeletar = scanner.nextLine();
                    gerenciador.deletarPessoa(emailDeletar);
                    break;
                case 0:
                    System.out.println("Finalizando execução...");
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}