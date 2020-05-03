package org.lencorp.model.mapper;


import org.lencorp.model.dto.QuestionDto;
import org.lencorp.model.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDto questionToQuestionDto(Question question);

    Question questionDtoToQuestion(QuestionDto questionDto);

    List<Question> questionDtoToQuestionList(List<QuestionDto> questionDtos);

    List<QuestionDto> questionToQuestionDtoList(List<Question> questions);
}
