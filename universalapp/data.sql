INSERT INTO teacher (id, first_name, last_name) VALUES
(1, 'Matt', 'Farrow'),
(2, 'Jonathan', 'Georgiou'),
(3, 'Liam', 'McIvor'),
(4, 'Chloe', 'Adcock');

INSERT INTO module (id, teacher_id, module_name, module_code) VALUES
(1, 1, 'Group Theory', 'CHEM 384'),
(2, 1, 'Introduction to Physical Chemistry', 'CHEM 154'),
(3, 1, 'Advanced Spectroscopy', 'CHEM 411'),
(4, 2, 'Introduction to Quantum Chemistry', 'CHEM 354'),
(5, 2, 'Molecular Dynamics', 'CHEM 361'),
(6, 2, 'Laboratory Methods', 'CHEM 266'),
(7, 3, 'Introduction to Computational Chemistry', 'CHEM 284'),
(8, 4, 'Introduction to Organic Chemistry', 'CHEM 135'),
(9, 4, 'Heterocyclic Chemistry', 'CHEM 235'); 