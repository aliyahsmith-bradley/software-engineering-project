getMessages = async () => {
    let response = await axios.get('getMessages')
    let messages = ""
    for(let i = 0; i < response.data.length; i++) {
        messages += "From: " + await getUserNameByUserID(response.data[i].id_user_sender) + "<br>";
        messages += "Message: " + response.data[i].message + "<br>"
    }
    document.getElementById('messages').innerHTML = messages;
}

getUserNameByUserID = async (id) => {
    let response = await axios.get(`getUserNameByID?id=${id}`)
    return response.data.username;
}