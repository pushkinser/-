'use strict';
let profileArea = document.querySelector('#profile-card');

window.onload = function () {
    fetch("profile/",
        {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (response.status !== 200) {

                return Promise.reject();
            }

            return response.json();
        })
        .then(user => {
            drawProfile(user);
        })
        .catch(() => console.log('Error profiles'));
};

function drawProfile(user) {

    var profileElement = document.createElement('ul');
    profileElement.setAttribute('style', '"margin-bottom: 10px;"');

    var profileImg = document.createElement('li');
    var img = new Image();
        img.src = user.imgUrl;
        profileImg.appendChild(img);
        profileElement.appendChild(profileImg);

    var profileUName = document.createElement('li');
    var text = document.createTextNode(user.userName);
        profileUName.appendChild(text);
        profileElement.appendChild(profileUName);

    var profileFName = document.createElement('li');
    var text = document.createTextNode(user.firstName);
        profileFName.appendChild(text);
        profileElement.appendChild(profileFName);

    var profileEmail = document.createElement('li');
    var text = document.createTextNode(user.email);
        profileEmail.appendChild(text);
        profileElement.appendChild(profileEmail);

    var profileBut = document.createElement('li');
    var button = document.createElement('button');
        button.setAttribute('type', 'button');
        button.setAttribute('class', 'btn btn-primary');
    var text = document.createTextNode('Аналитика вопросов');
        button.appendChild(text);
       /* button.onclick = function () {
        fetch("addCheck",
            {
                method: "POST",
                body: JSON.stringify({id: checkDto.id}),
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json'
                }
            })
            .then(response => {
                if (response.status != 200) {
                    return Promise.reject();
                }
            })
            .then(() => {
                console.log('indusi');
                getChecks();
                getBasketChecks();
            })
            .catch(() => console.log('Error check'));
            };*/
        profileBut.appendChild(button);
        profileElement.appendChild(profileBut);

         var profileBut = document.createElement('li');
            var button = document.createElement('button');
                button.setAttribute('type', 'button');
                button.setAttribute('class', 'btn btn-primary');
            var text = document.createTextNode('Аналитика ответов');
                button.appendChild(text);
               /* button.onclick = function () {
                fetch("addCheck",
                    {
                        method: "POST",
                        body: JSON.stringify({id: checkDto.id}),
                        headers: {
                            'Accept': 'application/json',
                            'Content-type': 'application/json'
                        }
                    })
                    .then(response => {
                        if (response.status != 200) {
                            return Promise.reject();
                        }
                    })
                    .then(() => {
                        console.log('indusi');
                        getChecks();
                        getBasketChecks();
                    })
                    .catch(() => console.log('Error check'));
                    };*/
                profileBut.appendChild(button);
                profileElement.appendChild(profileBut);

                profileArea.appendChild(profileElement);

}