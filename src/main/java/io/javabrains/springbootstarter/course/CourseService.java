package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Services are typically singleton*/
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;


public List<Course> getAllCourses(String topicId){
    List<Course> courses = new ArrayList<>();
    //return topics;
    courseRepository.findByTopicId("topicId")/*findAll basically gets all the instances from the table*/
            .forEach(courses::add);/*method reference ->> for each of the elements in the iterable calling the add method on the topics and passing the elements*/
//    for (Course course : courseRepository.findAll()) {
//        topics.add(course);
//    }
    return courses;
}

public Course getCourse(String id){
    //return courses.stream().filter(x->x.getId().equals(id)).findFirst().get();
    return courseRepository.findById(id).orElse(null);
}

public void addCourse(Course course){
   // courses.add(course);
    courseRepository.save(course);
}

    public void updateCourse(Course course) {
//        for (int i = 0; i <courses.size() ; i++) {
//            Topic t = courses.get(i);
//            if(t.getId().equals(id)){
//                courses.set(i,topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //courses.removeIf(t->t.getId().equals(id));// for a given courses if topics .getId equal to the given id, remove that course
        courseRepository.deleteById(id);
    }
}
