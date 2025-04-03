SELECT s.StudentName, c.CourseName, e.EnrollmentDate 
	FROM Students s
	LEFT JOIN Enrollments e ON s.StudentID = e.StudentID
	LEFT JOIN Courses c ON e.CourseID = c.CourseID;