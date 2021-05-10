import axios from "axios";
import { useEffect, useState } from "react";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/request";

const Datatable = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/


   const [page, setPage] = useState<SalePage>({
       first: true,
       last: true,
       number: 0,
       totalElements: 0,
       totalPages: 0,
   })


   useEffect(() => {
    axios.get(`${BASE_URL}/sales?page=0&size=20&sort=date,desc`)
    .then(response => {
        setPage(response.data); // pegou corpo da resposta  da API e jogou na tela

    });

    
   }, [])



    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(item => (
                      <tr key={item.id}>
                        <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                        <td>{item.seller.name}</td>
                        <td>{item.visited}</td>
                        <td>{item.deals}</td>
                        <td>{item.amount.toFixed(2)}</td>
                      </tr>
                    ))}                                                                               
                   
                </tbody>
            </table>
        </div>
    );
}

// shift+alt+f para identar código
export default Datatable;