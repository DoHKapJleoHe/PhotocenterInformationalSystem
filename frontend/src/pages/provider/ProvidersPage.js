import React from "react";
import axios from "axios";
import {Link} from "react-router-dom";

const PROVIDER = 'http://localhost:8080/providers';

class ProvidersPage extends React.Component
{
   constructor(props)
   {
       super(props);
       this.state={
           providersData:[]
       }
   }

   componentDidMount()
   {
        axios.get(PROVIDER).then(response => {
            console.log(response.data);
            this.setState({providersData: response.data})
        }).catch(error => {
            console.error(error)
        })
   }

   render()
   {
       return <div>
           <Link to={"/new-provider"} className={"link"}>Добавить</Link>
           <Link to={"/update-provider"} className={"link"}>Обновить</Link>
           <Link to={"/delete-provider"} className={"link"}>Удалить</Link>
           <Link to={"/get-supply"} className={"link"}>Поставка</Link>

           <h2>Поставщики</h2>
           <div className={"table-container"}>
               <table className={"table"}>
                    <thead className={"thead"}>
                    <th>ID</th>
                    <th>Название</th>
                    <th>Адрес</th>
                    <th>Телефон</th>
                    </thead>
                    <tbody>
                    {this.state.providersData.map(provider => (
                        <tr key={provider.id}>
                            <td>{provider.id}</td>
                            <td>{provider.name}</td>
                            <td>{provider.address}</td>
                            <td>{provider.phoneNumber}</td>
                        </tr>
                    ))}
                    </tbody>
               </table>
           </div>
       </div>
   }
}

export default ProvidersPage