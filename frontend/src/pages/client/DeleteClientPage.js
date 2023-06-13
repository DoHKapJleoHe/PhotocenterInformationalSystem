import React from "react";
import axios from "axios";
import Select from "react-select";

const CLIENTS = 'http://localhost:8080/clients';

class DeleteClientPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            curClient: 0,
            clients: []
        }
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

    handleClick()
    {
        let path = CLIENTS+'/'+this.state.curClient;
        axios.delete(path).then()
    }

    render()
    {
        return <div>
            <Select
                className={"select"}
                placeholder={"Клиент"}
                value={this.state.curClient.value}
                onChange={selectedOption => this.setState({curClient: selectedOption.value})}
                options={this.state.clients}
            />

            <button className={"deleteButton"} onClick={() => this.handleClick()}>Удалить</button>
        </div>
    }
}

export default DeleteClientPage