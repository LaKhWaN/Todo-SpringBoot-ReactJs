package net.lakhwan.todo.service.impl;

import lombok.AllArgsConstructor;
import net.lakhwan.todo.dto.TodoDto;
import net.lakhwan.todo.entity.Todo;
import net.lakhwan.todo.exceptions.ResourceNotFoundException;
import net.lakhwan.todo.repository.TodoRepository;
import net.lakhwan.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return  savedTodoDto;
    }

    @Override
    public TodoDto getTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No todo exists with the given id: " + todoId));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAll();
        List <TodoDto> allTodosDto = allTodos.stream().map((todo -> modelMapper.map(todo, TodoDto.class))).collect(Collectors.toList());
        return allTodosDto;
    }

    @Override
    public TodoDto updateTodo(Long todoId, TodoDto updatedTodoDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No todo exists with the given id: " + todoId));

        todo.setTitle(updatedTodoDto.getTitle());
        todo.setDescription(updatedTodoDto.getDescription());
        todo.setCompleted(updatedTodoDto.isCompleted());

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No todo exists with the given id: " + todoId));

        todoRepository.deleteById(todoId);
    }

    @Override
    public TodoDto completeTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No todo exists with the given id: " + todoId));

        todo.setCompleted(true);

        TodoDto updatedTodoDto = updateTodo(todoId, modelMapper.map(todo, TodoDto.class));

        return updatedTodoDto;
    }

    @Override
    public TodoDto inCompleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No todo exists with the given id: " + todoId));

        todo.setCompleted(false);

        TodoDto updatedTodoDto = updateTodo(todoId, modelMapper.map(todo, TodoDto.class));

        return updatedTodoDto;
    }
}
