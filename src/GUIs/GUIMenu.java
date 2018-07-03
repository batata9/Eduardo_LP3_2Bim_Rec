/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;

/**
 *
 * @author Sandro
 */
public class GUIMenu extends JFrame {

    //ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/icones/logo.png"));
    //JLabel logo = new JLabel(iconeLogo);
    public GUIMenu() {
        setTitle("Menu");
        Container cp = getContentPane();
        cp = getContentPane();
        //cp.add(logo);
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("Cliente");
        JMenu fileMenu2 = new JMenu("Veiculo");
        JMenu fileMenu3 = new JMenu("Aluguel");
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        menuBar.add(fileMenu3);

        // Cria e adiciona um item simples para o menu
        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem veiculo = new JMenuItem("GUIVeiculo");
        JMenuItem marca = new JMenuItem("GUIMarca");
        JMenuItem cor = new JMenuItem("GUICor");
        JMenuItem modelo = new JMenuItem("GUIModelo");
        JMenuItem aluguel = new JMenuItem("GUIAluguel");

        // Cria e aiciona um CheckButton como um item de menu
        // Cria e aiciona um RadioButton como um item de menu
        // Cria um ButtonGroup e adiciona os dois radio Button
        fileMenu.add(cliente);
        fileMenu2.add(veiculo);
        fileMenu2.addSeparator();
        fileMenu2.add(marca);
        fileMenu2.add(cor);
        fileMenu2.add(modelo);
        fileMenu3.add(aluguel);
        
        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUICliente guiCliente = new GUICliente();
            }
        });
        veiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIVeiculo guiVeiculo = new GUIVeiculo();
            }
        });
        marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIMarca guiMarca = new GUIMarca();
            }
        });
        cor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUICor guiCor = new GUICor();
            }
        });
        modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIModelo guiModelo = new GUIModelo();
            }
        });
        aluguel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIAluguel guiAluguel = new GUIAluguel();
            }
        });
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
