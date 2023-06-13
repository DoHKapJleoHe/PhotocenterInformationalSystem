import React from "react";
import axios from "axios";
import Select from "react-select";

const KIOSKS = 'http://localhost:8080/kiosks';

const columns = [
    {value: "Номер", label:"Номер"},
    {value: "Рабочие места", label:"Рабочие места"},
    {value: "Филиал", label:"Филиал"}
]

class UpdateKiosk extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            column: "",
            value: "",
            curKiosk: 0,
            kiosks: []
        }
    }

    handleClick()
    {
        console.log(this.state.curKiosk + " " + this.state.column + " " + this.state.value)
        let path = KIOSKS
        console.log(path)

        axios.put(path, {
            id: this.state.curKiosk,
            column: this.state.column,
            value: this.state.value
        }, {
            headers: {
                'content-type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(() => console.log("request successfully send"))
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    componentDidMount()
    {
        axios.get(KIOSKS).then(response => {
            console.log(response.data);
            const kiosks = response.data.map(kiosk => ({
                value: kiosk.id,
                label: kiosk.number
            }))
            this.setState({kiosks});
        }).catch(error => {
            console.error(error);
        });
    }

    render()
    {
        return <div>
            <Select
                className={"select"}
                placeholder={"Киоск"}
                value={this.state.curKiosk.value}
                onChange={selectedOption => this.setState({curKiosk: selectedOption.value})}
                options={this.state.kiosks}
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

export default UpdateKiosk