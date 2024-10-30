package com.demo.Online_Learning_Systems.Service;

import java.util.List;

import com.demo.Online_Learning_Systems.Entities.Course;


public interface CourseService {
	public List<Course> getCourses();   //this will retrieve all courses
	public Course getCourse(long courseId);   //this will retrieve single course  
	public Course addCourse(Course course);    //this will add new course
	public Course updateCourse(Course course);   //update already existing course 
	public void deleteCourse(long parseLong);   //delete the course
}
