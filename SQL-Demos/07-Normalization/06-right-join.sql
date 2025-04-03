SELECT p.ProfessorName, c.CourseName
	FROM Professors p
	RIGHT JOIN CourseAssignments ca ON p.ProfessorID = ca.ProfessorID
	RIGHT JOIN Courses c ON ca.CourseID = c.CourseID;