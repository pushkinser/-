'use strict';
let answerArea = document.querySelector('#answer-id1');

window.onload = function () {
    fetch("answers/",
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
        .then(answers => {
            answers.forEach(function (item, answer) {
                drawQuestion(item);
            });
        })
        .catch(() => console.log('Error messages'));
};
function drawQuestion(answer) {
    var answerElement  =  document.createElement('div');
        answerElement.setAttribute('class','row ');
    var answer1 = document.createElement('div');
        answer1.setAttribute('class','ansCls alert alert-info');
    var ans = document.createElement('p');
    var text = document.createTextNode(answer.message);
        ans.appendChild(text);
        answer1.appendChild(ans);
        answerArea.appendChild(answer1);
    var answerRt = document.createElement('div');
        answerRt.setAttribute('class','btn-group btnGrp');
        answerRt.setAttribute('aria-label','Basic example');
    var btn1 = document.createElement('button');
        btn1.setAttribute('class','btn btn-secondary ');
        text = document.createTextNode('↑');
        btn1.appendChild(text);
        answerRt.appendChild(btn1);
        btn1 = document.createElement('button');
        btn1.setAttribute('class','btn btn-secondary ');
        btn1.setAttribute('disabled','true');
        text = document.createTextNode('+' + answer.carmaPoint);
        btn1.appendChild(text);
        answerRt.appendChild(btn1);
        btn1 = document.createElement('button');
        btn1.setAttribute('class','btn btn-secondary ');
        text = document.createTextNode('↓');
        btn1.appendChild(text);
        answerRt.appendChild(btn1);
        btn1 = document.createElement('button');
        btn1.setAttribute('class','btn btn-success ');
        text = document.createTextNode('Чат');
        btn1.appendChild(text);
        answerRt.appendChild(btn1);
    var answerUser = document.createElement('span');
        answerUser.setAttribute('class','badge badge-primary divUnderMsg');
    var text = document.createTextNode(answer.mentor.userName);
        answerUser.appendChild(text);
        answerRt.appendChild(answerUser);

        answerArea.appendChild(answerRt);






}
