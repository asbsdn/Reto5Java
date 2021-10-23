public class DensidadPoblacional extends ObjetoGeografico {
    protected int poblacion;

    public DensidadPoblacional(String nombre, int codigo, String municipio, String tipo_agua, String tipo_cuerpo,
            double indice, int poblacion) {
        super(nombre, codigo, municipio, tipo_agua, tipo_cuerpo, indice);
        this.poblacion = poblacion;
    }

    public int afeccion(int poblacion) {
        if (poblacion < 10000) {
            poblacion = 0;
        } else if (poblacion > 10000 && poblacion < 50000) {
            poblacion = 1;
        } else {
            poblacion = 2;
        }
        return poblacion;
    }

}
