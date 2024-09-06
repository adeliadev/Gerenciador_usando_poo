import java.util.ArrayList;
import java.util.InputMismatchException;
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
        String descricao = sc.nextLine().trim();

        if (descricao.isEmpty()){
            System.out.println("ERRO: a descrição da tarefa não pode ficar vazia!");
            return;
        }

        tarefa.setDescricao(descricao);
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
        try {
            boolean tarefaEncontrada = false;

            for (Tarefas tarefa : listaDeTarefas) {
                if (tarefa.getId() == id) {
                    tarefa.setStatus("Concluída");
                    System.out.printf("Tarefa %d marcada como concluída%n", tarefa.getId());
                    tarefaEncontrada = true;
                    break;
                }
            }
            verificarTarefaEncontrada(tarefaEncontrada);

        } catch (TarefaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluirTarefa(int id) {
        try {
            boolean tarefaEncontrada = false;
            for (Tarefas tarefa : listaDeTarefas) {
                if (tarefa.getId() == id) {
                    listaDeTarefas.remove(tarefa);
                    System.out.printf("Tarefa com id %d apagada.", tarefa.getId());
                    tarefaEncontrada = true;
                    break;
                }
            }
            verificarTarefaEncontrada(tarefaEncontrada);

        } catch (TarefaNaoEncontradaException e) {
            System.out.print(e.getMessage());
        }
    }

    private void verificarTarefaEncontrada(boolean tarefaEncontrada) throws TarefaNaoEncontradaException {
        if (!tarefaEncontrada) {
            throw new TarefaNaoEncontradaException("A tarefa não foi encontrada!");

        }
    }
}
