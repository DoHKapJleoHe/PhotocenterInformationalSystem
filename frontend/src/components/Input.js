import React, { useState } from 'react';

const USERS = "http://localhost:8080/filials";

let Input = (props, state) => {
        const [text, setText] = useState('');

        const handleClick = () => {
            alert(text);
        }

        const handleChange = (event) => {
            setText(event.target.value);
        }

        return (
            <div>
                <input className={"input"} placeholder={"Table name"} onChange={handleChange}/>
                <button className={"button"} onClick={handleClick}> Search! </button>
            </div>
        )
    }

export default Input