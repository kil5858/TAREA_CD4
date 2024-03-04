package banco;
/*comentario1*/
public class CtaCorriente {
    private String nombre;
    private String cuenta;
    private double saldoCuenta;
    private double interes;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the saldoCuenta
     */
    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    /**
     * @param saldoCuenta the saldoCuenta to set
     */
    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    /**
     * @return the interes
     */
    public double getInteres() {
        return interes;
    }

    /**
     * @param interes the interes to set
     */
    public void setInteres(double interes) {
        this.interes = interes;
    }

    public CtaCorriente()
    {
    }
    public CtaCorriente(String nombre, String cuenta, double saldo, double interes)
    {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldoCuenta = saldo;
        this.interes = interes;
    }
    public void ingresar(double cantidad) throws negativeException
    {
        if (cantidad<0)
            throw new negativeException("No se puede ingresar una cantidad negativa");
        setSaldoCuenta(getSaldoCuenta() + cantidad);
    }

    public void retirar(double cantidad) throws saldoException, negativeException
    {
        if (cantidad <= 0)
            throw new negativeException ("No se puede retirar una cantidad negativa");
        if (getSaldoCuenta()< cantidad)
            throw new saldoException ("No se hay suficiente saldo");
        setSaldoCuenta(getSaldoCuenta() - cantidad);
    }

    private static class negativeException extends Exception {

        public negativeException(String no_se_puede_retirar_una_cantidad_negativa) {
        }
    }

    private static class saldoException extends Exception {

        public saldoException(String no_se_hay_suficiente_saldo) {
        }
    }
}