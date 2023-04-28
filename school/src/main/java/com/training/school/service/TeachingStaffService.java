package com.training.school.service;

import com.training.school.model.TeachingStaff;
import com.training.school.repository.TeachingStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TeachingStaffService {
    @Autowired
    private TeachingStaffRepository teachingStaffRepository;

    public  TeachingStaff createdata(TeachingStaff teachingStaff){
    if(teachingStaff.getStaffName()!=null && teachingStaff.getSubjectName()!=null){
        teachingStaff.setStaffDescription(teachingStaff.getStaffName()+"take"+teachingStaff.getSubjectName()+"subject");
    }
    else{
        System.out.println("Invalid Description");
    }
        teachingStaffRepository.save(teachingStaff);
    return teachingStaff;
    }

    public List<TeachingStaff> getAllTeachingstaff() {
       List<TeachingStaff> teachingStaff = teachingStaffRepository.findAll();
        return teachingStaff;
    }
   public String updateStaff(TeachingStaff teachingStaff,Long id){
        if(teachingStaffRepository.findById(id).isPresent()) {
            TeachingStaff olddata = teachingStaffRepository.findById(id).get();
            olddata.setStaffName(teachingStaff.getStaffName());
            olddata.setStaffExperience(teachingStaff.getStaffExperience());
            olddata.setStaffDescription(teachingStaff.getStaffDescription());
            teachingStaffRepository.save(olddata);
            return "Updated Successfully";
        }
        return "Updation Failed";
   }


}
