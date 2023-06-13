import React from "react";
import axios from "axios";
import Select from "react-select";

const FILIALS = 'http://localhost:8080/filials';

class DeleteFilial extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            curFilial: 0,
            filials: []
        }
    }

    handleClick()
    {
        let path = FILIALS+'/'+this.state.curFilial;
        axios.delete(path).then()
    }

    componentDidMount()
    {
        axios.get(FILIALS).then(response => {
            console.log(response.data);
            const filials = response.data.map(filial => ({
                value: filial.id,
                label: filial.name
            }))
            this.setState({filials});
        }).catch(error => {
            console.error(error);
        });
    }

    render()
    {
        return <div>
            <Select
                className={"select"}
                placeholder={"Филиал"}
                value={this.state.curFilial.value}
                onChange={selectedOption => this.setState({curFilial: selectedOption.value})}
                options={this.state.filials}
            />

            <button className={"deleteButton"} onClick={() => this.handleClick()}>Удалить</button>
        </div>
    }
}

export default DeleteFilial;