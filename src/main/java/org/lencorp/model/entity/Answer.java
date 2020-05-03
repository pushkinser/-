package org.lencorp.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "carma_point")
    private int carmaPoint;

    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "id")
    private User mentor;

    @ManyToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    private Question question;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", carmaPoint=" + carmaPoint +
                '}';
    }
}
