import React from "react";
import axios from "axios";
import Select from "react-select";

const CLIENTS = 'http://localhost:8080/clients';

const columns = [
    {value:"Имя", label:"Имя"},
    {value:"Фамилия", label:"Фамилия"},
    {value:"Тип", label:"Тип"},
    {value:"Скидочная карта", label:"Скидочная карта"},
    {value:"Номер телефона", label:"Номер телефона"}
]

class UpdateClientPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            curClient: 0,
            column: "",
            value: "",
            clients: []
        }
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.curClient + " " + this.state.column + " " + this.state.value)
        axios.put(CLIENTS, {
            id: this.state.curClient,
            column: this.state.column,
            value: this.state.value
        }).then()
    }

    componentDidMount() {
        axios.get(CLIENTS).then(response => {
            const clients = response.data.map(client => ({
                value: client.id,
                label: client.name+" "+client.surname
            }))

            this.setState({clients})
        })
    }

    render() {
        return <div>
            <Select
                className={"select"}
                placeholder={"Клиент"}
                value={this.state.curClient.value}
                onChange={selectedOption => this.setState({curClient: selectedOption.value})}
                options={this.state.clients}
            />

            <Select
                className={"select"}
                placeholder={"Поле"}
                value={this.state.column.value}
                onChange={selectedOption => this.setState({column: selectedOption.value})}
                options={columns}
            />
            <input placeholder={"Новое значение"}
                   className={"value"}
                   name={"value"}
                   value={this.state.value}
                   onChange={this.handleChange}
            />
            <button className={"update"} onClick={() => this.handleClick()}>Обновить!</button>
        </div>
    }
}

export default UpdateClientPage;