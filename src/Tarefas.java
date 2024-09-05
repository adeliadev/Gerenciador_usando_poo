import java.util.Scanner;

public class Tarefas {
    private int id;
    private String status;
    private String descricao;
    private static int contadorId = 1;

    // Construtor
    public Tarefas(){
        this.id = contadorId++;
        this.status = "Pendente";
    }

    // Getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Métodos da classe

    public void criarTarefa(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a descrição da tarefa: ");
        setDescricao(sc.nextLine());
    }

    public void marcarComoConcluido(){
        setStatus("Concluída");
    }


}
