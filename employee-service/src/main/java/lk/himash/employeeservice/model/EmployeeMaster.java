package lk.himash.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_master")
@Entity
public class EmployeeMaster {

    @Id
    @Column(name = "Emp_ID")
    private int Emp_ID;

    @Column(name = "Emp_First_Name")
    private String Emp_First_Name;

    @Column(name = "Emp_Last_Name")
    private String Emp_Last_Name;

    @Column(name = "Emp_Username")
    private String Emp_Username;

    @Column(name = "Emp_Password")
    private String Emp_Password;

    @Column(name = "Emp_Password_Enc")
    private String Emp_Password_Enc;

    @Column(name = "Emp_Email")
    private String Emp_Email;

}
