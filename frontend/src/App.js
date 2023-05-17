import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import FilialsPage from "./pages/FilialsPage"
import KiosksPage from "./pages/KiosksPage";
import ClientsPage from "./pages/ClientsPage";
import OrdersPage from "./pages/OrdersPage";
import ProvidersPage from "./pages/ProvidersPage";
import GoodsPage from "./pages/GoodsPage";

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
                    <Link to={"/providers"} className={"link"}>Поставщики</Link>
                    <Link to={"/goods"} className={"link"}>Товары</Link>
                </p>

                <Routes>
                    <Route path={"/filials"} element={<FilialsPage/>}/>
                    <Route path={"/kiosks"} element={<KiosksPage/>}/>
                    <Route path={"/clients"} element={<ClientsPage/>}/>
                    <Route path={"/orders"} element={<OrdersPage/>}/>
                    <Route path={"/providers"} element={<ProvidersPage/>}/>
                    <Route path={"/goods"} element={<GoodsPage/>}></Route>
                </Routes>
            </div>)
    }
}

export default App
