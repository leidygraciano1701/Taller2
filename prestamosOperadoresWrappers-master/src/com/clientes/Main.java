package com.clientes;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import com.clases.BeneficiosCovid19;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
	// write your code her
    	
        /**
         * Crear 2 lista de beneficios para clientes Lista 1 y Lista 2 por ejemplo
         * Ejemplo:
         * id:12121
         * nombre: Beneficiados que perdieron su trabajo por COVID19
         * valorSubsidio: 150000
         *
         * Ejemplo:
         * id:895656
         * Nombre: Beneficios para persona tercera edad dagnificados COVID
         * valorSubsidio:200000
         */
    	
    	try {
    	
	    	Scanner in =  new Scanner(System.in);
	    	
	    	ArrayList<BeneficiosCovid19> arrayBeneEmpleados = new ArrayList();
	    	ArrayList<BeneficiosCovid19> arrayBeneEmpresas = new ArrayList();
	    
	    	
			System.out.println("Ingrese numero de beneficios para los empleados por Covid: ");
			int sizeEmple = in.nextInt();
			
			for (int i = 0; i < sizeEmple; i++) {
				
				BeneficiosCovid19 beneficiosEmplea = new BeneficiosCovid19();
				
				beneficiosEmplea.setId(getIdBeneficio());
				
				System.out.println("Ingrese nombre beneficio: ");
				String nombre = in.next();
				beneficiosEmplea.setNombre(nombre);
				
				System.out.println("Ingrese valor del subsidio: ");
				Float valor = in.nextFloat();
				beneficiosEmplea.setValorSubsidio(valor);
				
				arrayBeneEmpleados.add(beneficiosEmplea);
			}
			
			System.out.println("Ingrese numero de beneficios para las Empresas por Covid: ");
			int sizeEmpre = in.nextInt();
			
			for (int i = 0; i < sizeEmpre; i++) {
				
				BeneficiosCovid19 beneficiosEmpre = new BeneficiosCovid19();
				
				beneficiosEmpre.setId(getIdBeneficio());
				
				System.out.println("Ingrese nombre beneficio: ");
				String nombre = in.next();
				beneficiosEmpre.setNombre(nombre);
				
				System.out.println("Ingrese valor del subsidio: ");
				Float valor = in.nextFloat();
				beneficiosEmpre.setValorSubsidio(valor);
				
				arrayBeneEmpresas.add(beneficiosEmpre);
				}	
			
	    	Comparacion(arrayBeneEmpleados, arrayBeneEmpresas);
    	
    		}catch(InputMismatchException e) {
    			System.out.println("Error Valor Ingresado incorrecto: " +e.getMessage());
    	}
    	
    }

    /**
    * Implementa un metodo que entregue un reporte de comparacion de las 2 listas este metodo solo imprimira regiostros
    * Cuando un metodo no retorna un tipo de datos se trabaja con la palabra clave VOID
    * Abarcar los operadores terniarios para condiciones logicas
    * Operadores logicos
    * Operacionres aritmeticos
    **/

    private static void Comparacion(ArrayList<BeneficiosCovid19> empleados, ArrayList<BeneficiosCovid19> empresas) {
    	
    	int maxEmple = 0;
    	int maxEmpre = 0;
    	int indEmple = 0;
    	int indEmpre = 0;
    	BeneficiosCovid19 beneficios = new BeneficiosCovid19();
    	
    	if (empleados.size()>empresas.size()) {
    		System.out.println("Los beneficios para Empleados tiene mas subsidios que beneficios para Empresas");
    	}
    	else if(empresas.size()>empleados.size()){
    		System.out.println("Los beneficios para Empresas tiene mas subsidios que beneficios para Empleados");
    	}
    	else {
    		System.out.println("Los beneficios para Empresas y Empleados tienen iguales subsidios");
    	}
    	
    			
      	for(int i = 0; i < empleados.size(); i ++) {
    		
    		int valorSub = empleados.get(i).getValorSubsidio().intValue();
    		Float mayor = beneficios.getMejorbeneficios(maxEmple, valorSub);
    		if (mayor != maxEmple) {
    			indEmple = i;
    		}

    		maxEmple = mayor.intValue();
    		
    	}
      	
      	System.out.println("El maximo valor de subsidio para empleados es: " +maxEmple);
      	System.out.println("Con id " +empleados.get(indEmple).getId());
    	System.out.println("nombre " +empleados.get(indEmple).getNombre());
    	
 
      	for(int i = 0; i < empresas.size(); i ++) {
    		
    		int valorSub = empresas.get(i).getValorSubsidio().intValue();
    		Float mayor = beneficios.getMejorbeneficios(maxEmpre, valorSub);
    		if (mayor != maxEmpre) {
    			indEmpre = i;
    		}
    		maxEmpre = mayor.intValue();
    		
    	}
      	
    	System.out.println("El maximo valor de subsidio para Empresas es: " + maxEmpre);
      	System.out.println("Con id " +empresas.get(indEmpre).getId());
    	System.out.println("nombre " +empresas.get(indEmpre).getNombre());
    	
    	Float MayorBene = beneficios.getMejorbeneficios(maxEmple, maxEmpre);
    	if (MayorBene == maxEmple) {

    		System.out.println("El maximo subsidio se encuentra en los beneficios para empleados y es: "+ maxEmple);
          	System.out.println("Con id " +empleados.get(indEmple).getId());
        	System.out.println("nombre " +empleados.get(indEmple).getNombre());
    		
    	}
    	else {
    		System.out.println("El maximo subsidio se encuentra en los beneficios para empresas y es: "+ maxEmpre);
          	System.out.println("Con id " +empresas.get(indEmpre).getId());
        	System.out.println("nombre " +empresas.get(indEmpre).getNombre());
    	}

    }


    //Implementa un metodo que te entregue un numero aletorio para el ide de los beneficios usar el wrapper de Integer
    private static String getIdBeneficio(){
        //La Clase Math tiene varios metodos que te ayudaran
    	int numero = (int) (Math.random() * 100) + 1;
    	String id = String.valueOf(numero);
        return id;
    }
}
