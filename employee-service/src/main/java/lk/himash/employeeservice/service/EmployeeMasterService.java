package lk.himash.employeeservice.service;

import lk.himash.employeeservice.model.EmployeeMaster;
import lk.himash.employeeservice.model.User;
import lk.himash.employeeservice.repository.EmployeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeMasterService {

    @Autowired
    private EmployeeMasterRepository empMasterRepo;

    public ResponseEntity<?> saveEmp(EmployeeMaster empMa) {
        BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
        EmployeeMaster savedUser;
        if(empMa.getEmp_Password_Enc().isEmpty()) {
            String enc_password = bCryptPasswordEncoder.encode(empMa.getEmp_Password());
            empMa.setEmp_Password_Enc(enc_password);
            savedUser = empMasterRepo.save(empMa);
            System.out.println("When user doesn't have encrypt password");
            System.out.println(empMa);
        } else {
            String enc_password = bCryptPasswordEncoder.encode(empMa.getEmp_Password_Enc());
            empMa.setEmp_Password_Enc(enc_password);
            savedUser = empMasterRepo.save(empMa);
            System.out.println("When user have encrypt password");
            System.out.println(empMa);
        }
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getEmployees() {
        List<EmployeeMaster> emps = empMasterRepo.findAll();
        return new ResponseEntity(emps, HttpStatus.OK);
    }

    public ResponseEntity<?> getEmployeeDetails(int empID) {
        System.out.println("Start | getEmployeeDetails() method | EmployeeMasterService.class|");
        System.out.println("Parameter --> empID : " + empID);
        Optional<EmployeeMaster> emp = Optional.of(new EmployeeMaster());
        try {
             emp = empMasterRepo.findById(empID);
        }catch(Exception ex) {
            System.out.println("Exception found on | getEmployeeDetails() method | EmployeeMasterService.class|");
            System.out.println(ex.getMessage());
            return new ResponseEntity(emp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(emp, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteEmployee(int empID) {
        System.out.println("Start | deleteEmployee() method | EmployeeMasterService.class|");
        System.out.println("Parameter --> empID : " + empID);
        try {
            empMasterRepo.deleteById(empID);
        }catch (Exception ex) {
            System.out.println("Exception found on | getEmployeeDetails() method | EmployeeMasterService.class|");
            System.out.println(ex.getMessage());
            return new ResponseEntity(empID, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Delete successfully with employee id " + empID, HttpStatus.OK);
    }

}
