INSERT INTO privileges(id, title, description) VALUES (1, 'admin', 'Administrator');
INSERT INTO privileges(id, title, description) VALUES (2, 'user', 'User');

INSERT INTO groups(id, parent_id, title) VALUES (1, -1, 'first');

INSERT INTO messages(id, text, author) VALUES (3, 'tes1', 'Kolas');

INSERT INTO skill_types(id, skill_name) VALUES (1, 'Windows');
INSERT INTO skill_types(id, skill_name) VALUES (2, 'Lunix');
INSERT INTO skill_types(id, skill_name) VALUES (3, 'MacOS');

INSERT INTO resources(id, first_name, last_name, base_cost, currency_id)
VALUES (1, 'Ivan', 'Drago', 100, 1);
INSERT INTO resources(id, first_name, last_name, base_cost, currency_id)
VALUES (2, 'Denis', 'Danchenkov', 200, 1);
INSERT INTO resources(id, first_name, last_name, base_cost, currency_id)
VALUES (3, 'Sarah', 'Connor', 300, 1);


INSERT INTO res_skills(id, res_id, skill_id) VALUES (1, 1, 1);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (2, 1, 2);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (3, 2, 2);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (4, 2, 1);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (5, 3, 1);
INSERT INTO res_skills(id, res_id, skill_id) VALUES (6, 3, 3);

INSERT INTO res_skills(id, res_id, skill_id) VALUES (7, 4, 1);

/**********************************************************************************************/
INSERT INTO currency(id, name, letter_code, digit_code, symbol, default_currency)
    VALUES (1, 'United States dollar', 'USD', 840, '$', TRUE);

INSERT INTO currency(id, name, letter_code, digit_code, symbol, default_currency)
    VALUES (2, 'Euro', 'EUR', 978, '€', FALSE );

INSERT INTO currency(id, name, letter_code, digit_code, symbol, default_currency)
    VALUES (3, 'Russian ruble', 'RUB', 643, '₽', FALSE );

INSERT INTO resource(id, first_name, last_name, native_name, login, active, sex, email, notify_unfilled_ts, emp_currency, nwo_prohibited)
    VALUES (1, 'Sergey', 'Nemchinsky', 'Сергей Немчинский', 'snemchinsky', TRUE, TRUE, 'snemchinsky@google.com', TRUE, 1, TRUE);

INSERT INTO resource(id, first_name, last_name, native_name, login, active, sex, email, notify_unfilled_ts, emp_currency, nwo_prohibited)
    VALUES (2, 'Ivan', 'Okhlobistin', 'Иван Охлобыстин', 'iokhlobistin', TRUE, TRUE, 'iokhlobistin@google.com', TRUE, 1, TRUE);

INSERT INTO resource_cost (start_date, resource_id, base_cost, currency_id)
    VALUES ('2015-01-01', 1, 1000, 1);

INSERT INTO resource_cost (start_date, resource_id, base_cost, currency_id)
    VALUES ('2015-03-01', 1, 500, 2);

INSERT INTO exchange_currency_rates (date, currency_from, currency_to, exchange_rate)
    VALUES ('2015-01-01', 2, 1, 1.11);

INSERT INTO exchange_currency_rates (date, currency_from, currency_to, exchange_rate)
    VALUES ('2015-03-01', 2, 1, 1.2);

INSERT INTO exchange_currency_rates (date, currency_from, currency_to, exchange_rate)
    VALUES ('2015-06-01', 2, 1, 1.3);