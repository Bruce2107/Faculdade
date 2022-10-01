package org.apresentacao;

import org.dados.Playlist;
import org.negocio.Sistema;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class JTablePlaylists extends JScrollPane {
    final Sistema s = Sistema.getInstance();


    public JTablePlaylists() throws Exception {


        TabelaListarPlaylists t = new TabelaListarPlaylists();
        JTable table = new JTable(t);
        setViewportView(table);
        if (playlists() != null) {
            for (int i = 0; i < playlists().size(); i++) {
                t.adicionarPlaylist(playlists().get(i));

            }
        }
    }

    public List<Playlist> playlists() throws Exception {

        List<Playlist> playlists = new LinkedList<>();

        for (Integer id_playlist : s.getPlaylists(s.getUsuarioLogado())) {
            for (Playlist p : s.getPlaylists()) {
                if (id_playlist == p.getId()) {
                    playlists.add(p);
                }
            }
        }

        return playlists;

    }


}
