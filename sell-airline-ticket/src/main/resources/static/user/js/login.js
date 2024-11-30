document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // prevent resend form

    const loginData = {
        username: document.querySelector("input[name='username']").value,
        password: document.querySelector("input[name='password']").value,
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
                console.log(data.token)
                window.location.href = "/flight-booking/index.html";
            } else {
                showNoticeMessage(false,"Sai thông tin đăng nhập")
            }

        })
        .catch(error => {
            showNoticeMessage(false,"Đã xảy ra lỗi")
        });
});
