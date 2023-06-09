import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import FilialsPage from "./pages/filial/FilialsPage"
import KiosksPage from "./pages/kiosk/KiosksPage";
import ClientsPage from "./pages/ClientsPage";
import OrdersPage from "./pages/order/OrdersPage";
import ProvidersPage from "./pages/provider/ProvidersPage";
import GoodsPage from "./pages/goods/GoodsPage";
import NewOrderPage from "./pages/order/NewOrderPage";
import NewKioskPage from "./pages/kiosk/NewKioskPage";
import NewFilialPage from "./pages/filial/NewFilialPage";
import UpdateFilialPage from "./pages/filial/UpdateFilialPage";
import NewProvider from "./pages/provider/NewProvider";
import NewSupply from "./pages/provider/NewSupply";
import NewResource from "./pages/goods/NewResource";

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
                    <Link to={"/new-order"} className={"link"}>Сделать заказ</Link>
                </p>

                <Routes>
                    <Route path={"/filials"} element={<FilialsPage/>}/>
                    <Route path={"/kiosks"} element={<KiosksPage/>}/>
                    <Route path={"/clients"} element={<ClientsPage/>}/>
                    <Route path={"/orders"} element={<OrdersPage/>}/>
                    <Route path={"/providers"} element={<ProvidersPage/>}/>
                    <Route path={"/goods"} element={<GoodsPage/>}></Route>
                    <Route path={"/new-order"} element={<NewOrderPage/>}></Route>
                    <Route path={"/new-kiosk"} element={<NewKioskPage/>}></Route>
                    <Route path={"/new-filial"} element={<NewFilialPage/>}></Route>
                    <Route path={"/update-filial"} element={<UpdateFilialPage/>}></Route>
                    <Route path={"/new-provider"} element={<NewProvider/>}></Route>
                    <Route path={"/get-supply"} element={<NewSupply/>}></Route>
                    <Route path={"/new-resource"} element={<NewResource/>}></Route>
                </Routes>
            </div>)
    }
}

export default App
