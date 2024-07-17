package net.lakhwan.todo.service;

import net.lakhwan.todo.entity.Todo;
import net.lakhwan.todo.dto.TodoDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodoById(Long todoId);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long todoId, TodoDto updatedTodoDto);

    void deleteTodo(Long todoId);

    TodoDto completeTodo(Long todoId);

    TodoDto inCompleteTodo(Long todoId);
}
