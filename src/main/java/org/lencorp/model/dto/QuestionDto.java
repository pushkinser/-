package org.lencorp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lencorp.model.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private int id;

    private String message;

    private int carmaPoint;

    private String hardLevel;

    private boolean chatMentor;

    private String category;

    private User student;

    // private List<Answer> answers;

}
