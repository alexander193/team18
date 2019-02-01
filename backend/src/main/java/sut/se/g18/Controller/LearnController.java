package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.g18.Entity.CourseTypeEntity;
import sut.se.g18.Entity.SkillEntity;
import sut.se.g18.Repository.CourseTypeRepository;
import sut.se.g18.Repository.SkillRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LearnController {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public  LearnController(SkillRepository skillRepository, CourseTypeRepository courseTypeRepository){
        this.skillRepository = skillRepository;
        this.courseTypeRepository = courseTypeRepository;
    }

    @GetMapping(path ="/skill", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SkillEntity> AllSkill(){
        return skillRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/courseType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseTypeEntity> AllCourseType(){
        return courseTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}
