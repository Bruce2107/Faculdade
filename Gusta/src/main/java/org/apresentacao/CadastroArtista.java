package org.apresentacao;

import org.dados.Artista;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class CadastroArtista extends JFrame {

    private final JTextField textField;
    private final JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroArtista frame = new CadastroArtista();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastroArtista() throws ClassNotFoundException, SQLException {
        Sistema s = Sistema.getInstance();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDigiteONome = new JLabel("Digite o nome do Artista:");
        lblDigiteONome.setBounds(110, 58, 212, 14);
        contentPane.add(lblDigiteONome);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(110, 76, 194, 20);
        contentPane.add(textField);

        JLabel lblDigiteOGnero = new JLabel("Digite o g\u00EAnero musical:");
        lblDigiteOGnero.setBounds(110, 107, 212, 14);
        contentPane.add(lblDigiteOGnero);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(110, 124, 194, 20);
        contentPane.add(textField_1);

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.addActionListener(arg0 -> {
            Artista a = new Artista();
            a.setNome(textField.getText());
            a.setGeneroMusical(textField_1.getText());
            try {
                s.inserirArtista(s.getUsuarioLogado(), a);
                JOptionPane.showMessageDialog(null, "Artista cadastrado com sucesso");
                dispose();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        });
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton.setBounds(159, 155, 100, 23);
        contentPane.add(btnNewButton);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(77, 37, 258, 161);
        contentPane.add(panel);
    }

}
