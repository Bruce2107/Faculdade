package org.apresentacao;

import org.dados.Musica;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class RemoverMusica extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RemoverMusica dialog = new RemoverMusica();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RemoverMusica() throws Exception {
        Sistema s = Sistema.getInstance();

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(146, 118, 151, 22);
        contentPanel.add(comboBox);

        List<Musica> musicas;
        musicas = s.getMusicas();

        for (Musica m : musicas) {
            comboBox.addItem(m.soNome());
        }


        {
            JLabel lblNewLabel = new JLabel("Escolha uma m\u00FAsica");
            lblNewLabel.setBounds(175, 93, 151, 14);
            contentPanel.add(lblNewLabel);
        }
        {
            JButton okButton = new JButton("Excluir");
            okButton.addActionListener(arg0 -> {
                String m = (String) comboBox.getSelectedItem();
                try {
                    for (Musica m1 : s.getMusicas()) {
                        if (m1.getNome().equals(m)) {
                            s.excluirMusica(m1);
                            JOptionPane.showMessageDialog(null, "M�sica exclu�da com sucesso!");
                            dispose();
                        }
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            okButton.setBounds(186, 151, 81, 23);
            contentPanel.add(okButton);
            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }
        {
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.inactiveCaptionBorder);
            panel.setBounds(117, 69, 209, 125);
            contentPanel.add(panel);
        }
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
