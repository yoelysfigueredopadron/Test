package mx.com.gm.concesionaria;

public class Auto extends Vehiculo {
    private final int idAuto;
    private static int contadorAutos;
    private int puertas;
    
    public Auto (String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio);
        this.idAuto = ++Auto.contadorAutos;
        this.puertas = puertas;
    }

    // return "Auto{" + "idAuto=" + idAuto + ", puertas=" + puertas + ", " + super.toString() + '}';
    @Override
    public String toString() {
        return "Auto{" + "idAuto=" + idAuto + ", Marca=" + super.getMarca() + ", Modelo=" + super.getModelo() + ", puertas=" + puertas + ", Precio=$" + super.getPrecio() + '}';
    }
}
