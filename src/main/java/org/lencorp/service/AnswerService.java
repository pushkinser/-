package org.lencorp.service;

import lombok.AllArgsConstructor;
import org.lencorp.model.dto.AnswerDto;
import org.lencorp.model.mapper.AnswerMapper;
import org.lencorp.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {

    private AnswerRepository answerRepository;
    private AnswerMapper answerMapper;

    public List<AnswerDto> getAnswers(){
        return answerMapper.answerToAnswerDtoList(answerRepository.findAll());
    }
}
