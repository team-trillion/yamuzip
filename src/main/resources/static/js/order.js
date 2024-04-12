const statusSelectEl = document.querySelector('.orderStatusSelect');
const textColors = [];
textColors['O'] = 'fw-bold fs-5 text-secondary align-middle';
textColors['A'] = 'fw-bold fs-5 text-success align-middle';
textColors['R'] = 'fw-bold fs-5 text-danger align-middle';
textColors['F'] = 'fw-bold fs-5 text-primary align-middle';
textColors['C'] = 'fw-bold fs-5 text-warning align-middle';

const statusTexts = [];
statusTexts['O'] = '주문신청';
statusTexts['A'] = '예약승인';
statusTexts['R'] = '주문거절';
statusTexts['F'] = '서비스완료';
statusTexts['C'] = '예약취소';

const payStatusTexts = [];
payStatusTexts['P'] = '결제완료';
payStatusTexts['R'] = '환불완료';

document.querySelector('#searchBtn').addEventListener('click', function() {
    const form = document.querySelector('#searchForm');
    const orderStatus = document.querySelector('.orderStatusSelect').value;
    const orderStatusInput = document.createElement('input');
    console.log(orderStatus);
    orderStatusInput.setAttribute('type', 'hidden');
    orderStatusInput.setAttribute('name', 'orderStatus');
    orderStatusInput.setAttribute('value', orderStatus);
    // form.appendChild(orderStatus);
    // form.append('orderStatus', orderStatus);
    form.appendChild(orderStatusInput);
    console.log(form);
    form.submit();
})

// statusSelectEl.addEventListener('change', function (e ){
//     console.log(e.target.value)
//     location.href = `/admin/order/list?orderStatus=${e.target.value}`;
// })
    // const statusText = e.target.textContent;
    // const textColor = e.target.dataset.textColor;
    // console.log(list)
    // let filteredList = [];
    // if (e.target.dataset.status !== "Z") {
    //     filteredList = list.filter(order => {
    //         return order.orderStatus == e.target.dataset.status;
    //     })
    // } else {
    //     filteredList = list;
    // }
    //
    // const tbody = document.querySelector('#tbody');
    // tbody.innerHTML = '';
    // filteredList.forEach(list => {
    //     // const tr = document.createElement('tr');
    //     // const td = document.createElement('td');
    //     const tr = `<tr onclick="location.href='/admin/order/detail?orderCode=${list.orderCode}'">
    //         <td class="align-middle">${list.orderCode}</td>
    //         <td class="${textColors[list.orderStatus]}">${statusTexts[list.orderStatus]}</td>
    //         <td class="align-middle fs-5" style="${list.payStatus === 'P' ? "color: #003f62" : "color: #222222"}">${payStatusTexts[list.payStatus]}</td>
    //         <td class="align-middle">${list.totalPrice}</td>
    //         <td class="align-middle">${list.serviceTitle}</td>
    //         <td class="align-middle">${list.orderDateString}</td>
    //     </tr>`
    //     tbody.insertAdjacentHTML("beforeend", tr);
    // })
// });