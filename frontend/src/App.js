import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import FilialsPage from "./pages/FilialsPage"

class App extends React.Component
{
    render() {
        return(
            <div>
                <Header/>
                <p>
                    <Link to={"/filials"} className={"link"}>Филиалы</Link>
                    <Link to={"/kiosks"} className={"link"}>Киоски</Link>
                </p>

                <Routes>
                    <Route exact path={"/filials"} element={<FilialsPage/>}/>
                </Routes>
            </div>)
    }
}

export default App