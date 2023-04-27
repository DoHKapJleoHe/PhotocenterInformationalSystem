import React from "react";
import axios from "axios";

const FILIALS = 'http://localhost:8080/filials';

class FilialsPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            filialsData: []
        }
    }

    componentDidMount() {
        axios.get(FILIALS).then(response => {
            this.state({filialsData: response.data})
        })
    }

    render() {
        return(
            <div>
                <h2>Филиалы</h2>
                <table>
                    <thead>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>Workplaces</th>

                    </thead>
                    <tbody>
                    {this.state.filialsData.map(filial => (
                        <tr key={filial.id}>
                            <td>{filial.id}</td>
                            <td>{filial.name}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default FilialsPage