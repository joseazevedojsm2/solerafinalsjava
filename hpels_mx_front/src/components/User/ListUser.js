import React, { useState, useEffect } from "react";
import axios from "axios";

import Button from "../UI/Button";
import Card from "../UI/Card";

import classes from './UsersList.module.css';   

const ListUser = props => {
    const [users, setUsers] = useState([]);

    useEffect(()=>{
        axios.get(props.API_URL+"/userinfo/all").then((response) => {
            if (response.status === 200) {
                setUsers(response.data);
            }
        }).catch((err) => {
            console.error("error: " + err);
        });
    },[props.refreshUsers]);

    const onUserClickHandler = (event) => {
        props.setUserToEdit(event.target.getAttribute("data-key"));
        props.setShouldShowAdd(false);
    };
    
    return(
        <>
            <h2>Users</h2>
            {users.map((user) => (
                <Card style={{cursor:"pointer"}} className={classes.users} customClickEvent={onUserClickHandler} dataKey={user.id} key={user.id}>
                    <div style={{pointerEvents:"none"}}><span>{user.first_name+" "+user.last_name}</span><br/>
                    <span>{user.email} - {user.phone_number}</span></div>
                </Card>
            ))}
        </>
    );
}

export default ListUser;