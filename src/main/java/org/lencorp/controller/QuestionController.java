package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @GetMapping("questions/")
    public List<QuestionDto> getQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save-question",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionDto saveQuestion(@RequestBody QuestionDto questionForm) {
        questionService.saveQuestion(questionForm);
        return questionForm;
    }

    @PostMapping ("/question")
    public String getQuestion (@RequestBody QuestionDto questionDto){
        return "redirect:/question/{"+questionDto.getId()+"}";
    }
    @GetMapping ("/questionid")
    public QuestionDto getQuestionById (){
        QuestionDto questionDto = questionService.getQuestion(1L);
        return questionDto;
    }

}
