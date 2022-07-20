package org.pruebatecnica.calculos;

import org.pruebatecnica.constantes.ConstantesDescuentos;

public class Pagos {
	
	public Pagos() {
		super();
	}
	
	public Double salarioNetoPlanilla(Double salario) {
		Double isss = salario * ConstantesDescuentos.ISSS;
		Double afp = salario * ConstantesDescuentos.AFP;
		Double renta = this.cancularRenta(salario);
		
		Double descuentos = isss + afp + renta;
		Double salarioNeto = salario - descuentos;
		
		return salarioNeto;
	}
	
	public Double salarioNetoServicioProfesional(Double salario) {
		Double renta = 0.10;
		Double salarioNeto = salario - renta;
		
		return salarioNeto;
	}
	
	private Double cancularRenta(Double salario) {
		Double renta = 0.0;
		
		if (salario >= ConstantesDescuentos.INICIO_TRAMO_1 && salario <= ConstantesDescuentos.FINAL_TRAMO_1) {
			renta = salario * 0.0;
		} else if (salario >= ConstantesDescuentos.INICIO_TRAMO_2 && salario <= ConstantesDescuentos.FINAL_TRAMO_2 ) {
			renta = salario * 0.10;
		} else if (salario >= ConstantesDescuentos.INICIO_TRAMO_3 && salario <= ConstantesDescuentos.FINAL_TRAMO_3) {
			renta = salario * 0.20;
		} else if (salario >= ConstantesDescuentos.INICIO_TRAMO_4) {
			renta = salario * 0.30;
		}
		
		return renta;
	}
	
}
