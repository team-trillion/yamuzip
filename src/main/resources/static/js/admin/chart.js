    // --- 방문자 통계
    const ctx = document.getElementById('visitChart').getContext('2d');
    const chart = new Chart(ctx, {
    // 차트 종류
    type: 'line',

    // 차트 데이터
    data: {
    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
    datasets: [{
    label: '요일별 방문자 차트',
    backgroundColor: 'transparent',
    borderColor: '#25BDDE',
    data: [0, 10, 5, 2, 20, 30, 45]
}]
},
    // 옵션
    options: {}
});
    // --- 회원 현황
    const ctx2 = document.getElementById('userChart').getContext('2d');
    const chart2 = new Chart(ctx2, {
    type: 'bar',

    data: {
    labels: ['일반', '도비', '대기', '정지', '탈퇴'],
    datasets: [{
    axis: 'y',
    label: '회원현황',
    data: [65, 59, 80, 81, 56],
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
    indexAxis: 'y'
}
});

    // --- 정산 현황
    const ctx3 = document.getElementById('calChart').getContext('2d');
    const chart3 = new Chart(ctx3, {
    type: 'doughnut',
    data: {
    labels: [
    '정산 완료',
    '정산 미완료',
    '정산 취소'
    ],
    datasets: [{
    label: '이번달 정산 현황',
    data: [50, 100, 70],
    backgroundColor: [
    'rgb(25,211,231)',
    'rgb(106,180,252)',
    'rgb(113,138,231)'
    ],
    hoverOffset: 4
}]
}
});