document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // prevent resend form

    const loginData = {
        username: event.target.username.value,
        password: event.target.password.value
    };

    //Fetch API
    fetch("/flight-booking/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)

    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                localStorage.setItem("jwtToken", data.token);
                window.location.href = "/flight-booking/index.html";
            } else {
                alert(data.message || "Đăng nhập thất bại!");
            }

        })
        .catch(error => {
            console.error("Error:", error);
            alert("Có lỗi xảy ra khi đăng nhập!");
        });
});
