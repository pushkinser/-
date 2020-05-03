package org.lencorp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String userName;

    private String firstName;

    private String email;

    //  private List<Answer> answers;

    // private List<Question> questions;
}
