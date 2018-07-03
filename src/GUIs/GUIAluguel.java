package GUIs;
import DAOs.DAOAluguel;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;
public class GUIAluguel extends JFrame {
ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
JButton btnCreate = new JButton(iconeCreate);
JButton btnRetrieve = new JButton(iconeRetrieve);
JButton btnUpdate = new JButton(iconeUpdate);
JButton btnDelete = new JButton(iconeDelete);
JButton btnSave = new JButton(iconeSave);
JButton btnCancel = new JButton(iconeCancel);
JButton btnList = new JButton(iconeListar);
private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
private Date data2;
private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
private JPanel pnCentro = new JPanel(new GridLayout(3, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbIdAluguel = new JLabel("IdAluguel");
private JTextField tfIdAluguel = new JTextField(10);
private JPanel pnClienteLogin = new JPanel(new GridLayout(1, 2));
private JLabel lbClienteLogin = new JLabel("ClienteLogin");
private JTextField tfClienteLogin = new JTextField();
private JButton btClienteLogin = new JButton("Procurar");
private JLabel lbDataAluguel = new JLabel("DataAluguel");
private JTextField tfDataAluguel = new JTextField(10);
private JButton btEscolha2 = new JButton("Escolha");
private JPanel pnDataAluguel = new JPanel(new GridLayout(1, 2));
private JLabel lbObservacoes = new JLabel("Observacoes");
private JTextField tfObservacoes = new JTextField(10);
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOAluguel daoAluguel = new DAOAluguel();
Aluguel aluguel;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUIAluguel() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Aluguel");
Container cp = getContentPane();cp = getContentPane();
btnCreate.setToolTipText("Inserir novo registro");
btnRetrieve.setToolTipText("Pesquisar por chave");
btnUpdate.setToolTipText("Alterar");
btnDelete.setToolTipText("Excluir");
btnList.setToolTipText("Listar todos");
btnSave.setToolTipText("Salvar");
btnCancel.setToolTipText("Cancelar");cp.setLayout(new BorderLayout());
cp.add(pnNorte, BorderLayout.NORTH);
cp.add(pnCentro, BorderLayout.CENTER);
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdAluguel);
pnNorte.add(tfIdAluguel);
pnNorte.add(btnRetrieve);
pnNorte.add(btnCreate);
pnNorte.add(btnUpdate);
pnNorte.add(btnDelete);
pnNorte.add(btnSave);
pnNorte.add(btnList);
btnCancel.setVisible(false);
btnDelete.setVisible(false);
btnCreate.setVisible(false);
btnSave.setVisible(false);
btnUpdate.setVisible(false);
pnCentro.add(lbClienteLogin);
pnCentro.add(pnClienteLogin);
pnClienteLogin.add(tfClienteLogin);
pnClienteLogin.add(btClienteLogin);
pnCentro.add(lbDataAluguel);
pnCentro.add(pnDataAluguel);
pnDataAluguel.add(btEscolha2);
pnDataAluguel.add(tfDataAluguel);
pnCentro.add(lbObservacoes);
pnCentro.add(tfObservacoes);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfClienteLogin.setEditable(false);
btClienteLogin.setEnabled(false);
btEscolha2.setEnabled(false);
tfDataAluguel.setEditable(false);
tfObservacoes.setEditable(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdAluguel.setBackground(Color.white);
jTextArea.setText("");
aluguel = new Aluguel();
int identificador = Integer.valueOf(tfIdAluguel.getText());
aluguel.setIdAluguel(identificador);
aluguel = daoAluguel.obter(aluguel.getIdAluguel());
if (aluguel == null) {
pnNorte.setBackground(Color.red);
tfClienteLogin.setText("");
tfDataAluguel.setText("");
tfObservacoes.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
String dao1 = String.valueOf(aluguel.getClienteLogin());
String [] aux1 = dao1.split("-");
tfClienteLogin.setText(aux1[0]);
tfDataAluguel.setText(sdf.format(aluguel.getDataAluguel()));
tfObservacoes.setText(aluguel.getObservacoes());
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfIdAluguel.setEditable(false);
btClienteLogin.setEnabled(false);
tfDataAluguel.setEditable(false);
tfObservacoes.setEditable(false);
tfIdAluguel.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdAluguel.requestFocus();
tfIdAluguel.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdAluguel.setEditable(false);
tfClienteLogin.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
aluguel = new Aluguel();
btClienteLogin.setEnabled(true);
btEscolha2.setEnabled(true);
tfObservacoes.setEditable(true);
tfIdAluguel.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
aluguel = new Aluguel();
aluguel.setIdAluguel(Integer.valueOf(tfIdAluguel.getText()));
String [] aux0 = tfClienteLogin.getText().split("-");
DAOCliente daoCliente = new DAOCliente();
Cliente d0 = daoCliente.obter(aux0[0]);
aluguel.setClienteLogin(d0);
sdf.setLenient(false);
data2 = sdf.parse(tfDataAluguel.getText());
try {
aluguel.setDataAluguel(sdf.parse(tfDataAluguel.getText()));} catch (ParseException ex) {
Logger.getLogger(GUIAluguel.class
.getName()).log(Level.SEVERE, null, ex);
}
aluguel.setObservacoes(tfObservacoes.getText());
if (qualAcao.equals("incluir")) {
daoAluguel.inserir(aluguel);
} else {
daoAluguel.atualizar(aluguel);
}
tfIdAluguel.setEditable(true);
tfIdAluguel.requestFocus();
tfClienteLogin.setText("");
tfDataAluguel.setText("");
tfObservacoes.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
btClienteLogin.setEnabled(false);
btEscolha2.setEnabled(false);
tfObservacoes.setEditable(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdAluguel.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfClienteLogin.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
btClienteLogin.setEnabled(true);
btEscolha2.setEnabled(true);
tfObservacoes.setEditable(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + aluguel.getIdAluguel() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoAluguel.remover(aluguel);
tfIdAluguel.requestFocus();
tfClienteLogin.setText("");
tfDataAluguel.setText("");
tfObservacoes.setText("");
tfIdAluguel.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemAluguel guiListagem = new GUIListagemAluguel(daoAluguel.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
btEscolha2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
DateChooser dc2 = new DateChooser((JFrame) null, "Escolha uma data");
data2 = dc2.select();
tfDataAluguel.setText(sdf.format(data2));
} catch (Exception ex) {
jTextArea.setText("Escolha uma data\n");
}}
});
DAOCliente daoCliente = new DAOCliente();
btClienteLogin.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfClienteLogin.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
tfIdAluguel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoAluguel.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdAluguel.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdAluguel.requestFocus();tfIdAluguel.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUIAluguel guiAluguel = new GUIAluguel();
}
}
