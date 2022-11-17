import React, { useState } from "react";
import axios from "axios";

import Button from "../UI/Button";
import Card from "../UI/Card";

import classes from './AddUser.module.css';
import './User.css';

const AddUser = props => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [email, setEmail] = useState('');

    const addUserHandler = async (event) => {
        event.preventDefault();

        await axios.post(props.API_URL+"/userinfo/add", {
            first_name: firstName,
            last_name: lastName,
            phone_number: phoneNumber,
            email: email
        }).then((response) => {
            console.log(response);

            props.updateUsers();

            setFirstName('');
            setLastName('');
            setPhoneNumber('');
            setEmail('');
        }).catch((err) => {
            console.error("error: " + err);
        });
    }
    //className={classes.input}

    return(
        <React.Fragment> 
            <form class="form-style-5" onSubmit={addUserHandler}>
            <h3>Create User</h3>
                <label htmlFor="firstName">First Name</label>
                <input id="firstName" type="text" value={firstName} onChange={event => { setFirstName(event.target.value)}}/>
                <label htmlFor="lastName">Last Name</label>
                <input id="lastName" type="text" value={lastName} onChange={event => { setLastName(event.target.value)}} />
                <label htmlFor="phoneNumber">Phone Number</label>
                <input id="phoneNumber" type="tel" value={phoneNumber} onChange={event => { setPhoneNumber(event.target.value)}}/>
                <label htmlFor="email">Email</label>
                <input id="email" type="email" value={email} onChange={event => { setEmail(event.target.value)}}/>
                <Button type="submit">Add User</Button>
            </form>
        </React.Fragment>
    );
}

export default AddUser;