import React from "react";
import axios from "axios";
import Select from "react-select";

const PROVIDER = 'http://localhost:8080/providers';

class DeleteProviderPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            curProvider: 0,
            providers: []
        }
    }

    componentDidMount() {
        axios.get(PROVIDER).then(response => {

        })
    }

    handleClick()
    {
        let path = PROVIDER+'/'+this.state.curProvider;
        axios.delete(path).then()
    }

    render() {
        return <div>
            <Select
                className={"select"}
                placeholder={"Киоск"}
                value={this.state.curProvider.value}
                onChange={selectedOption => this.setState({curProvider: selectedOption.value})}
                options={this.state.providers}
            />

            <button className={"deleteButton"} onClick={() => this.handleClick()}>Удалить</button>
        </div>
    }
}

export default DeleteProviderPage;