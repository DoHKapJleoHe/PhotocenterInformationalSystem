import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import FilialsPage from "./pages/FilialsPage"
import KiosksPage from "./pages/KiosksPage";
import ClientsPage from "./pages/ClientsPage";
import OrdersPage from "./pages/OrdersPage";

class App extends React.Component
{
    render() {
        return(
            <div>
                <Header/>
                <p>
                    <Link to={"/filials"} className={"link"}>Филиалы</Link>
                    <Link to={"/kiosks"} className={"link"}>Киоски</Link>
                    <Link to={"/clients"} className={"link"}>Клиенты</Link>
                    <Link to={"/orders"} className={"link"}>Заказы</Link>
                </p>

                <Routes>
                    <Route path={"/filials"} element={<FilialsPage/>}/>
                    <Route path={"/kiosks"} element={<KiosksPage/>}/>
                    <Route path={"/clients"} element={<ClientsPage/>}/>
                    <Route path={"/orders"} element={<OrdersPage/>}/>
                </Routes>
            </div>)
    }
}

export default App
