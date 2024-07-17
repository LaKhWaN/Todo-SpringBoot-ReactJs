import axios from "axios";

const REST_BASE_URL = "http://localhost:8080/api/todos";

export const getAllTodos = () => axios.get(REST_BASE_URL);

export const getTodoById = (todoId) => axios.get(REST_BASE_URL + "/" + todoId);

export const createTodo = (todo) => axios.post(REST_BASE_URL, todo);

export const updateTodo = (todoId, todo) =>
  axios.put(REST_BASE_URL + "/" + todoId, todo);

export const deleteTodo = (todoId) =>
  axios.delete(REST_BASE_URL + "/" + todoId);

export const completeTodo = (todoId) =>
  axios.patch(REST_BASE_URL + "/complete/" + todoId);

export const inCompleteTodo = (todoId) =>
  axios.patch(REST_BASE_URL + "/incomplete/" + todoId);
