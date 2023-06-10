import React from "react";
import axios from "axios";
import Select from "react-select";

const KIOSKS = 'http://localhost:8080/kiosks';

class DeleteKiosk extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            curKiosk: 0,
            kiosks: []
        }
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

    handleClick()
    {
        let path = KIOSKS+'/'+this.state.curKiosk;
        axios.delete(path).then()
    }

    render() {
        //Using style for button from NewKiosk.css, because i don't want to crete new .css just for one button
        return <div>
            <Select
                className={"select"}
                placeholder={"Киоск"}
                value={this.state.curKiosk.value}
                onChange={selectedOption => this.setState({curKiosk: selectedOption.value})}
                options={this.state.kiosks}
            />

            <button className={"deleteButton"} onClick={() => this.handleClick()}>Удалить</button>
        </div>
    }
}

export default DeleteKiosk