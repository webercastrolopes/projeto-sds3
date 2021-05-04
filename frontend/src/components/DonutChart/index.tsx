import Chart from 'react-apexcharts';


const DonutChart = () => {    /*semelhante a criação de função forma anonima 'expressao lambda'*/

const mockData = {
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
            options={{...options, labels: mockData.labels}}
            series={mockData.series}
            type="donut"
            height="240"
        />

    );
}

// shift+alt+f para identar código
//voltar em 1,29,55 seg video
//aqui 1,20,46 seg
export default DonutChart;