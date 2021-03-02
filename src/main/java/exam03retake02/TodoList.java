package exam03retake02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TodoList {

  List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public int getNumberOfItemsLeft() {
        int count = 0;
        for (Todo todo : todos) {
            if (todo.getState() == State.NON_COMPLETED) {
                count++;
            }
        }
        return count;
    }


    public List<String> getMostImportantTodosText() {

        List<Todo> sortedTodos = new ArrayList<>(todos);

        Collections.sort(sortedTodos);
        int mostImportantIndex = sortedTodos.get(0).getPriority();


        List<String> mostImpTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getPriority() == mostImportantIndex) {
                mostImpTodos.add(todo.getText());
            }
        }
        return mostImpTodos;
    }


    public void deleteCompleted() {
        Iterator<Todo> todoIterator = todos.iterator();
        while (todoIterator.hasNext()) {
            Todo focused = todoIterator.next();
            if (focused.getState().equals(State.COMPLETED)) {
                todoIterator.remove();
            }
        }
    }




    public void addTodo (Todo todo) {
        todos.add(todo);
    }
}
