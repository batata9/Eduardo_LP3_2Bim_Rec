package GUIs;

import Entidades.Cor;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CorTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "Nome"};
    private List<Cor> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");

    public CorTableModel(List<Cor> dados) {
        this.dados = dados;
    }

    public void setDados(List<Cor> dados) {
        this.dados = dados;
    }

    public List<Cor> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cor s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdCor();
            case 1:
                return s.getNome();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        //  mudou = true;
        Cor s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                s.setIdCor((Integer) aValue);
                break;
            case 1:
                s.setNome((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public Cor getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(Cor tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(Cor tipoConta) {
        dados.add(tipoConta);
        fireTableRowsInserted(indexOf(tipoConta), indexOf(tipoConta));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
