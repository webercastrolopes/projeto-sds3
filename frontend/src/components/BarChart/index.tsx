import Chart from 'react-apexcharts';


const BarChart = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/

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
            options={{...options, xaxis: mockData.labels}}
            series={mockData.series}
            type="bar"
            height="240"
        />

    );
}

// shift+alt+f para identar código
//voltar em 1,29,55 seg video
//aqui 1,20,46 seg
export default BarChart;