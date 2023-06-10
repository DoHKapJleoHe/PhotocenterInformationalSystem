import React, {useState} from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
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
            filmingData: [],
            price_printing: 0,
            price_filming: 0
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
            this.setState({printingData: response.data}, () => {
                this.getFullPrice()
            })
        })

    }

    getFullPrice()
    {
        const resultP = this.state.printingData.reduce((sum, order) => sum += order.price, 0);
        const resultF = this.state.filmingData.reduce((sum, order) => sum += order.price, 0);
        this.setState({price_printing: resultP+resultF})
    }

    componentDidMount() {
        axios.get(PRINT).then(order => {
            this.setState({printingData: order.data}, () => {
                this.getFullPrice()
            })
        }).catch(error => {
            console.error(error)
        })

        axios.get(FILM).then(order => {
            this.setState({filmingData: order.data}, () => {
                this.getFullPrice()
            })
        }).catch(error => {
            console.error(error)
        })
    }

    render() {
        return <div>
            <h2>Заказы</h2>
            <div className={"table-container"}>
                <h2>Заказы на печать</h2>
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
                <h2>Заказы на проявку</h2>
                <table className={"sub-table1"}>
                    <thead className={"sub-thead"}>
                    <th>ID</th>
                    <th>Срочность</th>
                    <th>Цена</th>
                    <th>Дата</th>
                    <th>Имя клиента</th>
                    <th>ID клиента</th>
                    </thead>
                    <tbody>
                    {this.state.filmingData.map(order => (
                        <tr key={order.id}>
                            <td>{order.id}</td>
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

            <div>
                <text className={"price"}>Общая выручка: </text>
                <text className={"price-value"}>{this.state.price_printing}</text>
            </div>

            <button className={"filter-button"} onClick={() => this.filterData()}>Find</button>
            <DatePicker
                selected={this.state.dateFrom}
                onChange={date => this.setState({ dateFrom: date })}
                dateFormat="yyyy-MM-dd"
                className={"date-from"}
                showYearDropdown
                scrollableYearDropdown
                yearDropdownItemNumber={15}
                placeholderText="Выберите дату"
                popperPlacement="bottom-start"
                popperModifiers={{
                    preventOverflow: {
                        enabled: true
                    }
                }}
            />

            <DatePicker
                selected={this.state.dateTo}
                onChange={date => this.setState({ dateTo: date })}
                dateFormat="yyyy-MM-dd"
                className={"date-to"}
                showYearDropdown
                placement={"topRight"}
                scrollableYearDropdown
                yearDropdownItemNumber={15}
                placeholderText="Выберите дату"
                popperPlacement="bottom-start"
                popperModifiers={{
                    preventOverflow: {
                        enabled: true
                    }
                }}
            />
        </div>

    }
}

export default OrdersPage