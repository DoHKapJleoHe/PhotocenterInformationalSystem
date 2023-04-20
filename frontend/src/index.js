import React from 'react';
import ReactDOMClient from 'react-dom/client';

const elements = (
    <div>
        <header>Photo center informational system</header>
        <h1>Hello!</h1>
        <input placeholder={"Table name"}/>
    </div>)

const app = ReactDOMClient.createRoot(document.getElementById("root"))
app.render(elements)