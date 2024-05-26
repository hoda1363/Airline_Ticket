create table person(
    id number primary key ,
    name nvarchar2(30),
    family nvarchar2(30),
    gender varchar2(6),
    birth_date date,
    city varchar2(20),
    algo number(1),
    se number(1),
    ee number(1)
);
commit ;

create sequence person_seq  start with 1 increment by 1;
create table flight(
    id number primary key ,
    name nvarchar2 (30) ,
    flightNumber nvarchar2(6),
    companyName nvarchar2(30) ,
    startTime time ,
    endTime time,
    plane nvarchar2(30) );
commit ;

create sequence flight_seq start with 1 increment by 1;
create table plane(
 name nvarchar2(30),
 Airline  nvarchar2(20),
 flightNumber nvarchar2(20),
 aircraftType nvarchar2(6),
 rout varchar2 (6),
 capacity number);
 commit ;
create sequence plane_seq start with 1 increment by 1;

create table ticket(
 dateTime timestamp,
 source varchar2(20),
 destination varchar2(20),
 duration number,
 confirm varchar(6),
 Flight nvarchar2(30));
 commit ;
create sequence ticket_seq start with 1 increment by 1;



