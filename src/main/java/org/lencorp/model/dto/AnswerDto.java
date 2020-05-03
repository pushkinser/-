package org.lencorp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lencorp.model.entity.Question;
import org.lencorp.model.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private int id;

    private String message;

    private int carmaPoint;

    private User mentor;

    private Question question;
}
