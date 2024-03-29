package org.apresentacao;

import org.dados.Musica;
import org.dados.Playlist;
import org.negocio.Sistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class AdicionarMusicaPlaylist extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AdicionarMusicaPlaylist frame = new AdicionarMusicaPlaylist();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdicionarMusicaPlaylist() throws Exception {
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

        JLabel lblNewLabel_1 = new JLabel("Selecione uma música:");
        lblNewLabel_1.setBounds(114, 108, 186, 14);
        contentPane.add(lblNewLabel_1);

        JComboBox<Musica> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(114, 133, 186, 22);
        contentPane.add(comboBox_1);


        for (int id_playlist : s.getPlaylists(s.getUsuarioLogado())) {
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

        JButton btnNewButton = new JButton("Adicionar");
        btnNewButton.addActionListener(arg0 -> {
            Playlist p = (Playlist) comboBox.getSelectedItem();
            Musica m = (Musica) comboBox_1.getSelectedItem();
            int aux = 0;
            try {
                for (Integer id_m : s.selectMusicasPlaylist(Objects.requireNonNull(p))) {
                    if (Objects.requireNonNull(m).getId() == id_m) {
                        aux = 1;
                        break;
                    }
                }
                if (aux != 0) {
                    JOptionPane.showMessageDialog(null, "M�sica selecionada j� est� na playlist selecionada!");
                } else {
                    s.adicionarMusicaPlaylist(p, m);
                    JOptionPane.showMessageDialog(null, "M�sica adicionada com sucesso!");
                    dispose();
                }

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
