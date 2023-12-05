getIssues = async () => {
    let response = await axios.get('getIssues')
    let issues = ""
    for(let i = 0; i < response.data.length; i++) {
        issues += response.data[i].title + "<br>" + response.data[i].body + "<br>"
        issues += response.data[i].dt_sent
    }
    document.getElementById('issues').innerHTML = issues;
}