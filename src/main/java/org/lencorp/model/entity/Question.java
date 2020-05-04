package org.lencorp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "theme")
    private String theme;

    @Column(name = "carma_point")
    private int carmaPoint;

    @Column(name = "hard_level")
    private String hardLevel;

    @Column(name = "chat_mentor")
    private boolean chatMentor;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private User student;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", carmaPoint=" + carmaPoint +
                ", hardLevel='" + hardLevel + '\'' +
                ", chatMentor=" + chatMentor +
                ", category='" + category + '\'' +
                '}';
    }
}
