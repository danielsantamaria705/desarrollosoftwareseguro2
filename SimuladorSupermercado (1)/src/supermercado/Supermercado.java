package supermercado;

import java.util.*;

public class Supermercado {
    public static void main(String[] args) {
        Producto p1 = new Producto("Arroz", 2500, 2);
        Producto p2 = new Producto("Leche", 3000, 3);
        Producto p3 = new Producto("Pan", 2000, 1);

        Cliente cliente1 = new Cliente("Daniel", Arrays.asList(p1, p2));
        Cliente cliente2 = new Cliente("Laura", Arrays.asList(p2, p3));
        Cliente cliente3 = new Cliente("Carlos", Arrays.asList(p1, p3, p2));

        Cajera cajera1 = new Cajera("Sofía", cliente1);
        Cajera cajera2 = new Cajera("Lucía", cliente2);
        Cajera cajera3 = new Cajera("María", cliente3);

        long inicio = System.currentTimeMillis();

        cajera1.start();
        cajera2.start();
        cajera3.start();

        try {
            cajera1.join();
            cajera2.join();
            cajera3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total para procesar todas las compras: " + (fin - inicio)/1000 + " segundos");
    }
}