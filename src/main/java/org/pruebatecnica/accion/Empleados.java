package org.pruebatecnica.accion;

import com.opensymphony.xwork2.ActionSupport;
import org.pruebatecnica.dao.*;
import org.pruebatecnica.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Empleados extends ActionSupport {

    private static final long SerialVersion = 424242342;
    ResultSet rs = null;
    Empleado emp = null;
    List<Empleado> empList = null;
    EmpleadosDAO empDao = new EmpleadosDAO();
    private boolean noData = false;

    @Override
    public String execute() throws Exception {
        try {
            empList = new ArrayList<Empleado>();
            rs = (ResultSet) empDao.obtenerTodos();
            int i = 0;
            if (rs != null){
                while(rs.next()){
                    i++;
                    emp = new Empleado();
                    emp.setId(i);
                    emp.setNombres(rs.getString("Nombres"));
                    emp.setApellidos(rs.getString("Apellidos"));
                    emp.setEdad(rs.getInt("Edad"));
                    emp.setSexo(rs.getBoolean("Sexo"));
                    emp.setServiciosProfesionales(rs.getBoolean("ServiciosProfesionales"));
                    emp.setSalario(rs.getDouble("Salario"));
                    empList.add(emp);
                }
            }
            if(i == 0 ) {
                noData = false;
            } else {
                noData = true;
            }
        }catch (Exception e){

        }
        return "REPORT";
    }

    public boolean isNoData(){
        return noData;
    }

    public void setNoData(boolean noData){
        this.noData = noData;
    }

    public List<Empleado> getBeanList(){
        return empList;
    }

    public void setEmpList(List<Empleado> empList) {
        this.empList = empList;
    }

}
