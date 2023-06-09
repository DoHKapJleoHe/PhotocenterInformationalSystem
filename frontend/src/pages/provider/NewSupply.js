import React from "react";
import axios from "axios";
import Select from "react-select";

const PROVIDER = 'http://localhost:8080/providers';
const KIOSKS = 'http://localhost:8080/kiosks';
const RESOURCES = 'http://localhost:8080/resources';

class NewSupply extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            curProvider: "",
            curKiosk: 0,
            supply: 0,
            amount: 0,
            providers: [],
            kiosks:[],
            resources: []
        }
    }

    handleChange = (event) => {
        this.setState({...this.state, [event.target.name]: event.target.value})
    }

    handleClick()
    {
        console.log(this.state.curProvider + " " + this.state.curKiosk + " " + this.state.supply + " " + this.state.amount)
        let path = PROVIDER+'/new-resource'
        axios.post(path, {
            kioskId: this.state.curKiosk,
            resourceId: this.state.supply,
            amount: this.state.amount
        }).then()
    }

    componentDidMount() {
        axios.get(PROVIDER).then(response => {
            const providers = response.data.map(provider => ({
                value:provider.id,
                label:provider.name
            }))

            this.setState({providers})
        })

        axios.get(KIOSKS).then(response => {
            const kiosks = response.data.map(kiosk => ({
                value:kiosk.id,
                label:kiosk.number
            }))
            this.setState({kiosks})
        })

        axios.get(RESOURCES).then(response => {
            const resources = response.data.map(res => ({
                value:res.id,
                label:res.name
            }))
            this.setState({resources})
        })
    }

    render() {
        return <div>
            <Select className={"select"}
                    placeholder={"Поставщик"}
                    value={this.state.curProvider.value}
                    onChange={selectedOption => this.setState({curProvider: selectedOption.value})}
                    options={this.state.providers}
            />

            <Select className={"select"}
                    placeholder={"Киоск"}
                    value={this.state.curKiosk.value}
                    onChange={selectedOption => this.setState({curKiosk: selectedOption.value})}
                    options={this.state.kiosks}
            />

            <Select className={"select"}
                    placeholder={"Товар"}
                    value={this.state.supply.value}
                    onChange={selectedOption => this.setState({supply: selectedOption.value})}
                    options={this.state.resources}
            />

            <input placeholder={"Количество"}
                   className={"supAmount"}
                   name={"amount"}
                   value={this.state.amount}
                   onChange={this.handleChange}
            />

            <button className={"getSupply"} onClick={() => this.handleClick()}> Заказать! </button>

        </div>
    }
}

export default NewSupply