public class Auto extends Vehiculo{
    protected int numPuertas;
    protected String tipoCombustible;
    protected String tipoMotor;

    public Auto (int numPuertas, String tipoCombustible, String tipoMotor){
        this.tipoCombustible = tipoCombustible;
        this. tipoMotor = tipoMotor;
        this.numPuertas = numPuertas;

    }

    public int getNumPuertas() {
        return this.numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getTipoCombustible() {
        return this.tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoMotor() {
        return this.tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    
}
