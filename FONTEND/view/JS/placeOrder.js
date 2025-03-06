loadAllids()
loadAllItems()
let cartdata= [];
var tot=0

function loadAllids() {
    $.ajax({
        url: 'http://localhost:8080/api/v1/placeOrder/getCIDs',
        method: 'GET',
        success: function(response) {
            console.log(response);
            $("#customerSelect").empty();
            $('#customerSelect').append(`<option value="0">Select Customer</option>`);

            let data = response;
            for (let i = 0; i < data.length; i++) {

                let row = `<option value="${data[i]}">${data[i]}</option>` ;
                $('#customerSelect').append(row);
            }
        },
        error: function(xhr, status, error) {
console.log(
    error
)       }
    });
}


    $("#customerSelect").on('change', (e) => {
        let cid = e.target.value;
console.log(cid,"ghjklff");
    $.ajax({
        url: 'http://localhost:8080/api/v1/customers/getCName/' + cid,
        method: 'GET',
        success: function(response) {

            console.log(response , "ghjkl");
            document.getElementById("cname").value = response;
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
    })


function loadAllItems() {
    $.ajax({
        url: 'http://localhost:8080/api/v1/placeOrder/getAllItemIDs',
        method: 'GET',
        success: function(response) {
            console.log(response);
            $("#itemSelect").empty();
            $('#itemSelect').append(`<option value="0">Select Item</option>`);

            let data = response;
            for (let i = 0; i < data.length; i++) {

                let row = `<option value="${data[i]}">${data[i]}</option>` ;
                $('#itemSelect').append(row);
            }
        },
        error: function(xhr, status, error) {
console.log(
    error
)       }
    });
}


    $("#itemSelect").on('change', (e) => {
        let iid = e.target.value;
        console.log(iid,"ghjklff");
    $.ajax({
        url: 'http://localhost:8080/api/v1/placeOrder/getAllbyId/' + iid,
        method: 'GET',
        success: function(response) {

            console.log(response , "ghjkl");
            document.getElementById("qtyOnHand").value = response.qty;
            document.getElementById("unitPrice").value = response.price;
        },
        error: function(xhr, status, error) {
        z    console.log(error);
        }
    });
    })

$("#cart_btn").click((e) => {
    console.log('cart button clickeddddd');
    let cid = $('#customerSelect').val();
    let iid = $('#itemSelect').val();
    let qty = $('#quantity').val();
    let unitPrice = $('#unitPrice').val();
    let discount = $("#discount").val();
    let total;
    if (discount == null){
        total = qty * unitPrice;
    }else {
        total= qty * unitPrice - (qty * unitPrice * discount / 100);
    }

    tot = tot + total;

    console.log(cid, iid, qty, unitPrice, total);

    let cartobj = {cid, iid, qty, unitPrice, total};
    cartdata.push(cartobj);
    console.log(cartdata);
    $("#orderTotal").text('Order Total: ' + tot);

    loadCartDAta();
})


function loadCartDAta(){
    $('#ordertable').empty();
    for (let i = 0; i < cartdata.length; i++) {
        let row = `<tr>
        <td>${cartdata[i].cid}</td>
        <td>${cartdata[i].iid}</td>
        <td>${cartdata[i].qty}</td>
        <td>${cartdata[i].unitPrice}</td>
        <td>${cartdata[i].total}</td>
        <td><button class="btn btn-danger" onclick="removeItem(${i})">Remove</button></td>
        </tr>`;
        $('#ordertable').append(row);
    }
}
function removeItem(index) {
    tot = tot - cartdata[index].total;
    cartdata.splice(index, 1);
    $("#orderTotal").text('Order Total: ' + tot);
    loadCartDAta();
}


$("#placeOrder").click((e) => {
    // Example cartdata with multiple items
    let itemdata = [
  // backend ekt yna data tika
    ];

    cartdata.forEach(item => {
        itemdata.push(
            {
            id: item.iid,
            qty: item.qty,
            price: item.unitPrice
        }
        );
    });

    $.ajax({
        url: 'http://localhost:8080/api/v1/placeOrder/save',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            cid: cartdata[0].cid,
            arrayList: itemdata,
            tot: tot
        }),
        success: function(response) {
            console.log(response);
            cartdata.splice(0, cartdata.length);
            tot=0
            itemdata.splice(0, itemdata.length);
            $('#ordertable').empty();
            alert("Order Placed Successfully");
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
});
