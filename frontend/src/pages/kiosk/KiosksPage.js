import React from "react";
import axios from "axios";
import {Route, Routes, Link} from "react-router-dom";

const KIOSKS = 'http://localhost:8080/kiosks';

class KiosksPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            kioskData: []
        }
    }

    componentDidMount()
    {
        axios.get(KIOSKS).then(response => {
            console.log(response.data);
            this.setState({kioskData: response.data});
        }).catch(error => {
            console.error(error);
        });
    }

    render() {
        return(<div>
                <Link to={"/new-kiosk"} className={"link"}>Добавить киоск</Link>

                <h2>Киоски</h2>
                <div className={"table-container"}>
                    <table className={"table"}>
                        <thead className={"thead"}>
                        <th>ID</th>
                        <th>Номер</th>
                        <th>Раб. места</th>
                        <th>ID филиала</th>
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
                <></>
            </div>
        )
    }
}

export default KiosksPage