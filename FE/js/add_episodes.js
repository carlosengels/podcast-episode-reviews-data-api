
const episodeForm = document.querySelector("#add-episode-form");
let url = 'https://v7zpiktx4h.execute-api.us-west-2.amazonaws.com/Beta/episodes';
let headers = {
    authorization: {
        'x-api-key': '3ZJBPRvKUz1RG8csfQS014zRFkGnMnQx9L9rQWUZ'
    }
}


episodeForm.onsubmit = async function(evt) {
    evt.preventDefault();

    console.log("Creating new episode ...")

    const podcast = document.querySelector("#podcast").value;
    const episodeName = document.querySelector("#episodeName").value;
    const episodeNr = document.querySelector("#episodeNr").value;

    let episodeObj = {
        "podcast": podcast,
        "name": episodeName,
        "episodeNr": episodeNr
    }

    axios.post(url, episodeObj, headers).then((res) => {
        console.log(res);
        window.location.reload();
    })
}

let function1 = function() {
    console.log("Test123")
}