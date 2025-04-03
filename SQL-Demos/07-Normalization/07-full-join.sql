SELECT c.CourseName, s.StudentName, p.ProfessorName 
	FROM Courses c
	FULL JOIN Enrollments e ON c.CourseID = e.CourseID
	FULL JOIN Students s ON e.StudentID = s.StudentID
	FULL JOIN CourseAssignments ca ON ca.CourseID = c.CourseID
	FULL JOIN Professors p ON ca.ProfessorID = p.ProfessorID