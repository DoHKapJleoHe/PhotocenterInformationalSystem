import React from "react";
import {Route, Routes, Link} from "react-router-dom";

import Header from "./components/Header";
import Input from "./components/Input";
import FilialsPage from "./pages/FilialsPage"

class App extends React.Component
{
    render() {
        return(
            <div>
                <Header/>
                <Link to={"/filials"}>
                    <button></button>
                </Link>
                <Routes>
                    // Here in "path" we specify address in browser without name of the site.
                    <Route path={"/filials"} element={<FilialsPage/>}/>
                </Routes>
            </div>)
    }
}

export default App