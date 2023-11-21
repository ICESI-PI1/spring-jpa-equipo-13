-- Author insertions

INSERT INTO author (id, name, nationality) VALUES (1, 'Gabriel Garcia Marquez', 'Colombiano');
INSERT INTO author (id, name, nationality) VALUES (2, 'Isabel Allende', 'Chilena');
INSERT INTO author (id, name, nationality) VALUES (3, 'Mario Vargas Llosa', 'Peruano');
INSERT INTO author (id, name, nationality) VALUES (4, 'Jorge Luis Borges', 'Argentino');
INSERT INTO author (id, name, nationality) VALUES (5, 'Julio Cortázar', 'Argentino');
INSERT INTO author (id, name, nationality) VALUES (6, 'Pablo Neruda', 'Chileno');
INSERT INTO author (id, name, nationality) VALUES (7, 'Laura Esquivel', 'Mexicana');
INSERT INTO author (id, name, nationality) VALUES (8, 'Carlos Fuentes', 'Mexicano');
INSERT INTO author (id, name, nationality) VALUES (9, 'Gabo Garcia Bernal', 'Mexicano');
INSERT INTO author (id, name, nationality) VALUES (10, 'Cesar Vallejo', 'Peruano');
INSERT INTO author (id, name, nationality) VALUES (11, 'Octavio Paz', 'Mexicano');
INSERT INTO author (id, name, nationality) VALUES (12, 'Miguel de Cervantes', 'Español');
INSERT INTO author (id, name, nationality) VALUES (13, 'William Shakespeare', 'Inglés');
INSERT INTO author (id, name, nationality) VALUES (14, 'Leo Tolstoy', 'Ruso');
INSERT INTO author (id, name, nationality) VALUES (15, 'Jane Austen', 'Inglés');

-- Book insertions

-- Insertando libros con sus respectivos autores (asegúrate de que los autores ya existen en la tabla "author")
INSERT INTO book (id, title, publication_date, author_id) VALUES (1, 'Cien años de soledad', '1967-05-30', 1);
INSERT INTO book (id, title, publication_date, author_id) VALUES (2, 'La Casa de los Espíritus', '1982-01-01', 2);
INSERT INTO book (id, title, publication_date, author_id) VALUES (3, 'La ciudad y los perros', '1963-01-01', 3);
INSERT INTO book (id, title, publication_date, author_id) VALUES (4, 'Ficciones', '1944-01-01', 4);
INSERT INTO book (id, title, publication_date, author_id) VALUES (5, 'Rayuela', '1963-01-01', 5);
INSERT INTO book (id, title, publication_date, author_id) VALUES (6, 'Veinte Poemas de Amor y Una Canción Desesperada', '1924-01-01', 6);
INSERT INTO book (id, title, publication_date, author_id) VALUES (7, 'Como agua para chocolate', '1989-01-01', 7);
INSERT INTO book (id, title, publication_date, author_id) VALUES (8, 'La muerte de Artemio Cruz', '1962-01-01', 8);
INSERT INTO book (id, title, publication_date, author_id) VALUES (9, 'Amores perros', '2000-01-01', 9);
INSERT INTO book (id, title, publication_date, author_id) VALUES (10, 'Trilce', '1922-01-01', 10);
INSERT INTO book (id, title, publication_date, author_id) VALUES (11, 'El laberinto de la soledad', '1950-01-01', 11);
INSERT INTO book (id, title, publication_date, author_id) VALUES (12, 'Don Quijote de la Mancha', '1605-01-01', 12);
INSERT INTO book (id, title, publication_date, author_id) VALUES (13, 'Hamlet', '1603-01-01', 13);
INSERT INTO book (id, title, publication_date, author_id) VALUES (14, 'Guerra y paz', '1869-01-01', 14);
INSERT INTO book (id, title, publication_date, author_id) VALUES (15, 'Orgullo y prejuicio', '1813-01-01', 15);
