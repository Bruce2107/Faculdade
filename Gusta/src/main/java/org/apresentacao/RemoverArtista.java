package org.apresentacao;

import org.dados.Artista;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class RemoverArtista extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RemoverArtista dialog = new RemoverArtista();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RemoverArtista() throws Exception {
        Sistema s = Sistema.getInstance();

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(SystemColor.control);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblEscolhaUmArtista = new JLabel("Escolha um artista");
            lblEscolhaUmArtista.setBounds(156, 88, 151, 14);
            contentPanel.add(lblEscolhaUmArtista);
        }

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(130, 113, 151, 22);
        contentPanel.add(comboBox);


        List<Artista> artistas;
        artistas = s.getArtistas();

        for (Artista a : artistas) {
            comboBox.addItem(a.soNome());
        }


        {
            JButton okButton = new JButton("Excluir");
            okButton.addActionListener(arg0 -> {
                String a = (String) comboBox.getSelectedItem();
                try {
                    for (Artista a1 : s.getArtistas()) {
                        if (a1.getNome().equals(a)) {
                            s.excluirArtista(a1);
                            JOptionPane.showMessageDialog(null, "Artista Removido com sucesso!");
                            dispose();
                        }
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            okButton.setActionCommand("OK");
            okButton.setBounds(167, 146, 81, 23);
            contentPanel.add(okButton);
        }
        {
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.inactiveCaptionBorder);
            panel.setBounds(93, 59, 227, 134);
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
