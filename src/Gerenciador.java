import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    ArrayList<Tarefas> listaDeTarefas;

    public Gerenciador(){
        listaDeTarefas = new ArrayList<>();
    }

    public void listarOpcoes(){
        System.out.println("====== GERENCIADOR DE TAREFAS ======");
        System.out.println("[1] Adicionar tarefa");
        System.out.println("[2] Listar tarefas");
        System.out.println("[3] Marcar como concluída");
        System.out.println("[4] Apagar tarefa");
        System.out.println("[5] Sair");
    }

    public void adicionarTarefa() {
        Tarefas tarefa = new Tarefas();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a descrição da tarefa: ");
        tarefa.setDescricao(sc.nextLine());

        listaDeTarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("A lista de tarefas está vazia.");
        } else {
            for (Tarefas tarefa : listaDeTarefas) {
                System.out.printf("%d - %s - %s%n", tarefa.getId(), tarefa.getStatus(), tarefa.getDescricao());
            }
        }
    }

    public void marcarComoConcluida(int id) {
        for (Tarefas tarefa : listaDeTarefas) {
            if (tarefa.getId() == id) {
                tarefa.setStatus("Concluída");
                System.out.printf("Tarefa %d marcada como concluída%n", tarefa.getId());
                return;
            }
        }
        System.out.println("A tarefa não existe.");
    }

    public void excluirTarefa(int id) {

        for (Tarefas tarefa : listaDeTarefas) {
            if (tarefa.getId() == id) {
                listaDeTarefas.remove(tarefa);
                System.out.printf("Tarefa com id %d apagada.", tarefa.getId());
                break;
            }
        }
        System.out.println("A tarefa não existe.");
    }
}
