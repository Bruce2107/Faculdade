package org.apresentacao;

import org.dados.Artista;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

public class TabelaListarArtistasFavoritos extends AbstractTableModel {


    private final List<Artista> artistasFavoritos = new LinkedList<>();

    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return artistasFavoritos.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        return switch (coluna) {
            case 0 -> artistasFavoritos.get(linha).getId();
            case 1 -> artistasFavoritos.get(linha).getNome();
            case 2 -> artistasFavoritos.get(linha).getGeneroMusical();
            default -> throw new IllegalArgumentException();
        };
    }

    public String getColumnName(int coluna) {
        return switch (coluna) {
            case 0 -> "Id";
            case 1 -> "Nome";
            case 2 -> "G�nero Musical";
            default -> throw new IllegalArgumentException();
        };
    }

    public void adicionarArtista(Artista a) {
        artistasFavoritos.add(a);
        this.fireTableStructureChanged();
    }


}
