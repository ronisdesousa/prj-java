package main.java.list.OperacoesBasicas;


import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasRemove = new ArrayList<>();
        for(Tarefa t: tarefaList)
        {
            if (t.getDescricao().equalsIgnoreCase(descricao))
            {
                tarefasRemove.add(t);
            }
        }
        this.tarefaList.removeAll(tarefasRemove);
    }
}
