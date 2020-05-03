package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
