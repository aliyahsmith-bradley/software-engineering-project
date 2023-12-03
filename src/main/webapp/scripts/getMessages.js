getMessages = async () => {
    let response = await axios.get('getMessages')
    let messages = ""
    for(let i = 0; i < response.data.length; i++) {
        messages += "Message: " + response.data[i].message + "<br>"
    }
    document.getElementById('messages').innerHTML = messages;
}