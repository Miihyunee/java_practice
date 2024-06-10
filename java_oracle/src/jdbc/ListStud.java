package jdbc;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ListStud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;
	private MajorDAO majorDao;
	private StudDAO studDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListStud frame = new ListStud();
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
	public ListStud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cboBox = new JComboBox();
		cboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String mname = cboBox.getSelectedItem().toString();
					DefaultTableModel model = new DefaultTableModel(studDao.listStud(mname), cols);
					table.setModel(model);
				}
			}
		});
		cboBox.setBounds(30, 22, 124, 31);
		contentPane.add(cboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 67, 380, 172);
		contentPane.add(scrollPane);

		cols = new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("학년");
		cols.add("학과번호");
		cols.add("학과명");
		studDao = new StudDAO();
		DefaultTableModel model = new DefaultTableModel(studDao.listStud("%"), cols);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		majorDao = new MajorDAO();
		ArrayList<MajorDTO> majorList = majorDao.listMajor();
		cboBox.addItem("전체학과");
		for (MajorDTO dto : majorList) {
			cboBox.addItem(dto.getMname());
		}
	}
}
