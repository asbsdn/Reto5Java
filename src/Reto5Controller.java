import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Reto5Controller {

    @FXML
    private Button btn_ingresar;

    @FXML
    private Button btn_procesar;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_municipio;

    @FXML
    private TextField txt_cuerpo_agua;

    @FXML
    private TextField txt_tipo_agua;

    @FXML
    private TextField txt_IRCA;

    @FXML
    private TextField txt_densidad;

    @FXML
    private ImageView img_logo;

    @FXML
    private TextArea txt_area_input;

    @FXML
    private TextArea txt_area_out_sep;

    @FXML
    private Button btn_salir;

    @FXML
    void input(ActionEvent event) throws IOException {
        String test = String.join(" ", txt_nombre.getText() + " " + txt_id.getText() + " " + txt_municipio.getText()
                + " " + txt_tipo_agua.getText() + " " + txt_cuerpo_agua.getText() + " " + txt_IRCA.getText() + " " + txt_densidad.getText());
        txt_area_input.setText(txt_area_input.getText() + test + "\n");

        limpiar();
    }

    @FXML
    void procesar(ActionEvent event) {
        txt_area_out_sep.clear();
        String output = txt_area_input.getText();
        String[] out_sep = output.split("\n");
        DensidadPoblacional[] listasub_Vector = new DensidadPoblacional[out_sep.length];

        for (int i = 0; i < out_sep.length; i++) {
            String[] sub_Vector = out_sep[i].split(" ");
            listasub_Vector[i] = new DensidadPoblacional(sub_Vector[0], Integer.parseInt(sub_Vector[1]), sub_Vector[3], sub_Vector[4],
                    sub_Vector[2], Double.parseDouble(sub_Vector[5]), Integer.parseInt(sub_Vector[6]));
        }

        double suma_indice = 0;
        for (int i = 0; i < listasub_Vector.length; i++) {
            double ind = 0;
            listasub_Vector[i].indice(ind);
            double indi = listasub_Vector[i].indice(ind);
            suma_indice += indi;
            txt_area_out_sep.setText(txt_area_out_sep.getText() + String.format("%.2f", indi) + "\n");
        }

        double nivel = 0;
        for (int i = 0; i < listasub_Vector.length; i++) {
            if (listasub_Vector[i].nivel() == "medio") {
                nivel += 1;
            }
        }
        txt_area_out_sep.setText(txt_area_out_sep.getText() + String.format("%.2f", nivel) + "\n");

        for (int i = 0; i < listasub_Vector.length; i++) {
            String name = "";
            String lista = listasub_Vector[i].imprimirNombres(name);
            txt_area_out_sep.setText(txt_area_out_sep.getText() + String.valueOf(lista) + " ");
        }

        txt_area_out_sep.setText(txt_area_out_sep.getText() + "\n");
        double prom = suma_indice / listasub_Vector.length;
        txt_area_out_sep.setText(txt_area_out_sep.getText() + String.format("%.2f", prom) + "\n");

        for (int i = 0; i < listasub_Vector.length; i++) {
            int pob;
            pob = listasub_Vector[i].poblacion;
            txt_area_out_sep.setText(txt_area_out_sep.getText() + listasub_Vector[i].afeccion(pob)+ "\n");
        }
    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }

    void limpiar() {
        txt_nombre.clear();
        txt_id.clear();
        txt_municipio.clear();
        txt_cuerpo_agua.clear();
        txt_tipo_agua.clear();
        txt_IRCA.clear();
        txt_densidad.clear();
    }
}