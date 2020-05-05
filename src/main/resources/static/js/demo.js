'use strict';
let questionArea = document.querySelector('#question-area');

window.onload = function () {
    fetch("questions/",
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
        .then(questions => {
            questions.forEach(function (item, question) {
                drawQuestion(item);
            });
        })
        .catch(() => console.log('Error messages'));
};

function drawQuestion(question) {
    var questionElement  =  document.createElement('ul');
        questionElement.setAttribute('class','alert alert-info');

    var questionMsg = document.createElement('li');
    var hrefMsg = document.createElement('a');
        hrefMsg.setAttribute('href','http://localhost:8073/question');
    var text = document.createTextNode(question.theme);
        hrefMsg.appendChild(text);
        hrefMsg.onclick = function () {
            fetch("/question",
                        {
                            method: "POST",
                            body: JSON.stringify({id: question.id}),
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
                };
        questionMsg.appendChild(hrefMsg);
        questionElement.appendChild(questionMsg);

    var underMsg = document.createElement('li');
        underMsg.setAttribute('class','liMsg');
    var questionUser = document.createElement('span');
        questionUser.setAttribute('class','badge badge-primary divUnderMsg');
    var text = document.createTextNode(question.student.userName);
        questionUser.appendChild(text);
        underMsg.appendChild(questionUser);

    var questionCategory = document.createElement('span');
        questionCategory.setAttribute('class','badge badge-primary divUnderMsg');
    var text = document.createTextNode(question.category);
        questionCategory.appendChild(text);
        underMsg.appendChild(questionCategory);

    var questionHardLevel = document.createElement('span');
        questionHardLevel.setAttribute('class','badge badge-primary divUnderMsg');
    var text = document.createTextNode(question.hardLevel);
        questionHardLevel.appendChild(text);
        underMsg.appendChild(questionHardLevel);

        questionElement.appendChild(underMsg);




    questionArea.appendChild(questionElement);
}
