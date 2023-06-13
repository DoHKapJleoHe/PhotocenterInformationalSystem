import React from "react";
import axios from "axios";
import Select from "react-select";

const PROVIDER = 'http://localhost:8080/providers';

const columns = [
    {value: "Название", label: "Название"},
    {value: "Адрес", label: "Адрес"},
    {value: "Номер телефона", label: "Номер телефона"}
]

class UpdateProviderPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            column: "",
            value: "",
            curProvider: 0,
            providers:[]
        }
    }

    componentDidMount() {
        axios.get(PROVIDER).then(response => {
            const providers = response.data.map(provider => ({
                value: provider.id,
                label: provider.name
            }))

            this.setState({providers})
        })
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.curFilial + " " + this.state.column + " " + this.state.value)
        let path = PROVIDER
        console.log(path)

        axios.put(path, {
            id: this.state.curProvider,
            column: this.state.column,
            value: this.state.value
        }, {
            headers: {
                'content-type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(() => console.log("request successfully send"))
    }

    render()
    {
        return <div>
            <Select
                className={"select"}
                placeholder={"Провайдер"}
                value={this.state.curProvider.value}
                onChange={selectedOption => this.setState({curProvider: selectedOption.value})}
                options={this.state.providers}
            />

            <Select
                className={"select"}
                placeholder={"Поле"}
                value={this.state.column.value}
                onChange={selectedOption => this.setState({column: selectedOption.value})}
                options={columns}
            />

            <input placeholder={"Значение"}
                   className={"value"}
                   name={"value"}
                   value={this.state.value}
                   onChange={this.handleChange}
            />

            <button className={"update"} onClick={() => this.handleClick()}> Обновить </button>
        </div>
    }
}

export default UpdateProviderPage;