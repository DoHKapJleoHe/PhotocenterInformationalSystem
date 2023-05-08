import React from "react";
import axios from "axios";

const PRINT = 'http://localhost:8080/printing_orders';
const FILM = 'http://localhost:8080/filming_orders';

class OrdersPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            printingData: [],
            filmingData: []
        }
    }

    componentDidMount() {
        axios.get(PRINT).then(order => {
            this.setState({printingData: order.data})
        }).catch(error => {
            console.error(error)
        })

        axios.get(FILM).then(order => {
            this.setState({filmingData: order.data})
        }).catch(error => {
            console.error(error)
        })
    }

    render() {
        return <div>
            <h2>Заказы</h2>
            <div className={"table-container"}>
                <table className={"table"}>
                    <thead className={"thead"}>
                    <th>ID</th>
                    <th>Кол-во фото</th>
                    <th>Кол-во фото с кадра</th>
                    <th>Формат</th>
                    <th>Тип бумаги</th>
                    <th>Срочность</th>
                    <th>Цена</th>
                    <th>Дата</th>
                    <th>Имя клиента</th>
                    <th>ID клиента</th>
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

            <div className={"table-container1"}>
                <table className={"sub-table1"}>
                    <thead className={"sub-thead"}>
                    <th>ID</th>
                    <th>Цена</th>
                    <th>Срочность</th>
                    <th>Дата</th>
                    <th>Имя клиента</th>
                    <th>ID клиента</th>
                    </thead>
                    <tbody>
                    {this.state.filmingData.map(order => (
                        <tr key={order.id}>
                            <td>{order.id}</td>
                            <td>{order.price}</td>
                            <td>{order.urgency}</td>
                            <td>{order.date}</td>
                            <td>{order.clientName}</td>
                            <td>{order.clientId}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    }
}

export default OrdersPage