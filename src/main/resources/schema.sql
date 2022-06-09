drop table if exists scenario;
drop table if exists campaign;

CREATE TABLE campaign (
  id uuid default random_uuid() primary key,
  name VARCHAR(64) NOT NULL,
  status VARCHAR(64)
);

CREATE TABLE scenario (
  id uuid default random_uuid() primary key,
  name VARCHAR(64) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  campaign_id uuid REFERENCES campaign (id)
);