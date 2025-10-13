public class Motocicleta extends Vehiculo{
    protected int cilindrada;
    protected String tipoCadena;

    public Motocicleta(int cilindrada, String tipoCadena){
        this.cilindrada = cilindrada;
        this.tipoCadena = tipoCadena;

    }

    public int getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoCadena() {
        return this.tipoCadena;
    }

    public void setTipoCadena(String tipoCadena) {
        this.tipoCadena = tipoCadena;
    }
    
}
