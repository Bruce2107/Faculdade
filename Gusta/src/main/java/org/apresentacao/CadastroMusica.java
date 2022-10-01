package org.apresentacao;

import org.dados.Artista;
import org.dados.Musica;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CadastroMusica extends JFrame {

    private final JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroMusica frame = new CadastroMusica();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastroMusica() throws Exception {
        Sistema s = Sistema.getInstance();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Digite o nome da m\u00FAsica:");
        lblNewLabel.setBounds(147, 48, 212, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(113, 73, 194, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(113, 129, 194, 22);
        contentPane.add(comboBox);

        List<Artista> artistas;
        artistas = s.getArtistas();

        for (Artista a : artistas) {
            comboBox.addItem(a.soNome());
        }


        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.addActionListener(arg0 -> {
            Musica m = new Musica();
            m.setNome(textField.getText());
            String a = (String) comboBox.getSelectedItem();


            try {
                for (Artista a1 : s.getArtistas()) {
                    if (a1.getNome().equals(a)) {
                        m.setId_artista(a1.getId());
                        s.inserirMusica(s.getUsuarioLogado(), m);

                    }
                }
                JOptionPane.showMessageDialog(null, "M�sica cadastrada com sucesso");
                dispose();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        btnNewButton.setBounds(160, 168, 115, 23);
        contentPane.add(btnNewButton);

        JLabel lblSelecioneOArtista = new JLabel("Selecione o artista:");
        lblSelecioneOArtista.setBounds(160, 104, 212, 14);
        contentPane.add(lblSelecioneOArtista);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(76, 30, 273, 190);
        contentPane.add(panel);
    }
}
