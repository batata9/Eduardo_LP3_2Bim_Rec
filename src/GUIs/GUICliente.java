package GUIs;
import DAOs.DAOCliente;
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
public class GUICliente extends JFrame {
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
private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
private JPanel pnCentro = new JPanel(new GridLayout(10, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbLogin = new JLabel("Login");
private JTextField tfLogin = new JTextField(10);
private JLabel lbNome = new JLabel("Nome");
private JTextField tfNome = new JTextField(10);
private JLabel lbSenha = new JLabel("Senha");
private JTextField tfSenha = new JTextField(10);
private JLabel lbEndereco = new JLabel("Endereco");
private JTextField tfEndereco = new JTextField(10);
private JLabel lbBairro = new JLabel("Bairro");
private JTextField tfBairro = new JTextField(10);
private JLabel lbCidade = new JLabel("Cidade");
private JTextField tfCidade = new JTextField(10);
private JLabel lbCep = new JLabel("Cep");
private JTextField tfCep = new JTextField(10);
private JLabel lbEmail = new JLabel("Email");
private JTextField tfEmail = new JTextField(10);
private JLabel lbTelefone = new JLabel("Telefone");
private JTextField tfTelefone = new JTextField(10);
private JLabel lbCelular = new JLabel("Celular");
private JTextField tfCelular = new JTextField(10);
private JLabel lbAtivo = new JLabel("Ativo");
private JCheckBox cbAtivo = new JCheckBox("");
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOCliente daoCliente = new DAOCliente();
Cliente cliente;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUICliente() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Cliente");
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
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbLogin);
pnNorte.add(tfLogin);
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
pnCentro.add(lbNome);
pnCentro.add(tfNome);
pnCentro.add(lbSenha);
pnCentro.add(tfSenha);
pnCentro.add(lbEndereco);
pnCentro.add(tfEndereco);
pnCentro.add(lbBairro);
pnCentro.add(tfBairro);
pnCentro.add(lbCidade);
pnCentro.add(tfCidade);
pnCentro.add(lbCep);
pnCentro.add(tfCep);
pnCentro.add(lbEmail);
pnCentro.add(tfEmail);
pnCentro.add(lbTelefone);
pnCentro.add(tfTelefone);
pnCentro.add(lbCelular);
pnCentro.add(tfCelular);
pnCentro.add(lbAtivo);
pnCentro.add(cbAtivo);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfNome.setEditable(false);
tfSenha.setEditable(false);
tfEndereco.setEditable(false);
tfBairro.setEditable(false);
tfCidade.setEditable(false);
tfCep.setEditable(false);
tfEmail.setEditable(false);
tfTelefone.setEditable(false);
tfCelular.setEditable(false);
cbAtivo.setEnabled(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfLogin.setBackground(Color.white);
jTextArea.setText("");
cliente = new Cliente();
String identificador = tfLogin.getText();
cliente.setLogin(identificador);
cliente = daoCliente.obter(cliente.getLogin());
if (cliente == null) {
pnNorte.setBackground(Color.red);
tfNome.setText("");
tfSenha.setText("");
tfEndereco.setText("");
tfBairro.setText("");
tfCidade.setText("");
tfCep.setText("");
tfEmail.setText("");
tfTelefone.setText("");
tfCelular.setText("");
cbAtivo.setSelected(false);
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
tfNome.setText(cliente.getNome());
tfSenha.setText(cliente.getSenha());
tfEndereco.setText(cliente.getEndereco());
tfBairro.setText(cliente.getBairro());
tfCidade.setText(cliente.getCidade());
tfCep.setText(cliente.getCep());
tfEmail.setText(cliente.getEmail());
tfTelefone.setText(cliente.getTelefone());
tfCelular.setText(cliente.getCelular());
cbAtivo.setSelected(Boolean.valueOf(cliente.getAtivo()));
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfLogin.setEditable(false);
tfNome.setEditable(false);
tfSenha.setEditable(false);
tfEndereco.setEditable(false);
tfBairro.setEditable(false);
tfCidade.setEditable(false);
tfCep.setEditable(false);
tfEmail.setEditable(false);
tfTelefone.setEditable(false);
tfCelular.setEditable(false);
cbAtivo.setEnabled(false);
tfLogin.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfLogin.requestFocus();
tfLogin.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfLogin.setEditable(false);
tfNome.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
cliente = new Cliente();
tfNome.setEditable(true);
tfSenha.setEditable(true);
tfEndereco.setEditable(true);
tfBairro.setEditable(true);
tfCidade.setEditable(true);
tfCep.setEditable(true);
tfEmail.setEditable(true);
tfTelefone.setEditable(true);
tfCelular.setEditable(true);
cbAtivo.setEnabled(true);
tfLogin.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
cliente = new Cliente();
cliente.setLogin(tfLogin.getText());
cliente.setNome(tfNome.getText());
cliente.setSenha(tfSenha.getText());
cliente.setEndereco(tfEndereco.getText());
cliente.setBairro(tfBairro.getText());
cliente.setCidade(tfCidade.getText());
cliente.setCep(tfCep.getText());
cliente.setEmail(tfEmail.getText());
cliente.setTelefone(tfTelefone.getText());
cliente.setCelular(tfCelular.getText());
cliente.setAtivo(cbAtivo.isSelected());
if (qualAcao.equals("incluir")) {
daoCliente.inserir(cliente);
} else {
daoCliente.atualizar(cliente);
}
tfLogin.setEditable(true);
tfLogin.requestFocus();
tfNome.setText("");
tfSenha.setText("");
tfEndereco.setText("");
tfBairro.setText("");
tfCidade.setText("");
tfCep.setText("");
tfEmail.setText("");
tfTelefone.setText("");
tfCelular.setText("");
cbAtivo.setSelected(false);
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfNome.setEditable(false);
tfSenha.setEditable(false);
tfEndereco.setEditable(false);
tfBairro.setEditable(false);
tfCidade.setEditable(false);
tfCep.setEditable(false);
tfEmail.setEditable(false);
tfTelefone.setEditable(false);
tfCelular.setEditable(false);
cbAtivo.setEnabled(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfLogin.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfNome.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfNome.setEditable(true);
tfSenha.setEditable(true);
tfEndereco.setEditable(true);
tfBairro.setEditable(true);
tfCidade.setEditable(true);
tfCep.setEditable(true);
tfEmail.setEditable(true);
tfTelefone.setEditable(true);
tfCelular.setEditable(true);
cbAtivo.setEnabled(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + cliente.getLogin() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoCliente.remover(cliente);
tfLogin.requestFocus();
tfNome.setText("");
tfSenha.setText("");
tfEndereco.setText("");
tfBairro.setText("");
tfCidade.setText("");
tfCep.setText("");
tfEmail.setText("");
tfTelefone.setText("");
tfCelular.setText("");
cbAtivo.setSelected(false);
tfLogin.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemCliente guiListagem = new GUIListagemCliente(daoCliente.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
tfLogin.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfLogin.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfLogin.requestFocus();tfLogin.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUICliente guiCliente = new GUICliente();
}
}
