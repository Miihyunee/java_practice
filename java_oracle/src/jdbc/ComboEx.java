package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComboEx extends JFrame {

	private static final long serialVersionUID = 1L;
	// 프로퍼티 변수
	private JPanel contentPane;
	private JComboBox combo;
	private JList list;
	private EmpDAO empDao;
	private DeptDAO deptDao;
	private ArrayList<DeptDTO> deptList;
	private ArrayList<EmpDTO> empList;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboEx frame = new ComboEx();
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
	public ComboEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		combo = new JComboBox();
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int idx = combo.getSelectedIndex();// 콤보박스.인덱스번호
					if (idx != -1) {// 아무것도 선택하지 않았을 때
						refreshList(idx);
					}
				}
			}
		});
		contentPane.add(combo, BorderLayout.NORTH);

		empDao = new EmpDAO();
		deptDao = new DeptDAO();
		deptList = deptDao.listDept();// 부서목록
		empList = empDao.listEmp(0);// 직원목록

		list = new JList();

		for (DeptDTO dto : deptList) {
			combo.addItem(dto.getDname());
		}
		refreshList(0);// 왜 값이 0이 들어가는지?
		contentPane.add(list, BorderLayout.CENTER);
	}

	void refreshList(int idx) {// 목록 새로고침(화면갱신)
		int deptno = deptList.get(idx).getDeptno();
		empList = empDao.listEmp(deptno);
		String[] names = new String[empList.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = empList.get(i).getEname();
		}
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String val : names) {
			model.addElement(val);
		}
		list.setModel(model);
	}
}
