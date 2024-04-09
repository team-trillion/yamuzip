const adminChartLabel1 = chartData1.map(data => data.registDateString)
const adminChartData1 = chartData1.map(data => data.userCount)
const adminChartLabel2 = chartData2.map(data => data.categoryName)
const adminChartData2 = chartData2.map(data => data.orderCount)
const adminChartLabel3 = chartData3.map(data => data.statusName)
const adminChartData3 = chartData3.map(data => data.statusCount)


// --- 가입자 통계
    const ctx = document.getElementById('registChart').getContext('2d');
    const chart = new Chart(ctx, {
    // 차트 종류
    type: 'line',

    // 차트 데이터
    data: {
    labels: adminChartLabel1,
    datasets: [{
    label: '최근 가입 회원 수',
    backgroundColor: 'transparent',
    borderColor: '#25BDDE',
    data: adminChartData1
}]
},
    // 옵션
        options:{
            scales: {
                yAxes: [{
                    ticks: {
                        stepSize: 0.5
                    }
                }]
            }
        }
});
    // --- 회원 현황
    const ctx2 = document.getElementById('orderChart').getContext('2d');
    const chart2 = new Chart(ctx2, {
    type: 'bar',

    data: {
    labels: adminChartLabel2,
    datasets: [{
    axis: 'y',
    label: '최근 한 달 주문현황',
    data: adminChartData2,
    fill: false,
    backgroundColor: [
    'rgb(70,105,214, 0.2)',
    'rgb(22,183,210,0.2)',
    'rgb(99,146,244, 0.2)',
    'rgb(22,129,206,0.2)',
    'rgb(23,86,183,0.2)',
    ],
    borderColor: [
    'rgb(70,105,214)',
    'rgb(22,183,210)',
    'rgb(99,146,244)',
    'rgb(22,129,206)',
    'rgb(23,86,183)',
    ],
    borderWidth: 1
}],
},
        options: {
            scales: {
                y: {
                    beginAtZero: true // Y축이 0부터 시작하도록 설정
                }
            }
        }
});

    // --- 정산 현황
    const ctx3 = document.getElementById('statusChart').getContext('2d');
    const chart3 = new Chart(ctx3, {
    type: 'doughnut',
    data: {
    labels: adminChartLabel3,
    datasets: [{
    label: '최근 한 달 주문상태',
    data: adminChartData3,
    backgroundColor: [
    'rgb(25,211,231)',
    'rgb(106,180,252)',
    'rgb(113,138,231)'
    ],
    hoverOffset: 4
}]
}
});