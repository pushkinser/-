function callSaveQuestion() {
    let message = document.getElementById('message-input-id').value;
    let theme = document.getElementById('theme-input-id').value;

    fetch('/save-question', {
        method: 'post',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({message: message, theme: theme})
    }).then(res=>res.json())
        .then(res => console.log(res));

}
function fastPop() {
    console.log("HALO");
    prompt('Введите вознагрождение:');
}
