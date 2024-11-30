function fetchData(url, method, body=null){
    const token = localStorage.getItem("jwtToken");
    const headers = {
        "Content-Type": "application/json"

    };
    if (token){
        headers["Authorization"] = "Bearer "+ token;
    }
    const options = {
        method: method,
        headers: headers,
    };

    if (body){
        options.body = JSON.stringify(body);
    }

    return fetch(url,options);
}

function isTokenValid(token) {
    try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        const currentTime = Math.floor(Date.now() / 1000);

        // Kiểm tra expiration và loại bỏ trường hợp anonymous
        return payload.exp > currentTime && payload.sub !== "anonymousUser";
    } catch (error) {
        showNoticeMessage(false,"Phiên không hợp lệ!")
        return false;
    }
}

function showNoticeMessage(dataStatus, dataMessage) {
    let noticeContainer;
    let noticeMessage;

    if (dataStatus) {
        noticeContainer = document.getElementById("success-notice");
        noticeMessage = document.getElementById("success-message");
        console.log("succ")

    } else {
        noticeContainer = document.getElementById("error-notice");
        noticeMessage = document.getElementById("error-message");
        console.log("err")
    }

    noticeContainer.style.display = "block";
    noticeMessage.textContent = dataMessage;

    setTimeout(function() {
        noticeContainer.style.display = "none";
    }, 2000);  // Ẩn sau 2 giây
}