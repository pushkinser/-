package org.lencorp.service;


import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.model.dto.UserDto;
import org.lencorp.model.mapper.QuestionMapper;
import org.lencorp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;

    public List<QuestionDto> getAllQuestions() {
        return questionMapper.questionToQuestionDtoList(questionRepository.findAll());
    }
    public void saveQuestion (QuestionDto questionDto){
        questionDto.setHardLevel("MEDIUM");
        questionDto.setCategory("Математика");
        UserDto userDto = new UserDto();
        userDto.setId(1);
        questionDto.setStudent(userDto);

        questionRepository.save(questionMapper.questionDtoToQuestion(questionDto));
    }
}
