package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Dados;
import controller.Funcoes;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_QuantidadeDeEntradas;
	private JTextField txt_EspacosNecessarios;
	private JTable tbl_NumerosTelefone;
	private JScrollPane sp_NumerosTelefone;
	private JButton btnCalcular;
	private JLabel lbl_EspacosNecessarios;
	private JLabel lbl_QuantidadeDeEntradas;
	private JButton btnOk;
	private DefaultTableModel modelo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_QuantidadeDeEntradas = new JTextField();
		txt_QuantidadeDeEntradas.setBounds(10, 11, 59, 20);
		contentPane.add(txt_QuantidadeDeEntradas);
		txt_QuantidadeDeEntradas.setColumns(10);
		
		lbl_QuantidadeDeEntradas = new JLabel("Quantidade de Entradas");
		lbl_QuantidadeDeEntradas.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lbl_QuantidadeDeEntradas.setBounds(79, 14, 127, 14);
		contentPane.add(lbl_QuantidadeDeEntradas);
		
		txt_EspacosNecessarios = new JTextField();
		txt_EspacosNecessarios.setEditable(false);
		txt_EspacosNecessarios.setEnabled(false);
		txt_EspacosNecessarios.setBounds(10, 120, 59, 20);
		contentPane.add(txt_EspacosNecessarios);
		txt_EspacosNecessarios.setColumns(10);
		
		lbl_EspacosNecessarios = new JLabel("Espa\u00E7os Necess\u00E1rios");
		lbl_EspacosNecessarios.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lbl_EspacosNecessarios.setBounds(79, 123, 107, 14);
		contentPane.add(lbl_EspacosNecessarios);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tbl_NumerosTelefone.isEditing()){
					tbl_NumerosTelefone.getCellEditor().stopCellEditing();
				}
				
				ArrayList<String> lista = new ArrayList<String>();
				Dados dados = new Dados();
				
				for(int cont=0; cont<tbl_NumerosTelefone.getRowCount(); cont++){
					dados.setNumeroTelefone(tbl_NumerosTelefone.getValueAt(cont, 0).toString());
					lista.add(dados.toString());
				}
				
				Funcoes f = new Funcoes();
				txt_EspacosNecessarios.setText(String.valueOf(f.retornoEspacosNecessarios(lista)));
			}
		});
		btnCalcular.setBounds(202, 119, 89, 23);
		contentPane.add(btnCalcular);
		
		sp_NumerosTelefone = new JScrollPane();
		sp_NumerosTelefone.setBounds(10, 42, 281, 67);
		contentPane.add(sp_NumerosTelefone);
		
		modelo = new DefaultTableModel();
		String header[] = new String[] { "Números" };
		modelo.setColumnIdentifiers(header);
		
		tbl_NumerosTelefone = new JTable(modelo);
		sp_NumerosTelefone.setViewportView(tbl_NumerosTelefone);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(202, 10, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = 0;
				int x = Integer.parseInt(txt_QuantidadeDeEntradas.getText().toString());
				int y = tbl_NumerosTelefone.getRowCount();
				int z = 0;
				final String[] novaLinha = { null };

				if(y<x){
					z = x - y;
					for(i=0; i<z; i++){
						modelo.addRow(novaLinha);
					}
				}
				
				else{
					for(i=y; i>x; i--){
						modelo.removeRow(i-1);
					}
				}
			}
		});
		contentPane.add(btnOk);
	}
}
