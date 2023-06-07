import React from "react";
import axios from "axios";
import Select from "react-select";
import {CountryDropdown} from "react-country-region-selector";

const FILIALS = 'http://localhost:8080/filials';

const columns = [
    {value: "Название", label: "Название"},
    {value: "Город", label: "Город"},
    {value: "Улица", label: "Улица"},
    {value: "Рабочие места", label: "Рабочие места"}
]

class UpdateFilialPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            column: "",
            value: "",
            curFilial: 0,
            filials:[]
        }
    }

    componentDidMount() {
        axios.get(FILIALS).then(response => {
            const filials = response.data.map(filial => ({
                value: filial.id,
                label: filial.name
            }))

            this.setState({filials})
        })
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.curFilial + " " + this.state.column + " " + this.state.value)
        let path = FILIALS
        console.log(path)

        axios.put(path, {
            id: this.state.curFilial,
            column: this.state.column,
            value: this.state.value
        }, {
            headers: {
                'content-type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(r => console.log("request successfully send"))
    }

    render() {
        return <div>
            <Select
                className={"select"}
                placeholder={"Филиал"}
                value={this.state.curFilial.value}
                onChange={selectedOption => this.setState({curFilial: selectedOption.value})}
                options={this.state.filials}
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

            <button className={"update"} onClick={() => this.handleClick()}> Update </button>
        </div>
    }
}

export default UpdateFilialPage