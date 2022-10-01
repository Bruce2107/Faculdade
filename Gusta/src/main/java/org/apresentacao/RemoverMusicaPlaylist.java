package org.apresentacao;

import org.dados.Musica;
import org.dados.Playlist;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class RemoverMusicaPlaylist extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RemoverMusicaPlaylist frame = new RemoverMusicaPlaylist();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RemoverMusicaPlaylist() throws Exception {
        Sistema s = Sistema.getInstance();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setToolTipText("");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<Playlist> comboBox = new JComboBox<>();
        comboBox.setBounds(114, 75, 186, 22);
        contentPane.add(comboBox);

        JLabel lblNewLabel = new JLabel("Selecione uma playlist: ");
        lblNewLabel.setBounds(114, 54, 186, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Selecione uma m\u00FAsica:");
        lblNewLabel_1.setBounds(114, 108, 186, 14);
        contentPane.add(lblNewLabel_1);

        JComboBox<Musica> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(114, 133, 186, 22);
        contentPane.add(comboBox_1);


        for (Integer id_playlist : s.getPlaylists(s.getUsuarioLogado())) {
            for (Playlist p : s.getPlaylists()) {
                if (id_playlist == p.getId()) {
                    comboBox.addItem(p);
                }
            }


        }


        List<Musica> musicas;
        musicas = s.getMusicas();

        for (Musica m : musicas) {
            comboBox_1.addItem(m);
        }

        JButton btnNewButton = new JButton("Remover");
        btnNewButton.addActionListener(arg0 -> {

            try {
                Playlist p = (Playlist) comboBox.getSelectedItem();
                Musica m = (Musica) comboBox_1.getSelectedItem();
                for (Integer m1 : s.selectMusicasPlaylist(Objects.requireNonNull(p))) {
                    if (m1 == Objects.requireNonNull(m).getId()) {
                        s.removerMusicaPlaylist(p, m);
                    }

                }
                JOptionPane.showMessageDialog(null, "M�sica removida com sucesso!");
                dispose();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        });
        btnNewButton.setBounds(163, 166, 89, 23);
        contentPane.add(btnNewButton);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        panel.setBounds(76, 36, 258, 177);
        contentPane.add(panel);

    }
}
