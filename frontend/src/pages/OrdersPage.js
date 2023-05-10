import React, {useState} from "react";
import axios from "axios";

const PRINT = 'http://localhost:8080/printing-orders';
const FILM = 'http://localhost:8080/filming-orders';

class OrdersPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            dateFrom: "",
            dateTo: "",
            printingData: [],
            filmingData: []
        }
    }

    filterData()
    {
        axios.get(PRINT+'/'+'time', {
            params:{
                dateFrom: this.state.dateFrom,
                dateTo: this.state.dateTo
            }
        }).then(response => {
            this.setState({printingData: response.data})
        })
    }

    handleDate = (event) => {
        const {target} = event;
        const {name, value} = target;

        this.setState({
            [name]: value
        });
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

            <button className={"filter-button"} onClick={() => this.filterData()}>Find</button>
            <input placeholder={"Дата-От"} className={"date-from"} name={"dateFrom"} value={this.state.dateFrom} onChange={this.handleDate}></input>
            <input placeholder={"Дата-до"} className={"date-to"} name={"dateTo"} value={this.state.dateTo} onChange={this.handleDate}></input>
        </div>

    }
}

export default OrdersPage