import React, { useEffect, useState } from "react";
import {
  completeTodo,
  deleteTodo,
  getAllTodos,
  getTodoById,
  inCompleteTodo,
} from "../Services/TodoService";
import { useNavigate } from "react-router-dom";

function ListTodoComponent() {
  const [todos, setTodos] = useState([]);

  const navigator = useNavigate();
  const addTodoBtn = () => {
    navigator("/todo-add");
  };
  useEffect(() => {
    getAllTodos().then((response) => {
      setTodos(response.data);
    });
  }, [todos]);

  const updateBtnHandler = (todoId) => {
    navigator("/todo-update/" + todoId);
  };

  const deleteBtnHandler = (todoId) => {
    deleteTodo(todoId).then((response) => {
      alert(response.data);
    });
  };

  const completeBtnHandler = (todoId) => {
    getTodoById(todoId).then((response) => {
      if (response.data.completed) {
        inCompleteTodo(todoId);
      } else {
        completeTodo(todoId);
      }
    });
  };
  return (
    <div className="container">
      <h1 className="text-center">List All Todo</h1>
      <br />
      <button onClick={addTodoBtn} className="btn btn-primary">
        Add Todo
      </button>
      <br />
      <br />
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Todo Id</th>
            <th>Todo Title</th>
            <th>Todo Description</th>
            <th>Todo Completed</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.id}</td>
              <td>{todo.title}</td>
              <td>{todo.description}</td>
              <td>
                <span
                  className={
                    todo.completed
                      ? "disabled btn btn-success"
                      : "disabled btn btn-danger"
                  }
                >
                  {todo.completed ? "Yes" : "No"}
                </span>
              </td>
              <td>
                <button
                  onClick={() => completeBtnHandler(todo.id)}
                  className={
                    todo.completed ? "btn btn-warning" : "btn btn-success"
                  }
                >
                  {todo.completed ? "Incomplete" : "Complete"}
                </button>{" "}
                <button
                  onClick={() => updateBtnHandler(todo.id)}
                  className="btn btn-info"
                >
                  Update
                </button>{" "}
                <button
                  onClick={() => deleteBtnHandler(todo.id)}
                  className="btn btn-danger"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ListTodoComponent;
