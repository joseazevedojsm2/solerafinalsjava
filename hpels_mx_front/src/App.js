import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";

import AddUser from './components/User/AddUser';
import ListUser from './components/User/ListUser';
import EditUser from './components/User/EditUser';

function App() {
  const API_URL = "http://localhost:8080";

  const [refreshUsers, setRefreshUsers] = useState(null);
  const updateUsers = () => setRefreshUsers(new Date());

  const [shouldShowAdd, setShouldShowAdd] = useState(true);
  const [userToEdit, setUserToEdit] = useState(null);

  return (
    <div style={{width:"70%",marginLeft:"auto",marginRight:"auto",marginTop:"5vh"}}>
      {shouldShowAdd?
        <AddUser API_URL={API_URL} updateUsers={updateUsers} />
      :
        <EditUser API_URL={API_URL} updateUsers={updateUsers} userToEdit={userToEdit} />
      }

      <ListUser API_URL={API_URL} refreshUsers={refreshUsers} setUserToEdit={setUserToEdit} setShouldShowAdd={setShouldShowAdd} />
    </div>
  );
}

export default App;
