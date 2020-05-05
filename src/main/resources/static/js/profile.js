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
    profileElement.setAttribute('class', 'alert alert-info');

    var profileImg = document.createElement('li');
    var img = new Image();
        img.src = user.imgUrl;
        profileImg.appendChild(img);
        profileElement.appendChild(profileImg);

    var profileUName = document.createElement('li');
        profileUName.setAttribute('class','txPr');
    var text = document.createTextNode(user.userName);
        profileUName.appendChild(text);
        profileElement.appendChild(profileUName);

    var profileFName = document.createElement('li');
        profileFName.setAttribute('class','txPr');
    var text = document.createTextNode(user.firstName);
        profileFName.appendChild(text);
        profileElement.appendChild(profileFName);

    var profileEmail = document.createElement('li');
        profileEmail.setAttribute('class','txPr');
    var text = document.createTextNode(user.email);
        profileEmail.appendChild(text);
        profileElement.appendChild(profileEmail);

    var profileButLi = document.createElement('li');
    var profileBut = document.createElement('div');
        profileBut.setAttribute('class','row btnAn');
    var button = document.createElement('button');
        button.setAttribute('type', 'button');
        button.setAttribute('class', 'btn btn-primary btnForm');
    var text = document.createTextNode('Аналитика вопросов');
        button.appendChild(text);
        button.onclick = function () {
            var div1 = document.createElement('div');
                div1.setAttribute('id', 'plotly-chart1');
            var div2 = document.createElement('div');
                div2.setAttribute('id', 'plotly-chart2');
            var div3 = document.createElement('div');
                div3.setAttribute('id', 'plotly-chart3');
            var div4 = document.createElement('div');
                div4.setAttribute('id', 'plotly-chart4');
            var div5 = document.createElement('div');
                div5.setAttribute('id', 'plotly-chart5');
            var div6 = document.createElement('div');
                div6.setAttribute('id', 'plotly-chart6');

            profileArea.appendChild(div1);
            profileArea.appendChild(div2);
            profileArea.appendChild(div3);


            async function postData(url = '', data = {}) {

              const response = await fetch(url, {
                method: 'POST', mode: 'cors',
            credentials: 'same-origin',
                cache: 'no-cache',
                headers: {
                  'Content-Type': 'application/json'
                },

              body: JSON.stringify(data)
              });
              return await response.json();
            }

            postData('http://80.82.45.91:5566', { id: 128 }).then((data) => {
              Plotly.newPlot('plotly-chart1', data.questions_level.data, data.questions_level.layout)
              Plotly.newPlot('plotly-chart2', data.questions_category.data, data.questions_category.layout)
              Plotly.newPlot('plotly-chart3', data.questions_carma.data, data.questions_carma.layout)

              });
            };
        profileBut.appendChild(button);
        profileElement.appendChild(profileBut);

            var button = document.createElement('button');
                button.setAttribute('type', 'button');
                button.setAttribute('class', 'btn btn-primary btnForm');
            var text = document.createTextNode('Аналитика ответов');
                button.appendChild(text);
                button.onclick = function () {
                            var div1 = document.createElement('div');
                                div1.setAttribute('id', 'plotly-chart1');
                            var div2 = document.createElement('div');
                                div2.setAttribute('id', 'plotly-chart2');
                            var div3 = document.createElement('div');
                                div3.setAttribute('id', 'plotly-chart3');
                            var div4 = document.createElement('div');
                                div4.setAttribute('id', 'plotly-chart4');
                            var div5 = document.createElement('div');
                                div5.setAttribute('id', 'plotly-chart5');
                            var div6 = document.createElement('div');
                                div6.setAttribute('id', 'plotly-chart6');

                            profileArea.appendChild(div4);
                            profileArea.appendChild(div5);
                            profileArea.appendChild(div6);

                            async function postData(url = '', data = {}) {

                              const response = await fetch(url, {
                                method: 'POST', mode: 'cors',
                            credentials: 'same-origin',
                                cache: 'no-cache',
                                headers: {
                                  'Content-Type': 'application/json'
                                },

                              body: JSON.stringify(data)
                              });
                              return await response.json();
                            }

                            postData('http://80.82.45.91:5566', { id: 128 }).then((data) => {
                              Plotly.newPlot('plotly-chart4', data.answer_level.data, data.answer_level.layout)
                              Plotly.newPlot('plotly-chart5', data.answer_category.data, data.answer_category.layout)
                              Plotly.newPlot('plotly-chart6', data.answer_carma.data, data.answer_carma.layout)
                              });
                            };
                profileBut.appendChild(button);
                profileButLi.appendChild(profileBut);
                profileElement.appendChild(profileButLi);

                profileArea.appendChild(profileElement);

}