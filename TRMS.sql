create schema if not exists TRMS authorization dezmartin;
set search_path to TRMS


create table Employee(
"empID" serial primary key,
"firstName" varchar(35),
"lastName" varchar(35),
"address" varchar(55),
"email" varchar(35),
"phone" varchar(35),
"userName" varchar(35),
"passWord" varchar(35),
"empType" varchar(35)
);


create table Events (
"eventID" serial primary key,
"eventName" varchar(35),
"coverage" int
);

create table GradeFormat (
"gradeID" serial primary key,
"gradeType" varchar(35),
"passingGrade" int
);

select * from gradeformat;

insert into gradeformat ("gradeType", "passingGrade") values ('grade', 70);

insert into gradeformat ("gradeType", "passingGrade") values ('presentation', 100);

create table Form(
"formID" serial primary key,
"empID" int,
FOREIGN KEY ("empID") REFERENCES
    Employee("empID") on delete cascade,
"eventDate" DATE not null,
"reqDate" DATE not null,
"location" varchar(55),
"reqAmount" int,
"eventDescription" varchar(55),
"staus" varchar(55),
"eventID" int,
FOREIGN KEY ("eventID") REFERENCES
    Events("eventID") on delete cascade,
"gradeID" int,
FOREIGN KEY ("gradeID") REFERENCES
    GradeFormat("gradeID") on delete cascade,
"finalGrade" int
);

select * from events;

INSERT INTO events ("eventName", "coverage") VALUES ('university course', 80);
INSERT INTO events ("eventName", "coverage") VALUES ('seminar', 60);
INSERT INTO events ("eventName", "coverage")  VALUES ('certification preparation', 75);
INSERT INTO events ("eventName", "coverage") VALUES ('certification', 100);
INSERT INTO events ("eventName", "coverage") VALUES ('technical training', 90);
INSERT INTO events ("eventName", "coverage") VALUES ('other', 30);