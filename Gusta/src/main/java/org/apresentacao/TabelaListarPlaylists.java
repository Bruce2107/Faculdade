package org.apresentacao;

import org.dados.Musica;
import org.dados.Playlist;
import org.negocio.Sistema;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

public class TabelaListarPlaylists extends AbstractTableModel {


    private final List<Playlist> playlists = new LinkedList<>();

    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return playlists.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {


        switch (coluna) {
            case 0:
                return playlists.get(linha).getId();
            case 1:
                return playlists.get(linha).getNome();
            case 2:
                try {
                    Sistema s = Sistema.getInstance();
                    List<String> nome_musicas = new LinkedList<>();
                    List<Integer> id_musicas;

                    for (Playlist p : s.getPlaylists()) {
                        if (p.getId() == playlists.get(linha).getId()) {
                            id_musicas = s.selectMusicasPlaylist(p);
                            for (Musica m : s.getMusicas()) {
                                for (Integer id_musica : id_musicas) {
                                    if (m.getId() == id_musica) {
                                        nome_musicas.add(m.getNome());
                                    }
                                }
                            }
                        }
                    }
                    return nome_musicas;

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            default:
                throw new IllegalArgumentException();
        }
    }

    public String getColumnName(int coluna) {
        return switch (coluna) {
            case 0 -> "Id";
            case 1 -> "Nome";
            case 2 -> "M�sicas";
            default -> throw new IllegalArgumentException();
        };
    }

    public void adicionarPlaylist(Playlist a) {
        playlists.add(a);
        this.fireTableStructureChanged();
    }


}
