SELECT s.StudentName, c.CourseName, e.EnrollmentDate 
	FROM Students s
	JOIN Enrollments e ON s.StudentID = e.StudentID
	JOIN Courses c ON e.CourseID = c.CourseID;