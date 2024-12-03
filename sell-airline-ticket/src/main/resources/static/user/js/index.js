window.onload = function() {
    const loginStatusLink = document.querySelector(".login-status");
        const logoutButton = document.querySelector(".logout");
        const token = localStorage.getItem("jwtToken");

        logoutButton.addEventListener('click', function(event) {
            event.preventDefault();
            localStorage.removeItem('jwtToken');
            window.location.href = '/flight-booking/login.html';
            });

    if (token && isTokenValid(token)) {
        loginStatusLink.href = "/flight-booking/info.html";
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
        logoutButton.style.display = "none";
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

