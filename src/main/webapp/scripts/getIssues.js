getIssues = async () => {
    let response = await axios.get('getIssues')
    let issues = ""
    for(let i = 0; i < response.data.length; i++) {
        issues += "Title: " + response.data[i].title + "<br>Description: " + response.data[i].body + "<br>"
        issues += Date(response.data[i].dt_sent).toString() + "<br><br>"
    }
    document.getElementById('issues').innerHTML = issues;
}