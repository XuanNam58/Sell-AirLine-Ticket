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