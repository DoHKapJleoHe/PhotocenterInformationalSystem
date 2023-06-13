import React from "react";
import axios from "axios";

const REG = 'http://localhost:8080/registration'

class Registration extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        }
    }


    handleClick()
    {
        console.log(this.state.username+" "+this.state.password)

        /*axios.post(REG, {
            username: this.state.username,
            password: this.state.password
        }).then()*/
    }

    render()
    {
        return <div>
            <input placeholder={"username"}
                   name={"username"}
                   value={this.state.username}
                   onChange={this.handleChange}
            />
            <input placeholder={"password"}
                   name={"password"}
                   value={this.state.password}
                   onChange={this.handleChange}
            />
            <button onClick={() => this.handleClick()}>Зарегистрироваться</button>
        </div>
    }
}

export default Registration;