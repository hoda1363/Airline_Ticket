create table person_tbl
(
    id            number primary key,
    name          nvarchar2(30),
    family        nvarchar2(30),
    national_Id   char(11),
    birth_date    timestamp);
create sequence person_seq start with 1 increment by 1;


create table user_tbl
(
    id            number primary key,
    name          nvarchar2(30) unique ,
    family        nvarchar2(30),
    enable number(1)
create sequence user_seq start with 1 increment by 1;




create table plane
(
    ID          number primary key ,
    name         nvarchar2(30),
    Airline      nvarchar2(20),
    flightNumber nvarchar2(20),
    aircraftType nvarchar2(20),
    route        varchar2(50),
    capacity     number
);

create sequence plane_seq start with 1 increment by 1;



create table flight
(
    id           number primary key,
    name         nvarchar2(30),
    flight_Number nvarchar2(6),
    company_Name  nvarchar2(30),
    start_Time    TIMESTAMP,
    end_Time      TIMESTAMP,
    plane_id      references plane
);
create sequence flight_seq start with 1 increment by 1;


create table ticket
(
    id          number primary key ,
    dateTime    timestamp,
    source      varchar2(20),
    destination varchar2(20),
    duration    number,
    confirm     number(1),
    Flight_id   references flight,
    Airline     nvarchar2(8)
);



create sequence ticket_seq start with 1 increment by 1;



