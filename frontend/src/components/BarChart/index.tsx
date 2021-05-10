import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess, SaleSum } from 'types/sales';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/request';


type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    }
    series: SeriesData[];
    }


const BarChart = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/


    const [chartData, setChartData] = useState<ChartData>({
       
            labels: {
                categories: []
            },
            series: [
                {
                    name: "",
                    data: []                   
                }
            ]
        });

    
        useEffect(() => {

            axios.get(`${BASE_URL}/sales/amount-by-seller`)  // requisicao assincrona - tela continua rodando mesmo com retorno da API
            .then((response) => {
                const data = response.data as SaleSuccess[]  // fiz este casting pra acessar cada um dos obj dele com meu pam
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => round(100.0 * x.deals / x.visited, 1));
        
                setChartData({
                    
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Sucess",
                            data: mySeries                   
                        }
                    ]
                });
                    
                    //labels :myLabels, series: mySeries});
                //chartData = {labels :myLabels, series: mySeries}; // entao agora vou chamar o setChartData
        
                // console.log(chartData)  //.data é o corpo da msg da pra inspecionar no browser
            });  // vai executar qdo a resposta chegar com sucesso
        }, [] ); //funcaoo lambida, lista de objetos que o useFfect vai observar ou seja qdo mudar o valor vai exec novamente, a principio vamos deixar vazio [].
        
    
        


const options = {
    plotOptions: {
        bar: {
            horizontal: true,
        }
    },
};

const mockData = {
    labels: {
        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
        {
            name: "% Sucesso",
            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
        }
    ]
};
    return (
        <Chart
            //options={{...options, xaxis: mockData.labels}}
              options={{...options, xaxis: chartData.labels}}
            //series={mockData.series}
              series={chartData.series}
            type="bar"
            height="240"
        />

    );
}

// shift+alt+f para identar código
//voltar em 1,29,55 seg video
//aqui 1,20,46 seg
export default BarChart;