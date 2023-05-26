import React from "react";
import axios from "axios";
import {resolvePath} from "react-router-dom";
import Select from "react-select";

const FILIALS = 'http://localhost:8080/filials';
const KIOSKS = 'http://localhost:8080/kiosks';

class NewKioskPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            number: 0,
            filials:[],
            curFilial: ""
        }
    }

    componentDidMount() {
        axios.get(FILIALS).then(response => {
            const filials = response.data.map(filial => ({
                value: filial.name,
                label: filial.name
            }))

            this.setState({filials})
        })
    }

    addKiosk()
    {
        axios.post(KIOSKS, {
            number: this.state.number,
        }).then()
    }

    render() {
        return <div>
            <input
                className={"inputNumber"}
                placeholder={"Номер киоска"}
            />
            <input
                className={"inputWorkplaces"}
                placeholder={"Число рабочих мест"}
            />
            <Select
                className={"select"}
                placeholder={"Филиал"}
                value={this.state.curFilial.value}
                onChange={selectedOption => this.setState({curFilial: selectedOption.value})}
                options={this.state.filials}
            />
            <button
                className={"addButton"}
                placeholder={"Добавить"}
            />
        </div>
    }
}

export default NewKioskPage;