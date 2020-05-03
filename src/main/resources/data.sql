INSERT INTO user_dictionary ( user_name,
                              first_name,
                              email)
                     values ('student',
                             'len',
                             'len@len.rf');
COMMIT;
INSERT INTO user_dictionary ( user_name,
                              first_name,
                              email)
                     values ('mentor',
                             'lenKa',
                             'lenKa@len.rf');
COMMIT;
INSERT INTO question (message,
                      theme,
                      carma_point,
                      hard_level,
                      chat_mentor,
                      category,
                      id_student)
              VALUES ('what is phys?',
                      'phys? is what?',
                      '3',
                      'EASY',
                      'FALSE',
                      'physics',
                      '1');
COMMIT;
INSERT INTO question (message,
                      theme,
                      carma_point,
                      hard_level,
                      chat_mentor,
                      category,
                      id_student)
              VALUES ('notdsf',
                      'Atata',
                      '3',
                      'EASY',
                      'FALSE',
                      'physics',
                      '1');
COMMIT;
INSERT INTO answer (message,
                    carma_point,
                    id_mentor,
                    id_question)
              VALUES ('I`m Ilon Mask',
                      '7',
                      '2',
                      '1');
COMMIT;