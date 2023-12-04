getFriends = async () => {
    let response = await axios.get('getFriends')
    let name;
    let messages = ""
    for(let i = 0; i < response.data.length; i++) {
        name = await getUserNameByUserID(response.data[i].id_user1)
        console.log(name)
        messages += "Friend: " + name + "<br>"
    }
    document.getElementById('friends').innerHTML = messages;
}

getUserNameByUserID = async (id) => {
    let response = await axios.get(`getUserNameByID?id=${id}`)
    return response.data.username;
}