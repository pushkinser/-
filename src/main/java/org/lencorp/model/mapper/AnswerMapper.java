package org.lencorp.model.mapper;

import org.lencorp.model.dto.AnswerDto;
import org.lencorp.model.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDto answerToAnswerDto(Answer answer);

    Answer answerDtoToAnswer(AnswerDto answerDto);

    List<Answer> answerDtoToAnswerList(List<AnswerDto> answerDtos);

    List<AnswerDto> answerToAnswerDtoList(List<Answer> answers);
}
