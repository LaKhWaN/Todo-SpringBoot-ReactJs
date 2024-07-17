package net.lakhwan.todo.controller;

import lombok.AllArgsConstructor;
import net.lakhwan.todo.dto.TodoDto;
import net.lakhwan.todo.service.TodoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.createTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodoById(todoId);

        return ResponseEntity.ok(todoDto);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> allTodos = todoService.getAllTodos();

        return ResponseEntity.ok(allTodos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodoById(@PathVariable("id") Long todoId,
                                                  @RequestBody TodoDto updatedTodoDto){
        TodoDto savedTodoDto = todoService.updateTodo(todoId, updatedTodoDto);
        return ResponseEntity.ok(savedTodoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("Todo deleted successfully with id: " + todoId);
    }

    @PatchMapping("/complete/{id}")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.completeTodo(todoId);

        return ResponseEntity.ok(todoDto);
    }

    @PatchMapping("/incomplete/{id}")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.inCompleteTodo(todoId);

        return ResponseEntity.ok(todoDto);
    }
}
