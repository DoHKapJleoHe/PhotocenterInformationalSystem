import React from "react";
import axios from "axios";

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

   }

   render()
   {
       return <div>
           <h2>Поставщики</h2>
           <div className={"table-container"}>
               <table className={"table"}>
                    <thead className={"thead"}>
                    <th>ID</th>
                    <th>Название</th>
                    <th>Адрес</th>
                    <th>Телефон</th>
                    </thead>
               </table>
           </div>
       </div>
   }
}

export default ProvidersPage