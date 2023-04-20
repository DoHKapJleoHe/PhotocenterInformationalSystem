import React from 'react';
import ReactDOMClient from 'react-dom/client';
import App from "./App";

import './css/main.css'
import './css/Button.css'
import './css/Header.css'
import './css/Input.css'

const app = ReactDOMClient.createRoot(document.getElementById("root"))
app.render(<App/>)