package gestionparqueadero.vista;

import gestionparqueadero.controlador.VehiculoControlador;
import gestionparqueadero.modelo.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class VehiculoVista extends JFrame {

    private final VehiculoControlador controlador;

    private JTextField txtPlaca;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtColor;
    private JTextField txtIdCliente;
    private JComboBox<String> cbTipoVehiculo;

    private JButton btnGuardar;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private JTable tablaVehiculos;
    private DefaultTableModel modeloTabla;

    public VehiculoVista() {
        controlador = new VehiculoControlador();
        initComponents();
        cargarDatosTabla();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Gestión de Vehículos - Sistema Parqueadero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR: TÍTULO ---
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(41, 128, 185));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE PARQUEADERO - CRUD VEHÍCULOS");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // --- PANEL CENTRAL: FORMULARIO ---
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Placa
        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(new JLabel("Placa:"), gbc);
        gbc.gridx = 1;
        txtPlaca = new JTextField(12);
        panelFormulario.add(txtPlaca, gbc);

        // Marca
        gbc.gridx = 2; gbc.gridy = 0;
        panelFormulario.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 3;
        txtMarca = new JTextField(12);
        panelFormulario.add(txtMarca, gbc);

        // Modelo
        gbc.gridx = 0; gbc.gridy = 1;
        panelFormulario.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        txtModelo = new JTextField(12);
        panelFormulario.add(txtModelo, gbc);

        // Color
        gbc.gridx = 2; gbc.gridy = 1;
        panelFormulario.add(new JLabel("Color:"), gbc);
        gbc.gridx = 3;
        txtColor = new JTextField(12);
        panelFormulario.add(txtColor, gbc);

        // ID Cliente
        gbc.gridx = 0; gbc.gridy = 2;
        panelFormulario.add(new JLabel("ID Cliente:"), gbc);
        gbc.gridx = 1;
        txtIdCliente = new JTextField(12);
        txtIdCliente.setText("1"); // Valor por defecto
        panelFormulario.add(txtIdCliente, gbc);

        // Tipo Vehículo
        gbc.gridx = 2; gbc.gridy = 2;
        panelFormulario.add(new JLabel("Tipo Vehículo:"), gbc);
        gbc.gridx = 3;
        cbTipoVehiculo = new JComboBox<>(new String[]{"1 - Automóvil", "2 - Motocicleta", "3 - Camioneta"});
        panelFormulario.add(cbTipoVehiculo, gbc);

        // --- PANEL DE BOTONES ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(52, 152, 219));
        btnBuscar.setForeground(Color.WHITE);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(241, 196, 15));
        btnActualizar.setForeground(Color.BLACK);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(231, 76, 60));
        btnEliminar.setForeground(Color.WHITE);

        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 4;
        panelFormulario.add(panelBotones, gbc);

        // --- PANEL INFERIOR: TABLA DE DATOS ---
        String[] columnas = {"Placa", "Marca", "Modelo", "Color", "ID Cliente", "ID Tipo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVehiculos = new JTable(modeloTabla);
        tablaVehiculos.setRowHeight(22);
        JScrollPane scrollTabla = new JScrollPane(tablaVehiculos);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Vehículos Registrados"));

        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));
        panelCentro.add(panelFormulario, BorderLayout.NORTH);
        panelCentro.add(scrollTabla, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        // --- EVENTOS ---
        btnGuardar.addActionListener(e -> guardarVehiculo());
        btnBuscar.addActionListener(e -> buscarVehiculo());
        btnActualizar.addActionListener(e -> actualizarVehiculo());
        btnEliminar.addActionListener(e -> eliminarVehiculo());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        tablaVehiculos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaVehiculos.getSelectedRow();
                if (fila >= 0) {
                    txtPlaca.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtMarca.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtModelo.setText(modeloTabla.getValueAt(fila, 2).toString());
                    txtColor.setText(modeloTabla.getValueAt(fila, 3).toString());
                    txtIdCliente.setText(modeloTabla.getValueAt(fila, 4).toString());
                    int idTipo = Integer.parseInt(modeloTabla.getValueAt(fila, 5).toString());
                    cbTipoVehiculo.setSelectedIndex(idTipo - 1);
                }
            }
        });
    }

    private void cargarDatosTabla() {
        modeloTabla.setRowCount(0);
        List<Vehiculo> lista = controlador.listarVehiculos();
        for (Vehiculo v : lista) {
            Object[] fila = {
                    v.getPlaca(),
                    v.getMarca(),
                    v.getModelo(),
                    v.getColor(),
                    v.getIdCliente(),
                    v.getIdTipo()
            };
            modeloTabla.addRow(fila);
        }
    }

    private int obtenerIdTipoSeleccionado() {
        String item = (String) cbTipoVehiculo.getSelectedItem();
        if (item != null) {
            return Integer.parseInt(item.split(" - ")[0]);
        }
        return 1;
    }

    private void guardarVehiculo() {
        if (validarCampos()) {
            String placa = txtPlaca.getText().trim().toUpperCase();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String color = txtColor.getText().trim();
            int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
            int idTipo = obtenerIdTipoSeleccionado();

            if (controlador.registrarVehiculo(placa, marca, modelo, color, idCliente, idTipo)) {
                JOptionPane.showMessageDialog(this, "Vehículo registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar vehículo. Verifique que la placa no esté duplicada o que el ID Cliente exista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarVehiculo() {
        String placa = txtPlaca.getText().trim().toUpperCase();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una placa para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vehiculo v = controlador.buscarVehiculo(placa);
        if (v != null) {
            txtMarca.setText(v.getMarca());
            txtModelo.setText(v.getModelo());
            txtColor.setText(v.getColor());
            txtIdCliente.setText(String.valueOf(v.getIdCliente()));
            cbTipoVehiculo.setSelectedIndex(v.getIdTipo() - 1);
            JOptionPane.showMessageDialog(this, "Vehículo encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún vehículo con la placa: " + placa, "No Encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarVehiculo() {
        if (validarCampos()) {
            String placa = txtPlaca.getText().trim().toUpperCase();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String color = txtColor.getText().trim();
            int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
            int idTipo = obtenerIdTipoSeleccionado();

            if (controlador.actualizarVehiculo(placa, marca, modelo, color, idCliente, idTipo)) {
                JOptionPane.showMessageDialog(this, "Vehículo actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarVehiculo() {
        String placa = txtPlaca.getText().trim().toUpperCase();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione o ingrese una placa para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el vehículo con placa " + placa + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (controlador.eliminarVehiculo(placa)) {
                JOptionPane.showMessageDialog(this, "Vehículo eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtIdCliente.setText("1");
        cbTipoVehiculo.setSelectedIndex(0);
        tablaVehiculos.clearSelection();
    }

    private boolean validarCampos() {
        if (txtPlaca.getText().trim().isEmpty() ||
            txtMarca.getText().trim().isEmpty() ||
            txtModelo.getText().trim().isEmpty() ||
            txtColor.getText().trim().isEmpty() ||
            txtIdCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(txtIdCliente.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de Cliente debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        java.awt.EventQueue.invokeLater(() -> new VehiculoVista().setVisible(true));
    }
}
