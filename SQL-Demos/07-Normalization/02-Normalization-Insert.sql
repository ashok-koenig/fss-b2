INSERT INTO Students (StudentID, StudentName, Email) VALUES
	(1, 'Johnson', 'johnson@email.com'),
	(2, 'Smith', 'smith@email.com'),
	(3, 'Bob', 'bob@email.com');

INSERT INTO Courses(CourseID, CourseName, Credits) VALUES
	(101, 'Database Systems', 4),
	(102, 'Spring Boot', 5);

INSERT INTO Enrollments (EnrollmentID, StudentID, CourseID, EnrollmentDate) VALUES
	(1, 1, 101, '2025-03-10'),
	(2, 2, 102, '2025-04-01');

INSERT INTO Professors (ProfessorID, ProfessorName, ProfessorPhone) VALUES
	(1, 'Dr. Miller', '0989 7777'),
	(2, 'Dr. Peter', '08788 6883');

INSERT INTO CourseAssignments (AssignmentID, ProfessorID, CourseID) VALUES
	(1, 1, 101),
	(2, 2, 102);