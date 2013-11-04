--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.10
-- Dumped by pg_dump version 9.1.10
-- Started on 2013-11-04 20:28:40 MSK

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 166 (class 3079 OID 11679)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1914 (class 0 OID 0)
-- Dependencies: 166
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 178 (class 1255 OID 16471)
-- Dependencies: 5 501
-- Name: level1_receive_trigger(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION level1_receive_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

    BEGIN

        -- Work out the increment/decrement amount(s).
        IF (TG_OP = 'DELETE') THEN


        ELSIF (TG_OP = 'UPDATE') THEN
		INSERT INTO level1(instrument,date,last_time, last_price, last_size,last_price_delta,bid,bid_size,ask,ask_size) 
		 VALUES (NEW.instrument,NEW.date,NEW.last_time, NEW.last_price, NEW.last_size,NEW.last_price_delta,NEW.bid,NEW.bid_size,NEW.ask,NEW.ask_size);
		 return NEW;

        ELSIF (TG_OP = 'INSERT') THEN
		INSERT INTO level1(instrument,date,last_time, last_price, last_size,last_price_delta,bid,bid_size,ask,ask_size) 
		 VALUES (NEW.instrument,NEW.date,NEW.last_time, NEW.last_price, NEW.last_size,NEW.last_price_delta,NEW.bid,NEW.bid_size,NEW.ask,NEW.ask_size);
		 return NEW;

        END IF;


        RETURN NULL;

    END;
$$;


ALTER FUNCTION public.level1_receive_trigger() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 164 (class 1259 OID 16481)
-- Dependencies: 5
-- Name: instrument; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE instrument (
    id integer NOT NULL,
    name character varying,
    code character varying
);


ALTER TABLE public.instrument OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 16484)
-- Dependencies: 164 5
-- Name: instrument_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE instrument_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instrument_id_seq OWNER TO postgres;

--
-- TOC entry 1915 (class 0 OID 0)
-- Dependencies: 165
-- Name: instrument_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE instrument_id_seq OWNED BY instrument.id;


--
-- TOC entry 162 (class 1259 OID 16457)
-- Dependencies: 5
-- Name: level1; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE level1 (
    id integer NOT NULL,
    instrument character varying,
    date timestamp without time zone,
    last_time time without time zone,
    last_price double precision,
    last_size integer,
    last_price_delta real,
    bid double precision,
    bid_size integer,
    ask integer,
    ask_size integer,
    instrument_id integer
);


ALTER TABLE public.level1 OWNER TO postgres;

--
-- TOC entry 161 (class 1259 OID 16455)
-- Dependencies: 5 162
-- Name: level1_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE level1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.level1_id_seq OWNER TO postgres;

--
-- TOC entry 1916 (class 0 OID 0)
-- Dependencies: 161
-- Name: level1_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE level1_id_seq OWNED BY level1.id;


--
-- TOC entry 163 (class 1259 OID 16475)
-- Dependencies: 1906 5
-- Name: level1_receive_view; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW level1_receive_view AS
    SELECT level1.id, level1.instrument, level1.date, level1.last_time, level1.last_price, level1.last_size, level1.last_price_delta, level1.bid, level1.bid_size, level1.ask, level1.ask_size FROM level1;


ALTER TABLE public.level1_receive_view OWNER TO postgres;

--
-- TOC entry 1798 (class 2604 OID 16460)
-- Dependencies: 162 161 162
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level1 ALTER COLUMN id SET DEFAULT nextval('level1_id_seq'::regclass);


--
-- TOC entry 1802 (class 2606 OID 16491)
-- Dependencies: 164 164 1908
-- Name: instrument_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instrument
    ADD CONSTRAINT instrument_pk PRIMARY KEY (id);


--
-- TOC entry 1800 (class 2606 OID 16474)
-- Dependencies: 162 162 1908
-- Name: level1_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY level1
    ADD CONSTRAINT level1_pk PRIMARY KEY (id);


--
-- TOC entry 1804 (class 2620 OID 16479)
-- Dependencies: 163 178 1908
-- Name: level1_receive_trigger; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER level1_receive_trigger INSTEAD OF INSERT OR DELETE OR UPDATE ON level1_receive_view FOR EACH ROW EXECUTE PROCEDURE level1_receive_trigger();


--
-- TOC entry 1803 (class 2606 OID 16495)
-- Dependencies: 1801 164 162 1908
-- Name: level1_instrument_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level1
    ADD CONSTRAINT level1_instrument_id_fk FOREIGN KEY (instrument_id) REFERENCES instrument(id);


--
-- TOC entry 1913 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-11-04 20:28:40 MSK

--
-- PostgreSQL database dump complete
--

