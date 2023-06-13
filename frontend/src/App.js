import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import FilialsPage from "./pages/filial/FilialsPage"
import KiosksPage from "./pages/kiosk/KiosksPage";
import ClientsPage from "./pages/client/ClientsPage";
import OrdersPage from "./pages/order/OrdersPage";
import ProvidersPage from "./pages/provider/ProvidersPage";
import GoodsPage from "./pages/goods/GoodsPage";
import NewOrderPage from "./pages/order/NewOrderPage";
import NewKioskPage from "./pages/kiosk/NewKioskPage";
import NewFilialPage from "./pages/filial/NewFilialPage";
import UpdateFilialPage from "./pages/filial/UpdateFilialPage";
import NewProviderPage from "./pages/provider/NewProviderPage";
import NewSupply from "./pages/provider/NewSupply";
import NewResource from "./pages/goods/NewResource";
import UpdateClientPage from "./pages/client/UpdateClientPage";
import DeleteKiosk from "./pages/kiosk/DeleteKiosk";
import Registration from "./Registration";
import DeleteClientPage from "./pages/client/DeleteClientPage";
import DeleteFilial from "./pages/filial/DeleteFilial";
import UpdateKiosk from "./pages/kiosk/UpdateKiosk";
import DeleteProviderPage from "./pages/provider/DeleteProviderPage";
import Login from "./Login";
import UpdateProviderPage from "./pages/provider/UpdateProviderPage";


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
                    <Link to={"/registration"} className={"link"}>Регистрация</Link>
                    <Link to={"/login"} className={"link"}>Войти</Link>
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
                    <Route path={"/new-provider"} element={<NewProviderPage/>}></Route>
                    <Route path={"/get-supply"} element={<NewSupply/>}></Route>
                    <Route path={"/new-resource"} element={<NewResource/>}></Route>
                    <Route path={"/update-client"} element={<UpdateClientPage/>}></Route>
                    <Route path={"/delete-kiosk"} element={<DeleteKiosk/>}></Route>
                    <Route path={"/delete-client"} element={<DeleteClientPage/>}></Route>
                    <Route path={"/delete-filial"} element={<DeleteFilial/>}></Route>
                    <Route path={"/update-kiosk"} element={<UpdateKiosk/>}></Route>
                    <Route path={"/delete-provider"} element={<DeleteProviderPage/>}></Route>
                    <Route path={"/registration"} element={<Registration/>}></Route>
                    <Route path={"/login"} element={<Login/>}></Route>
                    <Route path={"/update-provider"} element={<UpdateProviderPage/>}></Route>
                </Routes>
            </div>)
    }
}

export default App
