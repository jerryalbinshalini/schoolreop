package com.training.school.controller;

import com.training.school.model.Student;
import com.training.school.model.TeachingStaff;
import com.training.school.repository.TeachingStaffRepository;
import com.training.school.service.TeachingStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path="/api/teachingstaff")
public class TeachingStaffController {
//   @Autowired
//    TeachingStaffRepository teachingStaffRepository;


    @Autowired
    TeachingStaffService teachingStatffService;


//    @GetMapping("/teachingstaff/{id}")
//    public ResponseEntity<TeachingStaff> getteachingstaffById(@PathVariable("id") long id) {
//        Optional<TeachingStaff> teachingStaffData = teachingStaffRepository.findById(id);
//
//        if (teachingStaffData.isPresent()) {
//            return new ResponseEntity<>(teachingStaffData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping(value="/insert")
//    public ResponseEntity <TeachingStaff> createdata(@RequestBody TeachingStaff teachingStaff){
//     try {
//       TeachingStaff ouputdata = teachingStaffRepository
//                .save(new TeachingStaff(teachingStaff.getStaffName(), teachingStaff.getSubjectName(), teachingStaff.getStaffExperience(),teachingStaff.getStaffDescription()));
//        return new ResponseEntity<>(ouputdata, HttpStatus.CREATED);
//    } catch (Exception e) {
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//
//    }
//
//    @PutMapping(value="/edit")
//    public @ResponseBody String editTeachingStaff(@RequestBody TeachingStaff newData) {
//       TeachingStaff oldData = teachingStaffRepository.findById(newData.getId()).get();
//        oldData.setStaffName(newData.getStaffName());
//        oldData.setSubjectName(newData.getSubjectName());
//        oldData.setStaffExperience(newData.getStaffExperience());
//        oldData.setStaffDescription(newData.getStaffDescription());
//       teachingStaffRepository.save(oldData);
//        return "data edited successfully";
//    }
//
//
//    @DeleteMapping(value="/deleteall")
//    public @ResponseBody String deleteAll() {
//       teachingStaffRepository.deleteAll();
//        return "All Records are Deleted Successfully";
//    }
//    @DeleteMapping(value="/deletebyid/{Id}")
//    public @ResponseBody String deleteById(@PathVariable Long Id) {
//        teachingStaffRepository.deleteById(Id);
//        return "Record Deleted Successfully";
//    }
//    @GetMapping(value="/count")
//    public @ResponseBody Long getCount() {
//        Long count= teachingStaffRepository.count();
//        return count;
//    }

    @GetMapping(value = "/all")
    public @ResponseBody List<TeachingStaff> getTeachingStaff(){
        return teachingStatffService.getAllTeachingstaff();
    }

    @PostMapping(value = "/create")
    public @ResponseBody String createStaff(@RequestBody TeachingStaff teachingStaff){
        teachingStatffService.createdata(teachingStaff);
        return "TeachingStaff created successfully";
    }


    @PutMapping(value = "/edit/{id}")
    public @ResponseBody String editStaff(@PathVariable("id") Long id,@RequestBody TeachingStaff teachingStaff){
       return teachingStatffService.updateStaff(teachingStaff,id);
    }


}
