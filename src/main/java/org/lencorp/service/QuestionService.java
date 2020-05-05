package org.lencorp.service;


import lombok.AllArgsConstructor;
import org.lencorp.model.dto.QuestionDto;
import org.lencorp.model.dto.UserDto;
import org.lencorp.model.entity.User;
import org.lencorp.model.mapper.QuestionMapper;
import org.lencorp.model.mapper.UserMapper;
import org.lencorp.repository.QuestionRepository;
import org.lencorp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;
    private UserRepository userRepository;
    private UserMapper userMapper;

    public List<QuestionDto> getAllQuestions() {
        return questionMapper.questionToQuestionDtoList(questionRepository.findAll());
    }
    public void saveQuestion (QuestionDto questionDto){
        questionDto.setHardLevel("MEDIUM");
        questionDto.setCategory("Математика");
        User user = userRepository.findUserById(1L);
        questionDto.setStudent(userMapper.userToUserDto(user));
        questionRepository.save(questionMapper.questionDtoToQuestion(questionDto));
    }

    public QuestionDto getQuestion (Long id){
        return questionMapper.questionToQuestionDto(questionRepository.findQuestionById(id));
    }
}
