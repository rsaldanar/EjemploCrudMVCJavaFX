package com.bytecode.ejemplocrudfxmaven;

import com.bytecode.ejemplocrudfxmaven.controlador.UsuarioControlador;
import com.bytecode.ejemplocrudfxmaven.modelo.Usuario;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class FXMLController implements Initializable {

    @FXML
    private JFXTextField jTFUsuarioid;

    @FXML
    private JFXTextField jTFNombre;

    @FXML
    private JFXTextField jTFApellido;

    @FXML
    private Text jLMensaje;

    @FXML
    void setGuardar(ActionEvent event) {
        setGuardar();
    }

    @FXML
    void setLimpiar(ActionEvent event) {
        setLimpiar();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setGuardar() {
        Usuario usuario = new Usuario();
        usuario.setNombre(jTFNombre.getText());
        usuario.setApellido(jTFApellido.getText());

        boolean salvar;
        try {
            UsuarioControlador userControlador = new UsuarioControlador();
            salvar = userControlador.Salvar(usuario);
            if (salvar) {
                jLMensaje.setText("Los datos fuenron Guardados. ");
                setLimpiar();
            } else {
                jLMensaje.setText("Los datos NO fuenron Guardados. ");
            }

        } catch (Exception e) {
        }
    }

    public void setLimpiar() {
        jTFApellido.setText("");
        jTFNombre.setText("");
        jTFUsuarioid.setText("");
    }
}
