const step1Form = document.getElementById("step1");
const step2Form = document.getElementById("step2");

document.querySelector("#step2 .btn-login").addEventListener("click", function(event) {
    event.preventDefault();

    const registerData = {
        name: step1Form.querySelector("input[name='fullname']").value,
        phoneNum: step1Form.querySelector("input[name='phoneNum']").value,
        email: step1Form.querySelector("input[name='email']").value,
        citizenID: step1Form.querySelector("input[name='citizenId']").value,
        creditNum: step1Form.querySelector("input[name='creditNum']").value,
        username: step2Form.querySelector("input[name='username']").value,
        password: step2Form.querySelector("input[name='password']").value,
    };

    if (!step2Form.checkValidity()) {
        step2Form.reportValidity(); //tra ve report neu co loi
        return;
    }

    const confirmPassword=step2Form.querySelector("input[name='rewritePassword']").value
    // Check pasword
    if (registerData.password !== confirmPassword) {
        showNoticeMessage(false,"Mật khẩu không khớp");
        return;
    }

    fetchData("/flight-booking/register", "POST", registerData)
        .then(response => response.json())
        .then(data => {
            if (data.success){
                window.location.href = "/flight-booking/login.html";
            } else {
                showNoticeMessage(data.success, data.message || "Đăng ký thất bại!");
            }
        });
});


