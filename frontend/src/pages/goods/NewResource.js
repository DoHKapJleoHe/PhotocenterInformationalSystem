import React from "react";
import axios from "axios";

const RESOURCE = 'http://localhost:8080/resources'

class NewResource extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            name: ""
        }
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.name)
        axios.post(RESOURCE, {
            name: this.state.name
        }).then()
    }

    render() {
        return <div>
            <input className={"resName"}
                   placeholder={"Название ресурса"}
                   name={"name"}
                   value={this.state.name}
                   onChange={this.handleChange}
            />
            <button className={"addRes"} onClick={() => this.handleClick()}> Добавить ресурс!</button>
        </div>
    }
}

export default NewResource