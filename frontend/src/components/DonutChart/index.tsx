import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sales';
import { BASE_URL } from 'utils/request';


type ChartData = {
    labels: string[];
    series: number [];
}

const DonutChart = () => {    /* Componente - semelhante a criação de função forma anonima 'expressao lambda'*/

//forma errada  - depois vamos fazer com huks pra ficar 'bonitao' e corrigir esse erro.
let chartData : ChartData = {labels: [], series: []};

//forma errada
axios.get(`${BASE_URL}/sales/amount-by-seller`)  // requisicao assincrona - tela continua rodando mesmo com retorno da API
    .then((response) => {
        const data = response.data as SaleSum[]  // fiz este casting pra acessar cada um dos obj dele com meu pam
        const myLabels = data.map(x => x.sellerName);
        const mySeries = data.map(x => x.sum);

        chartData = {labels :myLabels, series: mySeries};

        console.log(chartData)  //.data é o corpo da msg da pra inspecionar no browser

    });  // vai executar qdo a resposta chegar com sucesso


/*
//forma errada  - depois vamos fazer com huks pra ficar 'bonitao' e corrigir esse erro.
let chartData : ChartData = {labels: [], series: []};

//forma errada
axios.get(`${BASE_URL}/sales/amount-by-seller`)  // requisicao assincrona - tela continua rodando mesmo com retorno da API
    .then((response) => {
        console.log(response.data)  //.data é o corpo da msg da pra inspecionar no browser

    });  // vai executar qdo a resposta chegar com sucesso
*/


const mockData = {   // pra ver o erro nao vamos uar o mockData la no return - observer resultado no browser - const é dado que nao muda , let muda.
    series: [477138, 499928, 444867, 220426, 473088],
    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
}

const options = {
    legend: {
        show: true
    }
}

    return (
        <Chart
        options={{...options, labels: chartData.labels}}
        series={chartData.series}
            //options={{...options, labels: mockData.labels}}
            //series={mockData.series}
            type="donut"
            height="240"
        />

    );
}

// shift+alt+f para identar código
//voltar em 1,29,55 seg video
//aqui 1,20,46 seg
export default DonutChart;