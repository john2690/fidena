create TABLE public.users (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    father_last_name VARCHAR NOT NULL,
    mother_last_name VARCHAR NOT NULL,
    age BIGINT,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);