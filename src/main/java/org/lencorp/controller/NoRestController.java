package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class NoRestController {

    private QuestionService questionService;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String getQuestionById (){
        QuestionDto questionDto = questionService.getQuestion(1L);
        return "question.html";
    }
}
