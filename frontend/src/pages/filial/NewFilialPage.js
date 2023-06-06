import React from "react";
import axios from "axios";

const FILIALS = 'http://localhost:8080/filials';

class NewFilialPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            name: "",
            city: "",
            street: "",
            workplaces: "",
        }
    }

    handleClick()
    {
        console.log(this.state.name + " " + this.state.city + " " + this.state.street + " " + this.state.workplaces + " ")
        axios.post(FILIALS, {
            name: this.state.name,
            city: this.state.city,
            street: this.state.street,
            workplaces: this.state.workplaces
        }).then(r => console.log(r.data))
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    render()
    {
        return <div>
            <h2>Добавить новый филиал</h2>
            <input placeholder={"Name"}
                   className={"name"}
                   name={"name"}
                   value={this.state.name}
                   onChange={this.handleChange}
            />
            <input placeholder={"City"}
                   className={"city"}
                   name={"city"}
                   value={this.state.city}
                   onChange={this.handleChange}
            />
            <input placeholder={"Street"}
                   className={"street"}
                   name={"street"}
                   value={this.state.street}
                   onChange={this.handleChange}
            />
            <input placeholder={"Workplaces"}
                   className={"workplaces"}
                   name={"workplaces"}
                   value={this.state.workplaces}
                   onChange={this.handleChange}
            />
            <button className={"add"} onClick={() => this.handleClick()}>Add!</button>
        </div>
    }
}

export default NewFilialPage;