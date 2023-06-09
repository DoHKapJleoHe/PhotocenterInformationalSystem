import React from "react";
import PhoneInput from 'react-phone-number-input/input'
import axios from "axios";

const PROVIDER = 'http://localhost:8080/providers';

class NewProvider extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            name: "",
            addr: "",
            number: 0
        }
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.name + " " + this.state.addr + " " + this.state.number)
        axios.post(PROVIDER, {
            name: this.state.name,
            address: this.state.addr,
            phoneNumber: this.state.number
        }).then(r => console.log("Request send successfully"))
    }

    render() {
        return <div>
            <input placeholder={"Название"}
                   className={"name"}
                   name={"name"}
                   value={this.state.name}
                   onChange={this.handleChange}
            />
            <input placeholder={"Адрес"}
                   className={"addr"}
                   name={"addr"}
                   value={this.state.addr}
                   onChange={this.handleChange}
            />

            <PhoneInput country={"RU"}
                        placeholder={"Номер телефона"}
                        className={"number"}
                        limitMaxLength={true}
                        maxLength={17}
                        value={this.state.number}
                        onChange={input => this.setState({number: input})}
            />

            <button className={"add1"} onClick={() => this.handleClick()}> Добавить! </button>
        </div>
    }
}

export default NewProvider