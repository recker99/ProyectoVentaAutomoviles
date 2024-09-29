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

package proyectoventaautomoviles;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ivan Bustos
 */

public class Venta {

    String nombreMes;
    Integer numeroVentas;

    public Venta(String nombreMes, Integer numeroVentas) {
        this.nombreMes = nombreMes;
        this.numeroVentas = numeroVentas;
    }

    public String devolverNombreMes() {
        return nombreMes;
    }

    public Integer devolverNumVentas() {
        return numeroVentas;
    }

    public static void mostrarMenu(ArrayList<Venta> lista) {
        Integer opcion;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Ventas de coches:");
            System.out.println("1. Introducir las ventas de automóviles de cada uno de los meses del año");
            System.out.println("2. Mostrar las ventas introducidas en el ítem anterior");
            System.out.println("3. Mostrar suma total de ventas anuales");
            System.out.println("4. Mostrar las ventas totales de los meses que comienzan con la letra A");
            System.out.println("5. Mostrar el nombre del mes con más ventas");
            System.out.println("6. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
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
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese un valor entre 1 y 6.");
            }

        } while (opcion != 6);
    }

    public static void rellenarVentas(ArrayList<Venta> lista) {
        Scanner entrada = new Scanner(System.in);
        String respuesta;

        do {
            System.out.print("Nombre del mes: ");
            String nombreMes = entrada.nextLine();
            System.out.print("Numero de ventas producidas en " + nombreMes + ": ");
            Integer numeroVentas = entrada.nextInt();
            entrada.nextLine();  // Limpiar el buffer

            lista.add(new Venta(nombreMes, numeroVentas));

            System.out.println("¿Desea añadir otro mes? (Si/No)");
            respuesta = entrada.nextLine();

        } while (respuesta.equalsIgnoreCase("SI"));
    }

    public static void mostrarVentas(ArrayList<Venta> lista) {
        for (Venta venta : lista) {
            System.out.println("Para el mes de " + venta.devolverNombreMes() + " se vendieron: " + venta.devolverNumVentas() + " automóviles.");
        }
    }

    public static void mostrarSumaVentas(ArrayList<Venta> lista) {
        Integer suma = 0;
        for (Venta venta : lista) {
            suma += venta.devolverNumVentas();
        }
        System.out.println("Para el año se vendieron un total de: " + suma + " vehículos.");
    }

    public static void mostrarSumaMesesLetraA(ArrayList<Venta> lista) {
        Integer suma = 0;
        for (Venta venta : lista) {
            if (venta.devolverNombreMes().startsWith("A")) {
                suma += venta.devolverNumVentas();
            }
        }
        System.out.println("Para los meses que empiezan con 'A' se vendió un total de: " + suma + " automóviles.");
    }

    public static void mesMasVentas(ArrayList<Venta> lista) {
        Integer maxVentas = lista.get(0).devolverNumVentas();
        String mesMaxVentas = lista.get(0).devolverNombreMes();

        for (Venta venta : lista) {
            if (venta.devolverNumVentas() > maxVentas) {
                maxVentas = venta.devolverNumVentas();
                mesMaxVentas = venta.devolverNombreMes();
            }
        }

        System.out.println("El mes con más ventas es " + mesMaxVentas + " con " + maxVentas + " automóviles vendidos.");
    }

    public static void main(String[] args) {
        ArrayList<Venta> lista = new ArrayList<>();
        mostrarMenu(lista);
    }
}
