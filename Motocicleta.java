public class Motocicleta extends Vehiculo{
    protected int cilindrada;
    protected String tipoCadena;

    public Motocicleta(int cilindrada, String tipoCadena,String marca, String modelo, String placa,Cliente cliente){
        super(marca,modelo,placa,cliente);
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
    
    @Override
    public String toString(){
        return super.toString() + " CILINDRADA: "+cilindrada+ " TIPO DE CADENA: "+tipoCadena +"";
    }

}
