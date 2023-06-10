import React from 'react';
import ReactDOMClient from 'react-dom/client';
import {BrowserRouter} from "react-router-dom";
import App from "./App";

import './css/main.css'
import './css/Button.css'
import './css/Header.css'
import './css/Input.css'
import './css/Table.css'
import './css/Link.css'
import './css/OrdersFilter.css'
import './css/NewOrder.css'
import './css/NewKiosk.css'
import './css/NewFilial.css'
import './css/UpdateFilial.css'
import './css/NewProvider.css'
import './css/NewSupply.css'
import './css/NewResource.css'
import './css/ClientsFilter.css'

const app = ReactDOMClient.createRoot(document.getElementById("root"))
app.render(
    <BrowserRouter>
        <App/>
    </BrowserRouter>
)