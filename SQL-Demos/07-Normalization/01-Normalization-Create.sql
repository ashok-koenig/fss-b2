--Unnormalized table - StudentID, StudentName, CourseID, CourseName, Instructor, Phone, Semester
CREATE TABLE Students (
	StudentID INT PRIMARY KEY,
	StudentName VARCHAR(100) NOT NULL,
	Email VARCHAR(100) UNIQUE NOT NULL
	);

CREATE TABLE Courses (
	CourseID INT PRIMARY KEY,
	CourseName VARCHAR(100) NOT NULL,
	Credits INT CHECK (Credits >0)
	);

CREATE TABLE Enrollments (
	EnrollmentID INT PRIMARY KEY,
	StudentID INT,
	CourseID INT,
	EnrollmentDate DATE NOT NULL,
	FOREIGN KEY (StudentID) REFERENCES Students(StudentID) ON DELETE CASCADE,
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseID) ON DELETE CASCADE
	);
	
CREATE TABLE Professors (
	ProfessorID INT PRIMARY KEY,
	ProfessorName VARCHAR(100) NOT NULL,
	ProfessorPhone VARCHAR(20) NOT NULL,
	);

CREATE TABLE CourseAssignments (
	AssignmentID INT PRIMARY KEY,
	ProfessorID INT,
	CourseID INT,
	FOREIGN KEY (ProfessorID) REFERENCES Professors(ProfessorID),
	FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
	);