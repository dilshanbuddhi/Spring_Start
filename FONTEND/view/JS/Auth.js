$("#loginBtn").on("click", function() {

    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/authenticate',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            email: email,
            password: password
        }),
        success: function(response) {
            console.log("Login successful");
            console.log(response.data.token , "   token");
            localStorage.setItem("token", response.data.token);
            console.log(localStorage.getItem("token"),  "meka awe local eken");
            window.location.href = "item.html";
}
    });
});

$("#registerBtn").on("click", function() {

    var name = document.getElementById("name").value;
    var email = document.getElementById("regemail").value;
    var password = document.getElementById("regpassword").value;

    $.ajax({
        url: 'http://localhost:8080/api/v1/user/register',
        method: 'POST',

        contentType: 'application/json',  // Set content type to JSON
        data: JSON.stringify({
            email: email,
            password:password,
            name:name,
            role:"user"
        }),
        success: function(response) {
            console.log("Registration successful");
            console.log(response);
           localStorage.setItem("token", response.data.token);
            console.log(localStorage.getItem("token"),  "meka awe local eken");
           window.location.href = "item.html";
        }
    })
});