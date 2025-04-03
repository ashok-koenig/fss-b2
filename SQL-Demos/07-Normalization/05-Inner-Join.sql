SELECT p.ProfessorName, c.CourseName
	FROM Professors p
	JOIN CourseAssignments ca ON p.ProfessorID = ca.ProfessorID
	JOIN Courses c ON ca.CourseID = c.CourseID;