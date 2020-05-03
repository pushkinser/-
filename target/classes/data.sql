INSERT INTO user_dictionary ( id,
                              user_name,
                              first_name,
                              email)
                     values ('1',
                             'student',
                             'len',
                             'len@len.rf');
COMMIT;
INSERT INTO user_dictionary ( id,
                              user_name,
                              first_name,
                              email)
                     values ('2',
                             'mentor',
                             'lenKa',
                             'lenKa@len.rf');
COMMIT;
INSERT INTO question (id,
                      message,
                      category,
                      id_student)
              VALUES ('1',
                      'what is phys?',
                      'physics',
                      '1');
COMMIT;
INSERT INTO answer (id,
                    message,
                    point,
                    id_mentor,
                    id_question)
              VALUES ('1',
                      'I`m Ilon Mask',
                      '7',
                      '2',
                      '1');
COMMIT;