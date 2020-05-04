package org.lencorp.controller;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.AnswerDto;
import org.lencorp.service.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnswerController {

    private AnswerService answerService;

    @GetMapping("answers/")
    public List<AnswerDto> getAnswers(){
        return answerService.getAnswers();
    }
}
