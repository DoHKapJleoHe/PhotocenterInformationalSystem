import React, { useState } from 'react';
import {Link} from "react-router-dom";

const USERS = "http://localhost:8080/filials";

let Input = (props, state) => {
        const [text, setText] = useState('');

        const handleClick = () => {

        }

        const handleChange = (event) => {
            setText(event.target.value);
        }

        return (
            <div>
                <input className={"input"} placeholder={"Table name"} onChange={handleChange}/>
                <Link to={"/search"}>
                    <button className={"button"} onClick={handleClick}> Search! </button>
                </Link>
            </div>
        )
    }

export default Input