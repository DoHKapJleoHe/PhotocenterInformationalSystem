import React from "react";
import Select from 'react-select';
import axios from "axios";
import DatePicker from "react-datepicker";

const KIOSKS = 'http://localhost:8080/kiosks';

const urgency = [
    {value:"Срочно", label:"Срочно"},
    {value: "Не срочно", label: "Не срочно"}
]

const type = [
    {value:"Проявка", label:"Проявка"},
    {value:"Печать", label: "Печать"}
]

const nums = [
    {value: 1, label:"1"},
    {value: 2, label:"2"},
    {value: 3, label:"3"},
    {value: 4, label:"4"},
    {value: 5, label:"5"}
]

const format = [
    {value: "A3", label:"A3"},
    {value: "A4", label:"A4"},
    {value: "A5", label:"A5"},
]

const paperType = [
    {value: "Матовый", label:"Матовый"},
    {value: "Глянцевый", label:"Глянцевый"},
]

class NewOrderPage extends React.Component
{
    constructor(props) {
        super(props);
        this.state = {
            numPhotos: 1,
            numPhotosPerFrame: 1,
            urgency: "",
            type: "Печать",
            format: "",
            paperType: "",
            date: "",
            price: 0,
            newClient: false,
            kiosks: [],
            curKiosk: 0
        }
    }

    makeOrder()
    {
        /*
        - Здесь надо будет сделать запрос на бек.
        - Надо будет сделать проверку на то, новый ли это пользователь, чтобы создать его.
        - Также надо будет сделать проверку на тип заказ и сделать запрос на соответствующий контроллер.
        - Также нужно сделать, чтобы при загрузке страницы подкачивались киоски для отображения в списке
          возможных киосков.
        - При выборе киоска должна высвечиваться информация о его ресурсах: кол-во бумаги, краски, плёнки
        */
    }

    componentDidMount() {
        axios.get(KIOSKS).then(response => {
            const kiosks = response.data.map(kiosk => ({
                value:kiosk.number,
                label:kiosk.number
            }))
            this.setState({kiosks})
        })
    }

    render()
    {
        let c1, c2;

        if(this.state.newClient === false)
        {
            c2 = <div>
                <input className={"orderInput"} placeholder={"Номер телефона"}/>
                <input className={"orderInput"} placeholder={"Имя клиента"}/>
            </div>
        }
        else if(this.state.newClient === true)
        {
            c2 = <div>
                <input className={"orderInput"} placeholder={"Имя"}/>
                <input className={"orderInput"} placeholder={"Фамилия"}/>
                <input className={"orderInput"} placeholder={"Тип"}/>
                <input className={"orderInput"} placeholder={"Скидочная карта"}/>
                <input className={"orderInput"} placeholder={"Номер телефона"}/>
            </div>
        }

        if(this.state.type === "Печать")
        {
            c1 = <div>
                <Select
                    className={"select"}
                    placeholder={"Число фото"}
                    value={this.state.numPhotos.value}
                    onChange={selectedOption => this.setState({numPhotos: selectedOption.value})}
                    options={nums}
                />
                <Select
                    className={"select"}
                    placeholder={"Число фото c кадра"}
                    value={this.state.numPhotos.value}
                    onChange={selectedOption => this.setState({numPhotosPerFrame: selectedOption.value})}
                    options={nums}
                />
                <Select
                    className={"select"}
                    placeholder={"Формат"}
                    value={this.state.format.value}
                    onChange={selectedOption => this.setState({format: selectedOption.value})}
                    options={format}
                />
                <Select
                    className={"select"}
                    placeholder={"Тип бумаги"}
                    value={this.state.paperType.value}
                    onChange={selectedOption => this.setState({paperType: selectedOption.value})}
                    options={paperType}
                />
            </div>
        }
        else if(this.state.type === "Проявка")
        {
            c1 = <div></div>
        }

        return <div>
            <h2>Новый заказ</h2>
            <Select
                className={"select"}
                placeholder={"Киоск"}
                value={this.state.curKiosk.value}
                onChange={selectedOption => {
                    this.setState({curKiosk: selectedOption.value})}
                }
            />
            <Select
                className={"select"}
                placeholder={"Вид"}
                value={this.state.type.value}
                onChange={selectedOption => {
                    this.setState({type: selectedOption.value})}
                }
                options={type}
            />
            {c1}
            <Select
                className={"select"}
                placeholder={"Срочность"}
                value={this.state.urgency.value}
                onChange={selectedOption => this.setState({urgency: selectedOption.value})}
                options={urgency}
            />
            <DatePicker
                selected={this.state.date}
                onChange={date => this.setState({ date: date })}
                dateFormat="yyyy-MM-dd"
                className={"date"}
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
            <input className={"orderInput"} placeholder={"Цена"}></input>
            <label>
                <input
                    type={"checkbox"}
                    checked={this.state.newClient}
                    onChange={() => {
                        this.setState({newClient: !this.state.newClient})
                    }}
                />
                Новый клиент
            </label>
            {c2}
            <button className={"makeOrder"} onClick={() => this.makeOrder()}>Сделать заказ</button>

            <text className={"resource"}>Бумага</text>
            <text className={"resource1"}>Чернила</text>
            <text className={"resource2"}>Плёнка</text>

            <text className={"resource-value"}>0</text>
            <text className={"resource1-value"}>0</text>
            <text className={"resource2-value"}>0</text>
        </div>
    }
}

export default NewOrderPage