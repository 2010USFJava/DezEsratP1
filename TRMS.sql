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