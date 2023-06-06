import React from "react";
import axios from "axios";
import Select from "react-select";

const FILIALS = 'http://localhost:8080/filials';
const KIOSKS = 'http://localhost:8080/kiosks';

class NewKioskPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            number: 0,
            workplaces: 0,
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

    addKiosk()
    {
        console.log(this.state.number + " " + this.state.curFilial + " " + this.state.workplaces)

        axios.post(KIOSKS, {
            number: this.state.number,
            workplaces: this.state.workplaces,
            filialId: this.state.curFilial
        }).then()
    }

    render() {
        return <div>
            <input
                className={"inputNumber"}
                placeholder={"Номер киоска"}
                name={"number"}
                value={this.state.number}
                onChange={this.handleChange}
            />
            <input
                className={"inputWorkplaces"}
                placeholder={"Число рабочих мест"}
                name={"workplaces"}
                value={this.state.workplaces}
                onChange={this.handleChange}
            />
            <Select
                className={"select"}
                placeholder={"Филиал"}
                value={this.state.curFilial.value}
                onChange={selectedOption => this.setState({curFilial: selectedOption.value})}
                options={this.state.filials}
            />
            <button className={"addButton"} onClick={() => this.addKiosk()}>Add!</button>
        </div>
    }
}

export default NewKioskPage;