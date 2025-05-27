package supermercado;

public class Cajera extends Thread {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("Cajera " + nombre + " procesando compra de " + cliente.getNombre());
        int tiempoTotal = 0;
        for (Producto p : cliente.getProductos()) {
            System.out.println("Producto: " + p.getNombre() + " - Precio: $" + p.getPrecio() + " - Tiempo: " + p.getTiempoProcesamiento() + "s");
            tiempoTotal += p.getTiempoProcesamiento();
            try {
                Thread.sleep(p.getTiempoProcesamiento() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total tiempo de compra de " + cliente.getNombre() + ": " + tiempoTotal + " segundos\n");
    }
}