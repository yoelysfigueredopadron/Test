package mx.com.gm.concesionaria;

public class Moto extends Vehiculo {
    private final int idMoto;
    private static int contadorMotos;
    private String cilindrada;
    
    public Moto (String marca, String modelo, double precio, String cilindrada) {
        super(marca, modelo, precio);
        this.idMoto = ++Moto.contadorMotos;
        this.cilindrada = cilindrada;
    }
    
    // return "Moto{" + "idMoto=" + idMoto + ", cilindrada=" + cilindrada + ", " + super.toString() + '}';
    @Override
    public String toString() {
        return "Moto{" + "idMoto=" + idMoto + ", Marca=" + super.getMarca() + ", Modelo=" + super.getModelo() + ", cilindrada=" + cilindrada + ", Precio=$" + super.getPrecio() + '}';
    }
}
