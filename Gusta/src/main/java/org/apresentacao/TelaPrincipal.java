package org.apresentacao;

import org.dados.Usuario;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("deprecation")
public class TelaPrincipal extends JFrame {

    private final JTextField textField;
    private final JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                TelaPrincipal frame = new TelaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public TelaPrincipal() throws ClassNotFoundException, SQLException {
        Sistema s = Sistema.getInstance();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 486, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    Usuario u;
                    u = s.loginESenha(textField.getText(), passwordField.getText());
                    if (u != null) {
                        s.setUsuarioLogado(u);
                        if (s.getUsuarioLogado().isModerador()) {
                            TelaUsuarioModerador t = new TelaUsuarioModerador();
                            t.setVisible(true);
                        } else {
                            TelaUsuarioComum t = new TelaUsuarioComum();
                            t.setVisible(true);
                        }

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                        textField.setText("");
                        passwordField.setText("");
                        textField.requestFocus();
                        passwordField.requestFocus();
                    }


                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton.setBounds(96, 146, 104, 23);
        contentPane.add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(96, 65, 241, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Cadastre-se");
        btnNewButton_1.addActionListener(arg0 -> {
            TelaCadastro t;
            try {
                t = new TelaCadastro();
                t.setVisible(true);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            dispose();


        });
        btnNewButton_1.setBounds(223, 147, 114, 23);
        contentPane.add(btnNewButton_1);

        JTextPane txtpnOu = new JTextPane();
        txtpnOu.setBackground(SystemColor.inactiveCaptionBorder);
        txtpnOu.setText("ou");
        txtpnOu.setBounds(202, 149, 27, 20);
        contentPane.add(txtpnOu);

        passwordField = new JPasswordField();
        passwordField.setBounds(95, 115, 242, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel = new JLabel("Digite seu email:");
        lblNewLabel.setBounds(96, 47, 104, 14);
        contentPane.add(lblNewLabel);

        JLabel lblDigiteSuaSenha = new JLabel("Digite sua senha:");
        lblDigiteSuaSenha.setBounds(96, 96, 114, 14);
        contentPane.add(lblDigiteSuaSenha);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(66, 29, 300, 173);
        contentPane.add(panel);
    }
}
