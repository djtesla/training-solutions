package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoList {

    private List<ToDo> todos = new ArrayList<>();


    public void addTodo(String caption) {
        todos.add(new ToDo(caption));
    }


    public void finishTodos(String todoName) {

        for (ToDo todo : todos) {

            if (todo.getCaption().equals(todoName)) {
                todo.finish();
            }

        }
    }

    public void finishAllTodos(List<String> todosToFinish) {

        for (String todoName : todosToFinish) {

                finishTodos(todoName);

            }
        }



    public List<String> todosToFinish() {
        List<String> todosToFinishArray = new ArrayList<>();

        for (ToDo todo : todos) {

            if (todo.isFinished() == false) {
                todosToFinishArray.add(todo.getCaption());
            }
        }
        return todosToFinishArray;

    }


    public int numberOfFinishedTodos() {
        int i = 0;

        for (ToDo todo : todos) {

            if (todo.isFinished() == true) {
                i++;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return todos.toString();
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.addTodo("Edzés");
        todoList.addTodo("Kelés");
        todoList.addTodo("Evés");
        todoList.addTodo("Ivás");
        todoList.addTodo("Edzés");

        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("Edzés", "Kelés"));

        System.out.println(todoList);
        System.out.println(todoList.todosToFinish());

    }

    }