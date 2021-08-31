package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import PanelConFondo.Panel;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField fieldLU;
	private JTextField fieldApellido;
	private JTextField fieldNombre;
	private JTextField fieldEmail;
	private JTextField fieldGit;
	private JLabel lblImagen;
	private JLabel lblHoraFecha;

	public SimplePresentationScreen(Student studentData) {
		
		this.setBackground(new Color(200,10,100));
		setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new Panel("/images/6415e67f97a67952a4887dd765c23fc7.jpg");
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("ISOCPEUR", Font.BOLD, 16));
		tabbedPane.setForeground(new Color(139, 0, 0));
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(165, 42, 42));
		tabbedPane.setBounds(5, 5, 430, 205);
		tabInformation = new JPanel();
		tabInformation.setBackground(new Color(0, 0, 0));
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		
		fieldLU = new JTextField();
		fieldLU.setEditable(false);
		fieldLU.setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		fieldLU.setColumns(10);
		fieldLU.setText(String.valueOf(studentData.getId()));
		
		fieldApellido = new JTextField();
		fieldApellido.setEditable(false);
		fieldApellido.setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		fieldApellido.setColumns(10);
		fieldApellido.setText(studentData.getLastName());
		
		fieldNombre = new JTextField();
		fieldNombre.setEditable(false);
		fieldNombre.setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		fieldNombre.setColumns(10);
		fieldNombre.setText(studentData.getFirstName());
		
		fieldEmail = new JTextField();
		fieldEmail.setEditable(false);
		fieldEmail.setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		fieldEmail.setColumns(10);
		fieldEmail.setText(studentData.getMail());
		
		fieldGit = new JTextField();
		fieldGit.setEditable(false);
		fieldGit.setFont(new Font("ISOCPEUR", Font.BOLD, 18));
		fieldGit.setColumns(10);
		fieldGit.setText(studentData.getGithubURL());
		
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss"); // El formato es HH:mm:ss
		String horaActual = formateador.format(LocalDateTime.now());
		String dia = String.valueOf(LocalDate.now().getDayOfMonth());
		String mes = String.valueOf(LocalDate.now().getMonthValue());
		String anio = Integer.toString(LocalDate.now().getYear());
		
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setForeground(Color.WHITE);
		lblLU.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		
		JLabel lblLU_4 = new JLabel("Github URL");
		lblLU_4.setForeground(Color.WHITE);
		lblLU_4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		
		lblHoraFecha = new JLabel("La ventana se genero el dia "+dia+"/"+mes+"/"+anio +" a las"+horaActual);
		lblHoraFecha.setForeground(Color.RED);
		lblHoraFecha.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		lblHoraFecha.setEnabled(false);
		lblHoraFecha.setBackground(Color.WHITE);
		
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLU, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
						.addComponent(lblLU_4, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldGit, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldNombre, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldApellido, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldLU, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHoraFecha, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLU))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldApellido, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldNombre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldGit, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLU_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHoraFecha, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
		
		lblImagen = new JLabel("");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/Iara.jpeg")));
		lblImagen.setBounds(448, 38, 107, 129);
		lblImagen.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		contentPane.add(lblImagen);
	}
}
