create table person
(
    id         number primary key,
    name       nvarchar2(30),
    family     nvarchar2(30),
    gender     varchar2(6),
    birth_date date,
    city       varchar2(20)
);
create sequence person_seq start with 1 increment by 1;

create table plane
(
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
    flightNumber nvarchar2(6),
    companyName  nvarchar2(30),
    startTime    time,
    endTime      time,
    plane_id references plane
);
create sequence flight_seq start with 1 increment by 1;


create table ticket
(
    id number primary key ,
    dateTime    timestamp,
    source      varchar2(20),
    destination varchar2(20),
    duration    number,
    confirm     number(1),
    Flight_id   references flight
);
create sequence ticket_seq start with 1 increment by 1;



