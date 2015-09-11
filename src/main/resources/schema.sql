CREATE TABLE groups
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  parent_id bigint,
  title character varying(50) NOT NULL,
  CONSTRAINT groups_pkey PRIMARY KEY (id),
  CONSTRAINT groups_title_key UNIQUE (title)
);

CREATE TABLE privileges
(
  id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  title character varying(50) NOT NULL,
  description character varying(100),
  CONSTRAINT privileges_pkey PRIMARY KEY (id),
  CONSTRAINT privileges_title_key UNIQUE (title)
);

CREATE TABLE group_privilege
(
  privilege_id bigint NOT NULL,
  group_id bigint NOT NULL,
  CONSTRAINT group_privilege_pkey PRIMARY KEY (privilege_id, group_id),
  CONSTRAINT group_fk1 FOREIGN KEY (group_id) REFERENCES groups (id),
  CONSTRAINT privilege_fk FOREIGN KEY (privilege_id) REFERENCES privileges (id)
);

CREATE TABLE resource_group
(
  resource_id character varying(255) NOT NULL,
  group_id bigint NOT NULL,
  CONSTRAINT resource_group1_pkey PRIMARY KEY (resource_id, group_id),
  CONSTRAINT group_fk2 FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE SEQUENCE groups_sequence AS BIGINT START WITH 3 INCREMENT BY 10;
CREATE SEQUENCE privileges_sequence AS BIGINT START WITH 1 INCREMENT BY 1;

CREATE TABLE messages
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 3, INCREMENT BY 10) NOT NULL PRIMARY KEY,
  text VARCHAR(50) NOT NULL,
  author VARCHAR(50) NOT NULL
);

CREATE TABLE resources
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  base_cost BIGINT NOT NULL,
  currency_id BIGINT NOT NULL
);

CREATE TABLE skill_types
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  skill_name VARCHAR(50) NOT NULL
);

CREATE TABLE res_skills
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  res_id BIGINT NOT NULL,
  skill_id BIGINT,
  CONSTRAINT skill_skilltype_fk FOREIGN KEY (skill_id) REFERENCES skill_types (id)
);
/****************************************************************************/
CREATE TABLE currency
(
  id bigint NOT NULL IDENTITY,
  name VARCHAR(255) NOT NULL,
  letter_code VARCHAR(3) NOT NULL,
  digit_code VARCHAR(3) NOT NULL,
  symbol VARCHAR(5) NOT NULL,
  default_currency boolean NOT NULL,
  CONSTRAINT currency_pkey PRIMARY KEY (id),
  CONSTRAINT currency_digit_code_key UNIQUE (digit_code),
  CONSTRAINT currency_letter_code_key UNIQUE (letter_code),
  CONSTRAINT currency_symbol_key UNIQUE (symbol)
);

CREATE TABLE resource
(
  id bigint NOT NULL IDENTITY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  native_name VARCHAR(255),
  login VARCHAR(255),
  active boolean DEFAULT true,
  sex boolean DEFAULT true,
  email VARCHAR(255),
  notify_unfilled_ts boolean NOT NULL,
  emp_currency bigint NOT NULL,
  nwo_prohibited boolean,
  CONSTRAINT resource_pkey PRIMARY KEY (id),
  CONSTRAINT resource_emp_currency_fkey FOREIGN KEY (emp_currency) REFERENCES currency (id)
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT resource_login_unique UNIQUE (login)
);

CREATE TABLE resource_cost
(
  id bigint NOT NULL IDENTITY,
  start_date date NOT NULL,
  resource_id bigint NOT NULL,
  base_cost BIGINT NOT NULL,
  currency_id bigint NOT NULL,
  CONSTRAINT resource_cost_pkey PRIMARY KEY (id),
  CONSTRAINT fk_currency FOREIGN KEY (currency_id) REFERENCES currency (id)
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT resource_cost_resource_id_fkey FOREIGN KEY (resource_id) REFERENCES resource (id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE exchange_currency_rates
(
  id bigint NOT NULL IDENTITY,
  date timestamp NOT NULL,
  currency_from bigint NOT NULL,
  currency_to bigint NOT NULL,
  exchange_rate numeric(18,6) NOT NULL,
  CONSTRAINT exchange_currency_rates_pkey PRIMARY KEY (id),
  CONSTRAINT exchange_currency_rates_currency_from_fkey FOREIGN KEY (currency_from)
  REFERENCES currency (id)
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT exchange_currency_rates_currency_to_fkey FOREIGN KEY (currency_to)
  REFERENCES currency (id)
    ON UPDATE NO ACTION ON DELETE NO ACTION
)

