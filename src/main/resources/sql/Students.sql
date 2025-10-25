CREATE TABLE STUDENT (
	ID INT NOT NULL,
	NAME VARCHAR(64) NOT NULL,
	EMAIL VARCHAR(128) not null,
	PRIMARY KEY(ID),
	CONSTRAINT unique_email UNIQUE (EMAIL)
)

INSERT INTO [schemaName].student(Id, Name, Email) VALUES(1, 'Vamshi Krishna', 'vamshikrishna@testmail.com');
INSERT INTO [schemaName].student(Id, Name, Email) VALUES(2, 'Pranay', 'pranay@testmail.com');
INSERT INTO [schemaName].student(Id, Name, Email) VALUES(3, 'Raj Kumar', 'rajkumar@testmail.com');
INSERT INTO [schemaName].student(Id, Name, Email) VALUES(4, 'Sai Krishna', 'saikrishna@testmail.com');