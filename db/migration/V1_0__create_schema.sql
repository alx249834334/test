--CREATE EXTENSION IF NOT EXISTS "uuid-ossp";--выполнить из под super user

--drop table campaign;

CREATE TABLE campaign (
  uuid default random_uuid(),
  name VARCHAR(64) NOT NULL,
  status VARCHAR(64),
  CONSTRAINT pkey_campaign PRIMARY KEY ( id )
);

--drop table scenario;

CREATE TABLE scenario (
  id uuid NOT NULL DEFAULT uuid_generate_v4(),
  name VARCHAR(64) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  campaign_id uuid REFERENCES campaign (id),
  CONSTRAINT pkey_scenario PRIMARY KEY ( id )
);