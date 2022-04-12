package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	JComboBox cboProvedor;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarProducto();
			}
		});
		btnBuscar.setBounds(324, 43, 89, 23);
		contentPane.add(btnBuscar);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(235, 105, 90, 14);
		contentPane.add(lblProveedor);
		
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		cboProvedor = new JComboBox();
		cboProvedor.setBounds(310, 103, 86, 22);
		contentPane.add(cboProvedor);
		
		llenaCombo();
	}

	void llenaCombo() {

		//fabrica de acceso los datos
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		//manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		TypedQuery<Categorias> consulta=
				em.createQuery("Select u from Categorias u", Categorias.class);
		List<Categorias> lstCategorias = consulta.getResultList();
		
		cboCategorias.addItem("Seleccionar...");
		for (Categorias c : lstCategorias) {
			cboCategorias.addItem(c.getDescripcion());
		}
		
		// -- combo provedor---------------------------------------------------------
		TypedQuery<Proveedor> consulta2 =
				em.createQuery("Select u from Proveedor u", Proveedor.class);
		List<Proveedor> lstProveedor = consulta2.getResultList();
		
		cboProvedor.addItem("Seleccionar...");
		for (Proveedor c : lstProveedor) {
			cboProvedor.addItem(c.getNombre_rs());
		}
		
		//close
		em.close();
		
	}
	
	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		// -- combo categorias

		TypedQuery<Producto> consulta = 
				em.createQuery("select u from Producto u", Producto.class);
		List<Producto> lstProductos = consulta.getResultList();

		txtSalida.setText("");
		for (Producto p : lstProductos) {
			txtSalida.append("Código....: " + p.getIdproducto()+"\n");
			txtSalida.append("Nombre....: " + p.getDescripcion()+"\n");
			txtSalida.append("Precio....: " + p.getPrecio()+"\n");
			txtSalida.append("Categoría.: " + p.getIdcategoria()+"\n");
			txtSalida.append("Categoría.: " + p.getCategoria().getDescripcion()+"\n");
			txtSalida.append("Proveedor.: " + p.getIdprovedor()+"\n");
			txtSalida.append("Proveedor.: " + p.getProveedor().getNombre_rs()+"\n");
			txtSalida.append("****************************************\n");
	}
}
	
	void registrar() {
		
		String idprod= txtCódigo.getText();
		String descripcion = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio=Double.parseDouble(txtPrecio.getText());
		int categoria=cboCategorias.getSelectedIndex();
		int estado = 1;//valor por default
		int proveedor = cboProvedor.getSelectedIndex();
		
			Producto p = new Producto();
			p.setIdproducto(idprod);
			p.setDescripcion(descripcion);
			p.setStok(stock);
			p.setPrecio(precio);
			p.setIdcategoria(categoria);
			p.setEstado(estado);
			p.setIdprovedor(proveedor);
			
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			em.getTransaction().begin(); 
			em.persist(p);
			em.getTransaction().commit();
			
			em.close();
	}
	
	void buscarProducto() {
		
		EntityManagerFactory fabrica=new Persistence().createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		//si son consultas no va el begin
		//em.getTransaction().begin();
		
		
		//acciones
		Producto p = em.find(Producto.class, txtCódigo.getText());
		 									  //si existe el id devuelve dato
		 									  // si no devuelve null
		 if(p !=null) {
			 txtDescripcion.setText(p.getDescripcion());
		 }else {
			 System.out.println("No existeel código");
		 }

		
		//em.getTransaction().commit();
		em.close();
	}
}

