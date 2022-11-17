import React, { useEffect, useState } from "react";
import axios from "axios";

import Button from "../UI/Button";
import Card from "../UI/Card";

import classes from './AddUser.module.css';

const EditUser = props => {
    const [id, setId] = useState(props.userToEdit);
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [email, setEmail] = useState('');

    useEffect(()=>{
        axios.get(props.API_URL+"/userinfo/"+props.userToEdit).then((response) => {
            if (response.status === 200) {
                setFirstName(response.data.first_name);
                setLastName(response.data.last_name);
                setPhoneNumber(response.data.phone_number);
                setEmail(response.data.email);
            }
        }).catch((err) => {
            console.error("error: " + err);
        });
    },[props.userToEdit]);

    const updateUserHandler = async (event) => {
        event.preventDefault();

        await axios.put(props.API_URL+"/userinfo/"+id, {
            first_name: firstName,
            last_name: lastName,
            phone_number: phoneNumber,
            email: email
        }).then((response) => {

            props.updateUsers();
            props.setShouldShowAdd(true);
        }).catch((err) => {
            console.error("error: " + err);
        });
    }

    const handleCancel = () => {
        props.setShouldShowAdd(true);
    }

    const handleRemove = async () => {
        await axios.delete(props.API_URL+"/userinfo/"+id).then((response) => {
            props.updateUsers();
            props.setShouldShowAdd(true);
        }).catch((err) => {
            console.error("error: " + err);
        });
    }

    return(
        <Card className={classes.input}>
            <h3>Edit User</h3>
            <form onSubmit={updateUserHandler}>
                <label htmlFor="firstName">First Name</label>
                <input id="firstName" type="text" value={firstName} onChange={event => { setFirstName(event.target.value)}}/>
                <label htmlFor="lastName">Last Name</label>
                <input id="lastName" type="text" value={lastName} onChange={event => { setLastName(event.target.value)}} />
                <label htmlFor="phoneNumber">Phone Number</label>
                <input id="phoneNumber" type="tel" value={phoneNumber} onChange={event => { setPhoneNumber(event.target.value)}}/>
                <label htmlFor="email">Email</label>
                <input id="email" type="email" value={email} onChange={event => { setEmail(event.target.value)}}/>
                <Button type="submit">Save</Button>
                <Button type="button" onClick={handleCancel} >Cancel</Button>
                <button type="button" onClick={handleRemove} >Remove</button>
            </form>
        </Card>
    );
}

export default EditUser;