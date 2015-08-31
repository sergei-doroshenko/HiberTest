INSERT INTO privileges(id, title, description) VALUES (1, 'admin', 'Administrator');
INSERT INTO privileges(id, title, description) VALUES (2, 'user', 'User');

INSERT INTO groups(id, parent_id, title) VALUES (1, -1, 'first');

INSERT INTO messages(id, text, author) VALUES (3, 'tes1', 'Kolas');

INSERT INTO skill_types(id, skill_name) VALUES (1, 'Windows');
INSERT INTO skill_types(id, skill_name) VALUES (2, 'Lunix');
INSERT INTO skill_types(id, skill_name) VALUES (3, 'MacOS');

INSERT INTO resources(id, res_name) VALUES (1, 'Ivan');
INSERT INTO resources(id, res_name) VALUES (2, 'Andrey');
INSERT INTO resources(id, res_name) VALUES (3, 'Nikolai');
INSERT INTO resources(id, res_name) VALUES (4, 'Sam');

INSERT INTO res_skills(id, res_id, skill_id) VALUES (1, 1, 1);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (2, 1, 2);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (3, 2, 2);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (4, 2, 1);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (5, 3, 1);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (6, 3, 3);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (7, 4, 1);

