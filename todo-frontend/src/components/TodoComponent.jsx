import React, { useEffect, useState } from "react";
import { createTodo, getTodoById, updateTodo } from "../Services/TodoService";
import { useNavigate, useParams } from "react-router-dom";

function TodoComponent() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const { id } = useParams();
  const navigator = useNavigate();

  const pageTitle = () => {
    if (id) return "Update Todo";
    else return "Add Todo";
  };
  const addTodoBtn = (e) => {
    e.preventDefault();

    const todo = {
      title: title,
      description: description,
    };

    if (id) updateTodo(id, todo);
    else createTodo(todo);

    navigator("/");
  };

  useEffect(() => {
    if (id) {
      getTodoById(id).then((response) => {
        setTitle(response.data.title);
        setDescription(response.data.description);
      });
    }
  }, []);
  return (
    <div className="container col-md-4">
      <h2 className="text-center">{pageTitle()}</h2>
      <br />
      <form className="col-md-11">
        <div className="form-group">
          <label htmlFor="title">
            Todo Title <span style={{ color: "red" }}>*</span>
          </label>
          <input
            onChange={(e) => setTitle(e.target.value)}
            value={title}
            type="text"
            className="form-control"
            placeholder="(E.g: SpringBoot)"
          />
        </div>
        <br />
        <div className="form-group">
          <label htmlFor="title">
            Todo Description <span style={{ color: "red" }}>*</span>
          </label>
          <input
            onChange={(e) => setDescription(e.target.value)}
            value={description}
            type="text"
            className="form-control"
            placeholder="(E.g: Complete SpringBoot series from Udemy)"
          />
        </div>
        <br />
        <div className="form-group">
          <button
            onClick={addTodoBtn}
            className="form-control btn btn-success"
            type="submit"
          >
            {pageTitle()}
          </button>
        </div>
      </form>
    </div>
  );
}

export default TodoComponent;
