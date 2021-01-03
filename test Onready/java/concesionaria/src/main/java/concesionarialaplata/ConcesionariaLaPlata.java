package concesionarialaplata;

import mx.com.gm.concesionaria.*;

public class ConcesionariaLaPlata {
    public static void main(String[] args) {
        Auto vehiculo1 = new Auto("Peugeot", "206", 200000.00, 4);
        Moto vehiculo2 = new Moto("Honda", "Titan", 60000.00, "125cc");
        Auto vehiculo3 = new Auto("Peugeot", "208", 250000.00, 5);
        Moto vehiculo4 = new Moto("Yamaha", "YBR", 80500.50, "160cc");
        
        // Creamos un arreglo para los criterios de búsqueda
        Vehiculo vehiculosCriterioBusqueda[] = new Vehiculo[4];
        
        vehiculosCriterioBusqueda[0] = vehiculo1;
        vehiculosCriterioBusqueda[1] = vehiculo2;
        vehiculosCriterioBusqueda[2] = vehiculo3;
        vehiculosCriterioBusqueda[3] = vehiculo4;
        
        // Arreglo ordenado por precio de mayor a menor
        Vehiculo precioMayorAMenor[] = new Vehiculo[4];
        
        precioMayorAMenor[0] = vehiculo3;
        precioMayorAMenor[1] = vehiculo1;
        precioMayorAMenor[2] = vehiculo2;
        precioMayorAMenor[3] = vehiculo4;
        
        // Asignamos el precio de vehiculo1 para tener un valor inicial para la condición al momento de comparar para buscar el vehiculo de mayor o menor precio
        double mayorPrecio = vehiculo1.getPrecio();
        double menorPrecio = vehiculo1.getPrecio();
        String vehiculoMasCaro = "";
        String vehiculoMasBarato = "";
        String modeloY = "";
        
        MostrarRegistros listaObjetos = new MostrarRegistros();
        listaObjetos.agregarVehiculo(vehiculo1);
        listaObjetos.agregarVehiculo(vehiculo2);
        listaObjetos.agregarVehiculo(vehiculo3);
        listaObjetos.agregarVehiculo(vehiculo4);
        
        // Arreglo de busqueda
        // Buscamos el vehiculo de mayor y menor precio
        for (int i = 0; i < vehiculosCriterioBusqueda.length; i++) {
            if (mayorPrecio < vehiculosCriterioBusqueda[i].getPrecio()) {
                mayorPrecio = vehiculosCriterioBusqueda[i].getPrecio();
                vehiculoMasCaro = "Vehículo más caro: " + vehiculosCriterioBusqueda[i].getMarca() + " " + vehiculosCriterioBusqueda[i].getModelo();
            }

            if (menorPrecio > vehiculosCriterioBusqueda[i].getPrecio()) {
                menorPrecio = vehiculosCriterioBusqueda[i].getPrecio();
                vehiculoMasBarato = "Vehículo más barato: " + vehiculosCriterioBusqueda[i].getMarca() + " " + vehiculosCriterioBusqueda[i].getModelo();
            }

            if (vehiculosCriterioBusqueda[i].getModelo().contains("Y")) {
                modeloY = "Vehículo que contiene en el modelo la letra ‘Y’: " + vehiculosCriterioBusqueda[i].getMarca() + " " + vehiculosCriterioBusqueda[i].getModelo() + " $" + vehiculosCriterioBusqueda[i].getPrecio();
            }
        }
        
        listaObjetos.mostrarRegistros();
        System.out.println("========================================================================================");
        System.out.println("* " + vehiculoMasCaro);
        System.out.println("* " + vehiculoMasBarato);
        System.out.println("* " + modeloY);
        System.out.println("========================================================================================");
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        for (int i = 0; i < precioMayorAMenor.length; ++i) {
            System.out.println((i + 1) + "- " + precioMayorAMenor[i].getMarca() + " " + precioMayorAMenor[i].getModelo());
        } 
    }    
}
