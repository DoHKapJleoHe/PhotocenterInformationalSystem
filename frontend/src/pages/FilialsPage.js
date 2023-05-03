import React from "react";
import axios from "axios";
import Input from "../components/Input";

const FILIALS = 'http://localhost:8080/filials';
const KIOSKS = 'http://localhost:8080/kiosks/kf';

class FilialsPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            filialData: [],
            kioskData: []
        }
    }

    componentDidMount() {
        axios.get(FILIALS).then(response => {
            console.log(response.data);
            this.setState({filialData: response.data});
        }).catch(error => {
                console.error(error);
            });
    }

    onRowClick(id)
    {
        let path = KIOSKS+'/'+id;
        axios.get(path).then(response => {
            console.log(response.data);
            this.setState({kioskData: response.data});
        }).catch(error => {
            console.error(error);
        });
    }

    render() {
        return(
            <div>
                <h2>Филиалы</h2>
                <div className={"table-container"}>
                    <table className={"table"}>
                        <thead className={"thead"}>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>Workplaces</th>
                        </thead>
                        <tbody>
                        {this.state.filialData.map(filial => (
                            <tr key={filial.id} onClick={() => this.onRowClick(filial.id)}>
                                <td>{filial.id}</td>
                                <td>{filial.name}</td>
                                <td>{filial.city}</td>
                                <td>{filial.street}</td>
                                <td>{filial.workplaces}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                    <Input/>
                    <table className={"kiosk-table"}>
                        <thead className={"kiosk-thead"}>
                        <th>ID</th>
                        <th>Number</th>
                        <th>Workplaces</th>
                        <th>FilialID</th>
                        </thead>
                        <tbody>
                        {this.state.kioskData.map(kiosk => (
                            <tr key={kiosk.id}>
                                <td>{kiosk.id}</td>
                                <td>{kiosk.number}</td>
                                <td>{kiosk.workplaces}</td>
                                <td>{kiosk.filialId}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default FilialsPage