package net.lakhwan.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo_title", nullable = false)
    private String title;

    @Column(name = "todo_description", nullable = true)
    private String description;

    @Column(name = "todo_completed", nullable = false)
    private boolean completed;
}
