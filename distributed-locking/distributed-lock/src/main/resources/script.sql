CREATE TABLE public.int_lock (
	lock_key varchar NOT NULL,
	region varchar NOT NULL,
	client_id varchar NULL,
	created_date timestamp NULL,
	CONSTRAINT int_lock_pk PRIMARY KEY (lock_key, region)
);

CREATE TABLE public.account (
	id int4 NULL,
	balance int4 NULL
);
