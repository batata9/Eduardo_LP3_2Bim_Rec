package GUIs;

import DAOs.DAOVeiculo;
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

public class GUIVeiculo extends JFrame {

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
    private JPanel pnCentro = new JPanel(new GridLayout(5, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdVeiculo = new JLabel("IdVeiculo");
    private JTextField tfIdVeiculo = new JTextField(10);
    private JLabel lbPrecoPorDia = new JLabel("PrecoPorDia");
    private JTextField tfPrecoPorDia = new JTextField(10);
    private JLabel lbPlacaVeiculo = new JLabel("PlacaVeiculo");
    private JTextField tfPlacaVeiculo = new JTextField(10);
    private JPanel pnMarcaIdMarca = new JPanel(new GridLayout(1, 2));
    private JLabel lbMarcaIdMarca = new JLabel("MarcaIdMarca");
    private JTextField tfMarcaIdMarca = new JTextField();
    private JButton btMarcaIdMarca = new JButton("Procurar");
    private JPanel pnCorIdCor = new JPanel(new GridLayout(1, 2));
    private JLabel lbCorIdCor = new JLabel("CorIdCor");
    private JTextField tfCorIdCor = new JTextField();
    private JButton btCorIdCor = new JButton("Procurar");
    private JPanel pnModeloIdModelo = new JPanel(new GridLayout(1, 2));
    private JLabel lbModeloIdModelo = new JLabel("ModeloIdModelo");
    private JTextField tfModeloIdModelo = new JTextField();
    private JButton btModeloIdModelo = new JButton("Procurar");
    JTextField tfCaminho = new JTextField();
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOVeiculo daoVeiculo = new DAOVeiculo();
    Veiculo veiculo;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
    private JPanel pnEsquerda = new JPanel(new BorderLayout());
    private JPanel pnDireita = new JPanel(new BorderLayout());
    private JLabel rotulo = new JLabel();
    private JButton btAbrirImagem = new JButton("Selecionar imagem");
    private String caminho;
    private Image imagemAux;
    private ImageIcon icone;

    public GUIVeiculo() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Veiculo");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new GridLayout(1, 2));
        cp.add(pnEsquerda);
        cp.add(pnDireita);
        try {
            String caminho = "";
            tfCaminho.setText(caminho);
            icone = new ImageIcon(getClass().getResource(caminho));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            rotulo.setIcon(icone);
        } catch (Exception err) {
            System.out.println("erro " + err.getLocalizedMessage());
        }
        pnDireita.add(pnE1, BorderLayout.NORTH);
        pnE1.add(rotulo);
        pnDireita.add(pnE2, BorderLayout.CENTER);
        pnE2.add(btAbrirImagem);
        pnDireita.add(pnE3, BorderLayout.SOUTH);
        pnE3.add(tfCaminho);
        pnEsquerda.add(pnNorte, BorderLayout.NORTH);
        pnEsquerda.add(pnCentro, BorderLayout.CENTER);
        pnEsquerda.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdVeiculo);
        pnNorte.add(tfIdVeiculo);
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
        btAbrirImagem.setEnabled(false);
        tfCaminho.setEditable(false);
        pnCentro.add(lbPrecoPorDia);
        pnCentro.add(tfPrecoPorDia);
        pnCentro.add(lbPlacaVeiculo);
        pnCentro.add(tfPlacaVeiculo);
        pnCentro.add(lbMarcaIdMarca);
        pnCentro.add(pnMarcaIdMarca);
        pnMarcaIdMarca.add(tfMarcaIdMarca);
        pnMarcaIdMarca.add(btMarcaIdMarca);
        pnCentro.add(lbCorIdCor);
        pnCentro.add(pnCorIdCor);
        pnCorIdCor.add(tfCorIdCor);
        pnCorIdCor.add(btCorIdCor);
        pnCentro.add(lbModeloIdModelo);
        pnCentro.add(pnModeloIdModelo);
        pnModeloIdModelo.add(tfModeloIdModelo);
        pnModeloIdModelo.add(btModeloIdModelo);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfCaminho.setEditable(false);
        tfPrecoPorDia.setEditable(false);
        tfPlacaVeiculo.setEditable(false);
        tfMarcaIdMarca.setEditable(false);
        btMarcaIdMarca.setEnabled(false);
        tfCorIdCor.setEditable(false);
        btCorIdCor.setEnabled(false);
        tfModeloIdModelo.setEditable(false);
        btModeloIdModelo.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdVeiculo.setBackground(Color.white);
                    jTextArea.setText("");
                    veiculo = new Veiculo();
                    int identificador = Integer.valueOf(tfIdVeiculo.getText());
                    veiculo.setIdVeiculo(identificador);
                    veiculo = daoVeiculo.obter(veiculo.getIdVeiculo());
                    if (veiculo == null) {
                        pnNorte.setBackground(Color.red);
                        tfCaminho.setText("");
                        tfPrecoPorDia.setText("");
                        tfPlacaVeiculo.setText("");
                        tfMarcaIdMarca.setText("");
                        tfCorIdCor.setText("");
                        tfModeloIdModelo.setText("");
                        tfCaminho.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        caminho = veiculo.getCaminho();
                        tfCaminho.setText(caminho);
                        icone = new ImageIcon(caminho);
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                        tfPrecoPorDia.setText(String.valueOf(veiculo.getPrecoPorDia()));
                        tfPlacaVeiculo.setText(veiculo.getPlacaVeiculo());
                        String dao1 = String.valueOf(veiculo.getMarcaIdMarca());
                        String[] aux1 = dao1.split("-");
                        tfMarcaIdMarca.setText(aux1[0]);
                        String dao2 = String.valueOf(veiculo.getCorIdCor());
                        String[] aux2 = dao2.split("-");
                        tfCorIdCor.setText(aux2[0]);
                        String dao3 = String.valueOf(veiculo.getModeloIdModelo());
                        String[] aux3 = dao3.split("-");
                        tfModeloIdModelo.setText(aux3[0]);
                        tfCaminho.setText(veiculo.getCaminho());
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    btAbrirImagem.setEnabled(false);
                    tfIdVeiculo.setEditable(false);
                    tfPrecoPorDia.setEditable(false);
                    tfPlacaVeiculo.setEditable(false);
                    btMarcaIdMarca.setEnabled(false);
                    btCorIdCor.setEnabled(false);
                    btModeloIdModelo.setEnabled(false);
                    tfIdVeiculo.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdVeiculo.requestFocus();
                    tfIdVeiculo.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdVeiculo.setEditable(false);
                tfPrecoPorDia.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                veiculo = new Veiculo();
                tfPrecoPorDia.setEditable(true);
                tfPlacaVeiculo.setEditable(true);
                btMarcaIdMarca.setEnabled(true);
                btCorIdCor.setEnabled(true);
                btModeloIdModelo.setEnabled(true);
                tfIdVeiculo.setEditable(false);
                btAbrirImagem.setEnabled(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    veiculo = new Veiculo();
                    veiculo.setIdVeiculo(Integer.valueOf(tfIdVeiculo.getText()));
                    veiculo.setPrecoPorDia(Double.valueOf(tfPrecoPorDia.getText()));
                    veiculo.setPlacaVeiculo(tfPlacaVeiculo.getText());
                    String[] aux0 = tfMarcaIdMarca.getText().split("-");
                    DAOMarca daoMarca = new DAOMarca();
                    Marca d0 = daoMarca.obter(Integer.valueOf(aux0[0]));
                    veiculo.setMarcaIdMarca(d0);
                    String[] aux1 = tfCorIdCor.getText().split("-");
                    DAOCor daoCor = new DAOCor();
                    Cor d1 = daoCor.obter(Integer.valueOf(aux1[0]));
                    veiculo.setCorIdCor(d1);
                    String[] aux2 = tfModeloIdModelo.getText().split("-");
                    DAOModelo daoModelo = new DAOModelo();
                    Modelo d2 = daoModelo.obter(Integer.valueOf(aux2[0]));
                    veiculo.setModeloIdModelo(d2);
                    veiculo.setCaminho(tfCaminho.getText());
                    caminho = tfCaminho.getText();
                    veiculo.setCaminho(caminho);
                    caminho = "";
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);
                    if (qualAcao.equals("incluir")) {
                        daoVeiculo.inserir(veiculo);
                    } else {
                        daoVeiculo.atualizar(veiculo);
                    }
                    tfIdVeiculo.setEditable(true);
                    tfIdVeiculo.requestFocus();
                    tfPrecoPorDia.setText("");
                    tfPlacaVeiculo.setText("");
                    tfMarcaIdMarca.setText("");
                    tfCorIdCor.setText("");
                    tfModeloIdModelo.setText("");
                    tfCaminho.setText("");
                    tfCaminho.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfPrecoPorDia.setEditable(false);
                    tfPlacaVeiculo.setEditable(false);
                    btMarcaIdMarca.setEnabled(false);
                    btCorIdCor.setEnabled(false);
                    btModeloIdModelo.setEnabled(false);
                    tfCaminho.setEditable(false);
                    btAbrirImagem.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdVeiculo.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btAbrirImagem.setEnabled(true);
                tfPrecoPorDia.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfPrecoPorDia.setEditable(true);
                tfPlacaVeiculo.setEditable(true);
                btMarcaIdMarca.setEnabled(true);
                btCorIdCor.setEnabled(true);
                btModeloIdModelo.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + veiculo.getIdVeiculo() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoVeiculo.remover(veiculo);
                    tfIdVeiculo.requestFocus();
                    tfPrecoPorDia.setText("");
                    tfPlacaVeiculo.setText("");
                    tfMarcaIdMarca.setText("");
                    tfCorIdCor.setText("");
                    tfModeloIdModelo.setText("");
                    tfCaminho.setText("");
                    String caminho = "";

                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);

                    tfCaminho.setText("");
                    tfIdVeiculo.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemVeiculo guiListagem = new GUIListagemVeiculo(daoVeiculo.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        btAbrirImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    String caminho = fc.getSelectedFile().getAbsolutePath();
                    try {
                        tfCaminho.setText(caminho);
                        icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            }
        });
        DAOMarca daoMarca = new DAOMarca();
        btMarcaIdMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoMarca.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfMarcaIdMarca.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        DAOCor daoCor = new DAOCor();
        btCorIdCor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoCor.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCorIdCor.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        DAOModelo daoModelo = new DAOModelo();
        btModeloIdModelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoModelo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfModeloIdModelo.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfIdVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoVeiculo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdVeiculo.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdVeiculo.requestFocus();
                        tfIdVeiculo.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIVeiculo guiVeiculo = new GUIVeiculo();
    }
}
