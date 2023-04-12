DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS rate_date;
DROP TABLE IF EXISTS rate;

CREATE TABLE currency (
    id bigserial PRIMARY KEY,
    country VARCHAR(128),
    code VARCHAR(3));

CREATE TABLE rate_date (
    id bigserial PRIMARY KEY,
    date DATE UNIQUE);

CREATE TABLE rate (
    id BIGSERIAL PRIMARY KEY,
    amount INTEGER NOT NULL,
    rate DECIMAL NOT NULL,
    rate_for_one DECIMAL NOT NULL,
    rate_date_id INTEGER REFERENCES rate_date(id),
    currency_id INTEGER REFERENCES  currency(id));