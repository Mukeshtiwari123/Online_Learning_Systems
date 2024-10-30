package com.demo.Online_Learning_Systems.ServiceImpl;
import com.demo.Online_Learning_Systems.Service.CourseService;
import com.demo.Online_Learning_Systems.Entities.Course;
import com.demo.Online_Learning_Systems.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl  implements CourseService{

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		return courseRepository.findById(courseId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course courseDetails) {
	    Course existingCourse = courseRepository.findById(courseDetails.getId())
	            .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseDetails.getId()));

	    // Update fields of the course
	    existingCourse.setTitle(courseDetails.getTitle());
	    existingCourse.setDescription(courseDetails.getDescription());

	    // Update quizzes if provided in course details
	    if (courseDetails.getQuizzes() != null) {
	        existingCourse.getQuizzes().clear();
	        existingCourse.getQuizzes().addAll(courseDetails.getQuizzes());
	    }

	    // Update discussions if provided in course details
	    if (courseDetails.getDiscussions() != null) {
	        existingCourse.getDiscussions().clear();
	        existingCourse.getDiscussions().addAll(courseDetails.getDiscussions());
	    }

	    return courseRepository.save(existingCourse);
	}


	@Override
	public void deleteCourse(long courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

		courseRepository.delete(course);
	}
}

