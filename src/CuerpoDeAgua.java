public class CuerpoDeAgua extends ObjetoGeografico {
    public CuerpoDeAgua(String nombre, int codigo, String municipio, String tipo_agua, String tipo_cuerpo,
            double indice) {
        super(nombre, codigo, municipio, tipo_agua, tipo_cuerpo, indice);
    }

    public String nivel() {
        if (indice < 35.1) {
            return "medio";
        }
        return null;
    }
}
