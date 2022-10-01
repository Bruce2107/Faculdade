package org.apresentacao;

import org.dados.Musica;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class FavoritarMusicas extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            FavoritarMusicas dialog = new FavoritarMusicas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public FavoritarMusicas() throws Exception {
        Sistema s = Sistema.getInstance();

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(SystemColor.control);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JComboBox<Musica> comboBox = new JComboBox<>();
        comboBox.setBounds(118, 115, 199, 22);
        contentPanel.add(comboBox);

        List<Musica> musicas;
        musicas = s.getMusicas();

        for (Musica m : musicas) {
            comboBox.addItem(m);
        }

        JLabel lblNewLabel = new JLabel("Selecione uma m\u00FAsica");
        lblNewLabel.setBounds(166, 94, 170, 14);
        contentPanel.add(lblNewLabel);
        {
            JButton okButton = new JButton("Favoritar");
            okButton.addActionListener(arg0 -> {
                Musica m = (Musica) comboBox.getSelectedItem();
                Integer id_m = Objects.requireNonNull(m).getId();
                int cont = 0;
                try {
                    for (Integer id_musica : s.getMusicasFavoritas(s.getUsuarioLogado())) {
                        if (id_musica.equals(id_m)) {
                            cont = 1;
                            break;
                        }
                    }
                    if (cont == 1) {
                        JOptionPane.showMessageDialog(null, "M�sica j� est� favoritada, escolha outra m�sica!");
                    } else {
                        s.favoritarMusica(m, s.getUsuarioLogado());
                        JOptionPane.showMessageDialog(null, "M�sica favoritada com sucesso!");
                        dispose();
                    }


                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            });
            okButton.setBounds(170, 142, 102, 23);
            contentPanel.add(okButton);
            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(77, 68, 286, 126);
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
