package lk.himash.employeeservice.DtoToModel;

import lk.himash.employeeservice.dto.EmployeeMasterDto;
import lk.himash.employeeservice.model.EmployeeMaster;

public class DtoConvertor {

    public static EmployeeMaster toEmpMaEntity(EmployeeMasterDto empMaDto) {
        EmployeeMaster empMa = new EmployeeMaster();
        empMa.setEmp_ID(empMaDto.getEmpID());
        empMa.setEmp_First_Name(empMaDto.getFname());
        empMa.setEmp_Last_Name(empMaDto.getLname());
        empMa.setEmp_Username(empMaDto.getUserName());
        empMa.setEmp_Password(empMaDto.getPassword());
        empMa.setEmp_Password_Enc(empMaDto.getPassword_enc());
        empMa.setEmp_Email(empMaDto.getEmail());
        return empMa;
    }
}
