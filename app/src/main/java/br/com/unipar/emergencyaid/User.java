package br.com.unipar.emergencyaid;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class User {

    public String cpf;
    public Date birthDate;
    public int monthlyIncome;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }
    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }


    public String getDate(Date birthDate) {
        Calendar date = new GregorianCalendar();
        int day  = date.get(Calendar.DAY_OF_MONTH) + 20;
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        if (day > 31) {
            int dayRest = day - 31;
            day = 0;
            day  = day + dayRest;
            month = month + 1;
        }
        if (month > 12) {
            int monthRest = month - 12;
            month = 0;
            month = month + monthRest;
            year = year + 1;
        }
        String payday = day + "/" + month + "/" + year;
        return  payday;
    }

    public int getBalance(int value) {
        int balance = (value * 70) / 100;
        if(balance >= 475){
            balance = 475;
        }
        return balance;
    }

    public int getAge(Date birthDate) {
        Calendar date = new GregorianCalendar();
        Calendar currently = Calendar.getInstance();
        date.setTime(birthDate);
        int age = currently.get(Calendar.YEAR) - date.get(Calendar.YEAR);
        date.add(Calendar.YEAR, age);
        return age;
    }
}
