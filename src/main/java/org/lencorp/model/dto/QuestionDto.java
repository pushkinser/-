package org.lencorp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private UserDto student;

    // private List<Answer> answers;


    @Override
    public String toString() {
        return "QuestionDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", carmaPoint=" + carmaPoint +
                ", hardLevel='" + hardLevel + '\'' +
                ", chatMentor=" + chatMentor +
                ", category='" + category +
                '}';
    }
}
