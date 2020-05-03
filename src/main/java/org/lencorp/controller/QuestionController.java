package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @GetMapping("questions/")
    public List<QuestionDto> getQuestions() {
       return questionService.getAllQuestions();
    }

    @PostMapping("saveQuestion/")
    public QuestionDto saveQuestion (@RequestBody QuestionDto questionForm){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setMessage(questionForm.getMessage());
        questionDto.setTheme(questionForm.getTheme());
        questionDto.setCategory(questionForm.getCategory());
        questionService.saveQuestion(questionDto);
        return questionDto;
    }

}
