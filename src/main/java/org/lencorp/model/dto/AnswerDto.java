package org.lencorp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private int id;

    private String message;

    private int carmaPoint;

    private UserDto mentor;

    private QuestionDto question;

    @Override
    public String toString() {
        return "AnswerDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", carmaPoint=" + carmaPoint +
                '}';
    }
}
