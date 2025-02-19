    $(document).ready(function() {

    getAllItem();

    $("#addItemBtn").on("click", function() {
    console.log("Button Clicked");

    var name = document.getElementById("name").value;
    var des = document.getElementById("des").value;
    var qty = document.getElementById("qty").value;
    var price = document.getElementById("price").value;

    $.ajax({
        url: 'http://localhost:8080/api/v1/item/save',
    method: 'POST',
    contentType: 'application/json',  // Set content type to JSON
    data: JSON.stringify({
    name: name,
    des: des,
    qty: qty,
    price: price
}),
    success: function(response) {
    console.log("Item saved successfully:", response);
    $('#addItemModal').modal('hide');
    getAllItem();
},
    error: function(xhr, status, error) {
    console.error("Error:", xhr, status, error);
}
});
});

    function getAllItem() {
    $.ajax({
    url: 'http://localhost:8080/api/v1/item/getAll',
    method: 'GET',
    success: function(response) {
    $('#ItemTableBody').empty();
    response.forEach(user => {
    $('#ItemTableBody').append(`
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.des}</td>
      <td>${user.qty}</td>
      <td>${user.price}</td>
      <td>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editItemModal"
        onclick='editItem(${JSON.stringify(user)})'>Edit</button>
        <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteItemModal" onclick="deleteUser(${user.id})">Delete</button>
      </td>
    </tr>
  `);
});
},
    error: function(xhr, status, error) {
    // Handle errors
}
});
}


    $("#itemEditBtn").on("click", function() {

        var id = document.getElementById("editid").value;
        var name = document.getElementById("editname").value;
        var des = document.getElementById("editdes").value;
        var qty = document.getElementById("editqty").value;
        var price = document.getElementById("editprice").value;
    $.ajax({
        url: 'http://localhost:8080/api/v1/item/update',
    method: 'PUT',
    contentType: 'application/json',  // Set content type to JSON
    data: JSON.stringify({
    id: id,
    name: name,
    des: des,
    qty: qty,
    price: price
}),
    success: function (response) {
    console.log("Item updated successfully:", response);
    $('#editItemModal').modal('hide');
    getAllItem();
},
    error: function (xhr, status, error) {
    console.error("Error:", xhr, status, error);
}
});

});


    $("#itemdeleteButton").on("click", function() {
    var id = document.getElementById("deleteId").value;
    $.ajax({
    url: 'http://localhost:8080/api/v1/item/delete/' + id,
    method: 'DELETE',
    success: function (response) {
    console.log("item deleted successfully:", response);
    $('#deleteItemModal').modal('hide');
    getAllItem();
},
    error: function (xhr, status, error) {
    console.error("Error:", xhr, status, error);
}
});
});

});//ready function end wena thana

    function editItem(user) {
    console.log("edit clicked");
    // Set the values of the modal fields based on the user object

        document.getElementById("editid").value = user.id;
        document.getElementById("editname").value = user.name;
        document.getElementById("editdes").value = user.des;
        document.getElementById("editqty").value = user.qty;
        document.getElementById("editprice").value = user.price;

    $('#editItemModal').modal('show');
}

    function deleteUser(id) {
    console.log("delete clicked");
    document.getElementById('deleteId').value = id;
    $('#deleteItemModal').modal('show');
}

