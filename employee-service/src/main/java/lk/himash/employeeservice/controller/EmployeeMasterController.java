package lk.himash.employeeservice.controller;

import lk.himash.employeeservice.DtoToModel.DtoConvertor;
import lk.himash.employeeservice.dto.EmployeeMasterDto;
import lk.himash.employeeservice.model.EmployeeMaster;
import lk.himash.employeeservice.service.EmployeeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeMasterController {

    @Autowired
    private EmployeeMasterService empMaService;

    @GetMapping("/v1/getEmps")
    public ResponseEntity<?> getEmployees() {
        return empMaService.getEmployees();
    }

    @PostMapping("/v1/createEmp")
    public ResponseEntity<?> saveEmp(@RequestBody EmployeeMasterDto empMaDto) {
        System.out.println("Start | saveEmp() method | EmployeeMasterController.class");
        System.out.println("Parameters --> Emp : " + empMaDto);
        ResponseEntity resp;
        try {
            EmployeeMaster emp = DtoConvertor.toEmpMaEntity(empMaDto);
            resp = empMaService.saveEmp(emp);
        }catch(Exception ex) {
            System.out.println("Exception found on | saveEmp() method | EmployeeMasterController.class");
            System.out.println(ex.getMessage());
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        System.out.println("Successfully create user");
        return resp;
    }

    @GetMapping("/v1/employee/{empID}")
    public ResponseEntity<?> getEmployeeDetails(@PathVariable int empID) {
        System.out.println("Start | getEmployeeDetails() method | EmployeeMasterController.class");
        System.out.println("Parameters --> empID : " + empID);
        ResponseEntity resp;
        try {
            resp = empMaService.getEmployeeDetails(empID);
        }catch(Exception ex) {
            System.out.println("Exception found on | getEmployeeDetails() method | EmployeeMasterController.class");
            System.out.println(ex.getMessage());
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        System.out.println("Successfully get employee details");
        return resp;
    }

    @DeleteMapping("/v1/deleteEmp/{empID}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int empID) {
        System.out.println("Start | deleteEmployee() method | EmployeeMasterController.class");
        System.out.println("Parameters --> empID : " + empID);
        ResponseEntity resp;
        try {
            resp = empMaService.deleteEmployee(empID);
        }catch(Exception ex) {
            System.out.println("Exception found on | deleteEmployee() method | EmployeeMasterController.class");
            System.out.println(ex.getMessage());
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        System.out.println("Successfully delete employee details");
        return resp;
    }

}
