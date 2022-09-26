/*
 * Realiza un programa que almacene una lista de objetos de la clase VENTA
  cuyos atributos son 2: el nombre del Mes y Venta de Automóviles del mes.
  Se debe mostrar un menú donde se ofrezcan las siguientes opciones:
  1. Introducir las ventas de automóviles de cada uno de los meses del año.
  2. Mostrar las ventas introducidas en el punto anterior.
  3. Que muestre la suma total de ventas de automóviles del año.
  4. Que muestre las ventas totales de los meses que empiezan por la letra A
  (Utiliza el método correspondiente de la clase String).
  5. Que muestre el nombre del mes con más ventas.
  6. Salir del programa.
  Se debe controlar que el usuario elija una opción del menú entre el 1 y el 6.
  Hasta que el usuario no pulse 6 no se puede salir del programa.
 */
package ejercicioventa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ivan Bustos
 */
public class Venta {

  /**
   * @param args the command line arguments
   */
      String nombreMes;
      Integer numeroVentas;
    
public Venta() {
    establecerNombreMes();
    establecerNumVentas();
    }

public void establecerNombreMes() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Nombre del mes: ");
    nombreMes = entrada.nextLine();
    }
    public String devolverNombreMes() {
    return nombreMes;
    }
    public Integer devolverNumVentas() {
    return numeroVentas;
}
    public void establecerNumVentas() {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Numero de ventas producidas en " + nombreMes + ": ");
    numeroVentas = entrada.nextInt();
    }
    
    public static void mostrarMenu(ArrayList <Venta> lista) {
    Integer opcion;
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ventas de coches: ");
    
    do {
        System.out.println("1. Introducir las ventas de automóviles de cada uno de los meses del año");
        System.out.println("2. Mostrar las ventas introducidas en el ítem anterior");
        System.out.println("3. Mostrar suma total de ventas anuales");
        System.out.println("4. Mostrar las ventas totales de los meses que comienzan con la letra A");
        System.out.println("5. Mostrar el nombre del mes con más ventas");
        System.out.println("6. Salir");
        opcion = entrada.nextInt();
    
        switch(opcion) {
        case 1:
        rellenarVentas(lista);
        break;
        
        case 2:
        mostrarVentas(lista);
        break;
        
        case 3:
        mostrarSumaVentas(lista);
        break;
        
        case 4:
        mostrarSumaMesesLetraA(lista);
        break;
        
        case 5:
        mesMasVentas(lista);
        break;
        
        case 6:
        System.out.println("Saliendo del programa…");
        break;
        default:
            
            System.out.println("Ingrese un valor entre 0 a 6 ");
        break;
        }
        
        } while (opcion != 6);
        }
    
  public static void rellenarVentas(ArrayList <Venta> lista) {
        Scanner entrada = new Scanner(System.in);
        String respuesta;
        
        do {
        System.out.println("Datos del mes");
        lista.add(new Venta());
            System.out.println("¿Desea añadir otro mes? (Si/No)");
        respuesta = entrada.nextLine();
        } while (respuesta.equalsIgnoreCase("SI"));
        System.out.println(lista);
        }
  
  public static void mostrarVentas(ArrayList <Venta> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Para el mes de " + lista.get(i).devolverNombreMes() +
                            " se vendieron: " + lista.get(i).devolverNumVentas());
        }
  }
  
  public static void mostrarSumaVentas(ArrayList <Venta> lista) {
        Integer suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma = suma + lista.get(i).devolverNumVentas();
        }
            System.out.println("Para el año se vendieron un total de: “ + suma + “ vehículos");
  }
        
  public static void mostrarSumaMesesLetraA(ArrayList <Venta> lista) {
        Integer suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).devolverNombreMes().charAt(0) == 'A') {
            suma = suma + lista.get(i).devolverNumVentas();
            }
        }
            System.out.println("Para los meses que empiezan con A se vendio un total de: " +
                                suma + " automóviles");
  }
  
  public static void mesMasVentas(ArrayList <Venta> lista) {
        Integer ventas = lista.get(0).numeroVentas;
        for (int i = 0; i < lista.size(); i++) {
            if (ventas < lista.get(i).devolverNumVentas()) {
                ventas = lista.get(i).devolverNumVentas();
            }
        }
            System.out.println("Mes o meses con más ventas de coches");
        
        for (int i = 0; i < lista.size(); i++) {
            if (ventas == lista.get(i).devolverNumVentas()) {
                System.out.println("El mes de " + lista.get(i).devolverNombreMes()
                                    + " se vendieron un total de " + lista.get(i).devolverNumVentas() 
                                    + " automóviles");
            }   
        }
  }
  public static void main(String[] args) {
    // TODO code application logic here
    Scanner entrada = new Scanner(System.in);
    ArrayList <Venta> lista = new ArrayList <>();
    mostrarMenu(lista);
  }
  
}
