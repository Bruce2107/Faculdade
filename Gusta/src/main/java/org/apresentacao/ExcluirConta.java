package org.apresentacao;

import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class ExcluirConta extends JDialog {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ExcluirConta dialog = new ExcluirConta();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ExcluirConta() throws ClassNotFoundException, SQLException {
        Sistema s = Sistema.getInstance();


        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("Tem Certeza que deseja excluir sua conta?");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblNewLabel.setBounds(67, 81, 357, 40);
            contentPanel.add(lblNewLabel);
        }
        {
            JButton okButton = new JButton("Sim");
            okButton.addActionListener(arg0 -> {
                try {
                    s.excluirUsuario(s.getUsuarioLogado());
                    JOptionPane.showMessageDialog(null, "Conta exclu�da com sucesso!");
                    dispose();
                    TelaPrincipal t = new TelaPrincipal();
                    t.setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            okButton.setBounds(136, 132, 65, 23);
            contentPanel.add(okButton);
            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }
        {
            JButton cancelButton = new JButton("N\u00E3o");
            cancelButton.addActionListener(arg0 -> dispose());
            cancelButton.setBounds(256, 132, 65, 23);
            contentPanel.add(cancelButton);
            cancelButton.setActionCommand("Cancel");
        }
        {
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.inactiveCaptionBorder);
            panel.setBounds(47, 62, 342, 117);
            contentPanel.add(panel);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
        }
    }


}
