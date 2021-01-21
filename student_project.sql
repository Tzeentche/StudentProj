DROP TABLE public.jc_student_childs;
DROP TABLE public.jc_student_orders;
DROP TABLE public.jc_passport_offices;
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

CREATE TABLE public.jc_passport_offices
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

CREATE TABLE public.jc_student_orders (

student_order_id SERIAL,
student_order_status int not null,
student_order_date timestamp not null,
h_sur_name text NOT NULL,
h_given_name text NOT NULL,
h_patronymic text NOT NULL,
h_date_of_birth date NOT NULL,
h_passport_serial text NOT NULL,
h_passport_number text NOT NULL,
h_passport_date date NOT NULL,
h_passport_office_id integer NOT NULL,
h_post_index text,
h_street_code integer NOT NULL,
h_building text NOT NULL,
h_extention text,
h_apartment text,
w_sur_name text NOT NULL,
w_given_name text NOT NULL,
w_patronymic text NOT NULL,
w_date_of_birth date NOT NULL,
w_passport_serial text NOT NULL,
w_passport_number text NOT NULL,
w_passport_date date NOT NULL,
w_passport_office_id integer NOT NULL,
w_post_index text,
w_street_code integer NOT NULL,
w_building text NOT NULL,
w_extention text,
w_apartment text,
certificate_id integer NOT NULL,
register_office_id integer NOT NULL,
marriage_date date NOT NULL,
PRIMARY KEY (student_order_id),
FOREIGN KEY (h_street_code) REFERENCES public.jc_streets (street_code)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT,
FOREIGN KEY (w_street_code) REFERENCES public.jc_streets (street_code)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT,
FOREIGN KEY (register_office_id) REFERENCES public.jc_register_offices (r_office_id)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
);

CREATE TABLE public.jc_student_childs (

student_child_id SERIAL,
student_order_id integer NOT NULL,
c_sur_name text NOT NULL,
c_given_name text NOT NULL,
c_patronymic text NOT NULL,
c_date_of_birth date NOT NULL,
c_certificate_number text NOT NULL,
c_certificate_date date NOT NULL,
c_register_office_id integer NOT NULL,
c_post_index text,
c_street_code integer NOT NULL,
c_building text NOT NULL,
c_extention text,
c_apartment text,

PRIMARY KEY (student_child_id),
FOREIGN KEY (c_street_code) REFERENCES public.jc_streets (street_code)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT,
FOREIGN KEY (c_register_office_id) REFERENCES public.jc_register_offices (r_office_id)
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
);