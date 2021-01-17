DROP TABLE public.js_passport_offices;
DROP TABLE public.jc_register_offices;
DROP TABLE public.jc_country_structs;
DROP TABLE public.jc_streets;


CREATE TABLE public.jc_streets
(
    street_code integer NOT NULL,
    street_name text,
    PRIMARY KEY (street_code)
);

CREATE TABLE public.jc_country_structs
(
    area_id "char" NOT NULL,
    area_name text,
    PRIMARY KEY (area_id)
);

CREATE TABLE public.js_passport_offices
(
    p_office_id integer NOT NULL,
    p_office_are_id "char" NOT NULL,
    p_office_name text,
    PRIMARY KEY (p_office_id),
    FOREIGN KEY (p_office_are_id) REFERENCES public.jc_country_structs (area_id)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
);

CREATE TABLE public.jc_register_offices
(
    r_office_id integer NOT NULL,
    r_office_area_id "char" NOT NULL,
    r_office_name text,
    PRIMARY KEY (r_office_id),
    FOREIGN KEY (r_office_area_id) REFERENCES public.jc_country_structs (area_id)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
);
