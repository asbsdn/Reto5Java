import java.text.DecimalFormat;

public class ObjetoGeografico {
    protected String nombre, municipio, tipo_agua, tipo_cuerpo;
    protected int codigo;
    protected double indice;
    DecimalFormat df = new DecimalFormat("#.00");

    public ObjetoGeografico(String nombre, int codigo, String municipio, String tipo_agua, String tipo_cuerpo, 
            double indice) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.municipio = municipio;
        this.tipo_agua = tipo_agua;
        this.tipo_cuerpo = tipo_cuerpo;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipo_agua() {
        return tipo_agua;
    }

    public void setTipo_agua(String tipo_agua) {
        this.tipo_agua = tipo_agua;
    }

    public String getTipo_cuerpo() {
        return tipo_cuerpo;
    }

    public void setTipo_cuerpo(String tipo_cuerpo) {
        this.tipo_cuerpo = tipo_cuerpo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getIndice() {
        return indice;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public void imprimir() {
        System.out.println(df.format(indice));
    }

    public void imprimirMedios() {
        if (indice >= 14 && indice <= 35) {
            System.out.print(nombre + " ");
        }
    }

    public String imprimirNombres(String name) {
        if (indice >= 14 && indice <= 35) {
            return name += nombre;
        }
        return "";
    }

    public double indice(double ind) {
        ind = indice;
        return ind;
    }

    public String nivel() {
        if (indice < 35.1) {
            return "medio";
        }
        return null;
    }
}
