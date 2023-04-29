import React, { useState } from 'react';
import axios from "axios";

const FILIALS = 'http://localhost:8080/filials';

let Input = (props, state) => {
        const [data, setData] = useState({
            name: "",
            city: "",
            street: "",
            workplaces: ""
        });

        const handleClick = () => {
            axios.post(FILIALS, {
                name: data.name,
                city: data.city,
                street: data.street,
                workplaces: data.workplaces
            }).then(r => console.log(r.data))
        }

        const handleChange = (event) => {
            setData({...data, [event.target.name]: event.target.value});
        }

        return (
            <div>
                <input className={"input"} placeholder={"Name"} name={"name"} value={data.name} onChange={handleChange}/>
                <input className={"input1"} placeholder={"City"} name={"city"} value={data.city} onChange={handleChange}/>
                <input className={"input2"} placeholder={"Street"} name={"street"} value={data.street} onChange={handleChange}/>
                <input className={"input3"} placeholder={"Workplaces"} name={"workplaces"} value={data.workplaces} onChange={handleChange}/>
                <button className={"button"} onClick={handleClick}> Add! </button>
            </div>
        )
    }

export default Input