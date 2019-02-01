package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.g18.Entity.CourseEntity;
import sut.se.g18.Entity.CourseTypeEntity;
import sut.se.g18.Entity.SkillEntity;
import sut.se.g18.Repository.CourseRepository;
import sut.se.g18.Repository.CourseTypeRepository;
import sut.se.g18.Repository.SkillRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LearnedController {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;
    @Autowired
    private CourseRepository courseRepository;

    public LearnedController(SkillRepository skillRepository, CourseTypeRepository courseTypeRepository,
                             CourseRepository courseRepository){
        this.skillRepository = skillRepository;
        this.courseTypeRepository = courseTypeRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping(path ="/skill", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SkillEntity> AllSkill(){
        return skillRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/courseType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseTypeEntity> AllCourseType(){
        return courseTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseEntity> AllCourse(){
        return courseRepository.findAll().stream().collect(Collectors.toList());
    }
}
