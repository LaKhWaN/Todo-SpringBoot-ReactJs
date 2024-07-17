import "./App.css";
import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ListTodoComponent from "./components/ListTodoComponent";
import Header from "./components/Header";
import Footer from "./components/Footer";
import TodoComponent from "./components/TodoComponent";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <br />
        <Routes>
          <Route path="/" element={<ListTodoComponent />} />
          <Route path="/todos" element={<ListTodoComponent />} />
          <Route path="/todo-add" element={<TodoComponent />} />
          <Route path="/todo-update/:id" element={<TodoComponent />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
