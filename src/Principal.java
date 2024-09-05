import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();

        int opcao, id = 0;
        do {
            gerenciador.listarOpcoes();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    gerenciador.adicionarTarefa();
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite o id da tarefa para marcá-la como concluída: ");
                    id = sc.nextInt();
                    gerenciador.marcarComoConcluida(id);
                    break;
                case 4:
                    System.out.print("Digite o id da tarefa para excluí-la: ");
                    id = sc.nextInt();
                    gerenciador.excluirTarefa(id);
                    break;
                case 5:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Digite uma opção valida!");
            }

        } while (opcao != 5);
    }
}
