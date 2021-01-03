package mx.com.gm.concesionaria;

public class MostrarRegistros {
    private final int idMostrarReg;
    private Vehiculo vehiculos[];
    private static int contadorMostrarReg;
    private static final int MAX_REGISTROVEHICULOS = 4; // Creamos una constante con el número de registros a mostrar
    private int contadorVehiculos;
    
    public MostrarRegistros() {
        this.idMostrarReg = ++MostrarRegistros.contadorMostrarReg;
        this.vehiculos = new Vehiculo[MostrarRegistros.MAX_REGISTROVEHICULOS];
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (this.contadorVehiculos < MostrarRegistros.MAX_REGISTROVEHICULOS) {
            this.vehiculos[this.contadorVehiculos++] = vehiculo;
        }
        else {
            System.out.println("Has superado el número máximo (" + MostrarRegistros.MAX_REGISTROVEHICULOS + ") de vehículos a introducir.");
        }
    }
    
    public void mostrarRegistros() {
        System.out.println("Informe #" + this.idMostrarReg);
        System.out.println("========================================================================================");
        for (int i = 0; i < this.contadorVehiculos; i++) {
            System.out.println((i + 1) + "-" + this.vehiculos[i]);
        }
    }
}
