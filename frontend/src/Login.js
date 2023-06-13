import React from "react";
import axios from "axios";

const LOGIN = 'http://localhost:8080/login'


class Login extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: ""
        }
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.username+" "+this.state.password)

        axios.post(LOGIN, {
            username: this.state.username,
            password: this.state.password
        }).then()
    }


    render() {
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
            <button onClick={() => this.handleClick()}>Войти!</button>
        </div>
    }
}

export default Login;