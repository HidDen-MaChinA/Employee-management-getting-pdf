package com.web.learningBackEnd.Model.request;

import com.web.learningBackEnd.Controller.EmployeeController;
import com.web.learningBackEnd.Model.entity.db_test.Employee;
import com.web.learningBackEnd.Model.entity.db_test.PhoneNumber;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class RequestedEmployee {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String photo;
    private Integer calculateAge(Date birthDate, LocalDate currentDate, EmployeeController.Year year){
        if(year == EmployeeController.Year.BIRTHDAY || year==null){
            if ((birthDate != null) && (currentDate != null)) {
                return Period.between(birthDate.toLocalDate(), currentDate).getYears();
            }else{
                return null;
            }
        }
        else {
            Integer ok = currentDate.getYear() - birthDate.toLocalDate().getYear();
            System.out.println("birthDate is "+birthDate.getYear());
            System.out.println("CUrrent Date is "+currentDate.getYear());
            System.out.println(ok);
            return  ok;
        }
    }
    private int bruSalary;
    private String matricule;
    private int age;
    private Employee.SEX sex;
    private String address;
    private List<PhoneNumber> phoneNumberList;
    private String emailPerso;
    private String emailPro;
    private Date date_entre;
    private Date date_sortie;
    private String cinNumber;
    private String cinCreationDate;
    private String cnaps;
    private EmployeeController.Year year;


    public RequestedEmployee(String firstName, String lastName, Date birthDate, String photo, int bruSalary, String matricule, int age, Employee.SEX sex, String address, List<PhoneNumber> phoneNumberList, String emailPerso, String emailPro, Date date_entre, Date date_sortie, String cinNumber, String cinCreationDate, String cnaps, EmployeeController.Year year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.photo = photo;
        this.bruSalary = bruSalary;
        this.matricule = matricule;
        this.age = calculateAge(this.birthDate,LocalDate.now(),year);
        this.sex = sex;
        this.address = address;
        this.phoneNumberList = phoneNumberList;
        this.emailPerso = emailPerso;
        this.emailPro = emailPro;
        this.date_entre = date_entre;
        this.date_sortie = date_sortie;
        this.cinNumber = cinNumber;
        this.cinCreationDate = cinCreationDate;
        this.cnaps = cnaps;
    }
}
