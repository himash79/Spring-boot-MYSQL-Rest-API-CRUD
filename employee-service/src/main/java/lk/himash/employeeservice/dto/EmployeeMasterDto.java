package lk.himash.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMasterDto {

    private int empID;
    private String fname;
    private String lname;
    private String userName;
    private String password;
    private String password_enc;
    private String email;
}
