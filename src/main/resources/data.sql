INSERT INTO user_dictionary ( user_name,
                              first_name,
                              email,
                              img_url)
                     values ('student',
                             'len',
                             'len@len.rf',
                             'https://production-endpoint.azureedge.net/images/64RJGCPO75FJAC1GF0QJ0C0/b670c13b-7e09-4893-9e47-5b1ff948f818/178389_500x500.jpg');
COMMIT;
INSERT INTO user_dictionary ( user_name,
                              first_name,
                              email,
                              img_url)
                     values ('mentor',
                             'lenKa',
                             'lenKa@len.rf',
                             'https://production-endpoint.azureedge.net/images/6KS3ICHJBSQJ0C3O6KO30/ed4cc4b8-f2d3-48fa-adab-1956b6033e2d/58923_500x500.jpg');
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