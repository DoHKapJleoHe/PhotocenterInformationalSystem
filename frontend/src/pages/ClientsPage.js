import React from "react";
import axios from "axios";

const CLIENTS = 'http://localhost:8080/clients';


class ClientsPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            clientData: [],
            printingData: [],
            filmingData: []
        }
    }

    componentDidMount() {
        axios.get(CLIENTS).then(response => {
            this.setState({clientData: response.data})
        }).catch(error => {
            console.error(error)
        })
    }

    render() {
        return <div>
            <h2>Клиенты</h2>
            <div className={"table-container"}>
                <table className={"table"}>
                    <thead className={"thead"}>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Тип</th>
                    <th>Скидочная карта</th>
                    </thead>
                    <tbody>
                    {this.state.clientData.map(client => (
                        <tr key={client.id}>
                            <td>{client.id}</td>
                            <td>{client.name}</td>
                            <td>{client.surname}</td>
                            <td>{client.type}</td>
                            <td>{client.discountCard}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className={"table-container1"}>
                <table className={"sub-table1"}>
                    <thead className={"sub-thead"}>
                    <th>ID</th>
                    <th>Кол-во фото</th>
                    <th>Кол-во фото с кадра</th>
                    <th>Формат</th>
                    <th>Тип бумаги</th>
                    <th>Срочность</th>
                    <th>Цена</th>
                    <th>Дата</th>
                    </thead>
                    <tbody>
                    {this.state.printingData.map(order => (
                        <tr key={order.id}>
                            <td>{order.id}</td>
                            <td>{order.numPhotos}</td>
                            <td>{order.numPhotosPerFrame}</td>
                            <td>{order.format}</td>
                            <td>{order.paperType}</td>
                            <td>{order.urgency}</td>
                            <td>{order.price}</td>
                            <td>{order.date}</td>
                            <td>{order.clientName}</td>
                            <td>{order.clientId}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className={"table-container2"}>
                <table className={"sub-table2"}>
                    <thead className={"sub-thead"}>
                    <th>ID</th>
                    <th>Цена</th>
                    <th>Срочность</th>
                    <th>Дата</th>
                    <th>Имя клиента</th>
                    <th>ID клиента</th>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    }
}

export default ClientsPage