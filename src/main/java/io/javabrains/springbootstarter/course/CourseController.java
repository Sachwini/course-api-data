package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable("id") String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicsId}/courses/{id}")
    public Course getCourse(@PathVariable("id") String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
    public void  addCourse(@RequestBody Course course,@PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{id}")
    public void updateCourse(@PathVariable("id") String id, @RequestBody Course course,@PathVariable("id") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{id}")
    public void updateCourse(@PathVariable("id") String id){
        courseService.deleteCourse(id);
    }
}
