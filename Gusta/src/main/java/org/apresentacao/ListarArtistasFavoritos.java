package org.apresentacao;

import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.SQLException;

public class ListarArtistasFavoritos extends javax.swing.JFrame {

    public ListarArtistasFavoritos() throws SQLException, ClassNotFoundException {
        Sistema s = Sistema.getInstance();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            setContentPane(new JTableArtistasFavoritos());
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        contentPane.setLayout(null);


    }
}
