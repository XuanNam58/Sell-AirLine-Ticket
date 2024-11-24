window.onload = function() {
    const loginStatusLink = document.querySelector(".login-status");
    const token = localStorage.getItem("jwtToken");

    if (token && isTokenValid(token)) {
        loginStatusLink.href = "/flight-booking/user/info";
        loginStatusLink.textContent = "Thông tin cá nhân";

        fetch("/flight-booking/user/info", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwtToken") // Lấy token từ localStorage
            }
        })
            .then(response => response.text())
            .then(data => {
                console.log(data);
            })
            .catch(error => {
                console.error("Error:", error);
            });

    } else {
        loginStatusLink.href = "/flight-booking/login.html";
        loginStatusLink.textContent = "Đăng nhập";
    }


};

function isTokenValid(token) {
    try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        const currentTime = Math.floor(Date.now() / 1000);

        // Kiểm tra expiration và loại bỏ trường hợp anonymous
        return payload.exp > currentTime && payload.sub !== "anonymousUser";
    } catch (error) {
        console.error("Token không hợp lệ:", error);
        return false;
    }
}

