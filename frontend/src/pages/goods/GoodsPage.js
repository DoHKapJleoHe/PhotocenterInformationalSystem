import React from "react";
import axios from "axios";
import {Link} from "react-router-dom";

class GoodsPage extends React.Component
{
    render()
    {
        return <div>
            <Link to={"/new-resource"} className={"link"}> Добавить </Link>
        </div>
    }
}

export default GoodsPage