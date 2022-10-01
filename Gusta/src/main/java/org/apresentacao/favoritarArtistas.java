package org.apresentacao;

import org.dados.Artista;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class favoritarArtistas extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            favoritarArtistas dialog = new favoritarArtistas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public favoritarArtistas() throws Exception {
        Sistema s = Sistema.getInstance();

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblSelecioneUmArtista = new JLabel("Selecione um artista");
            lblSelecioneUmArtista.setBounds(150, 84, 170, 14);
            contentPanel.add(lblSelecioneUmArtista);
        }

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(122, 109, 170, 22);
        contentPanel.add(comboBox);
        List<Artista> artistas;
        artistas = s.getArtistas();

        for (Artista a : artistas) {
            comboBox.addItem(a.soNome());
        }


        JButton okButton_1 = new JButton("Favoritar");
        okButton_1.addActionListener(arg0 -> {
            String a = (String) comboBox.getSelectedItem();
            Artista a2 = new Artista();

            try {
                for (Artista a1 : s.getArtistas()) {
                    if (a1.getNome().equals(a)) {
                        a2 = a1;
                    }
                }
                Integer id_a2 = a2.getId();
                int cont = 0;

                for (Integer id_artista : s.getArtistasFavoritos(s.getUsuarioLogado())) {
                    if (id_artista.equals(id_a2)) {
                        cont = 1;
                        break;
                    }
                }
                if (cont == 1) {
                    JOptionPane.showMessageDialog(null, "Artista j� est� favoritado, escolha outro artista!");
                } else {
                    s.favoritarArtista(a2, s.getUsuarioLogado());
                    JOptionPane.showMessageDialog(null, "Artista favoritado com sucesso!");
                    dispose();
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        okButton_1.setActionCommand("OK");
        okButton_1.setBounds(160, 142, 102, 23);
        contentPanel.add(okButton_1);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(97, 60, 221, 130);
        contentPanel.add(panel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(arg0 -> dispose());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
