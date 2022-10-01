package org.apresentacao;

import org.dados.Artista;
import org.dados.Musica;
import org.negocio.Sistema;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

public class TabelaListarMusicasFavoritas extends AbstractTableModel {


    private final List<Musica> musicasFavoritas = new LinkedList<>();

    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return musicasFavoritas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {


        switch (coluna) {
            case 0:
                return musicasFavoritas.get(linha).getId();
            case 1:
                return musicasFavoritas.get(linha).getNome();
            case 2:
                try {
                    Sistema s = Sistema.getInstance();
                    String nome_a;
                    for (Artista a : s.getArtistas()) {
                        if (a.getId() == musicasFavoritas.get(linha).getId_artista()) {
                            nome_a = a.getNome();
                            return nome_a;

                        }
                    }
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
            case 2 -> "Artista";
            default -> throw new IllegalArgumentException();
        };
    }

    public void adicionarMusica(Musica a) {
        musicasFavoritas.add(a);
        this.fireTableStructureChanged();
    }


}
