import React from "react";
import Header from "./components/Header";
import Button from "./components/Button";

class App extends React.Component
{
    render() {
        return(
            <div>
                <Header/>
                <input placeholder={"Table name"} className={"input"}/>
                <Button/>
            </div>)
    }
}

export default App