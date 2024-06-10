package jdbc;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//swing → Java FX
public class ListEmp extends JFrame {// JFrame 상속받음

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;
	private EmpDAO empDao;
	private DeptDAO deptDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {// 프로그램의 시작
		EventQueue.invokeLater(new Runnable() {// 스레드 만들기
			public void run() {
				try {
					ListEmp frame = new ListEmp();// 메모리에 올라가고(인스턴스 생성), 생성자 호출
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
	public ListEmp() {// 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cboDept = new JComboBox();
		// 콤보박스.기능추가(실행코드)
		cboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 새로 선택
					// getSelectedItem() : 선택한아이템(내용)
					// getSelectedItem의 참조변수가 Object 여서 자료형 맞춤을 위해 toString
					String dname = cboDept.getSelectedItem().toString();
					// 실제 데이터 → Model → JTable
					DefaultTableModel model = new DefaultTableModel(empDao.listEmp(dname), cols);
					// 테이블.모델셋팅(모델명) → 화면반영
					table.setModel(model);
				}
			}
		});
		cboDept.setBounds(28, 21, 123, 29);
		contentPane.add(cboDept);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 61, 372, 177);
		contentPane.add(scrollPane);

		cols = new Vector();
		cols.add("사원번호");
		cols.add("사원이름");
		cols.add("직급");
		cols.add("입사일자");
		cols.add("급여");
		cols.add("소속부서");
		empDao = new EmpDAO();
		DefaultTableModel model = new DefaultTableModel(empDao.listEmp("%"), cols);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		deptDao = new DeptDAO();
		ArrayList<DeptDTO> deptList = deptDao.listDept();
		cboDept.addItem("전체부서");// '전체부서' 항목 추가
		for (DeptDTO dto : deptList) {
			cboDept.addItem(dto.getDname());
		}
	}// 생성자의 끝
}// 클래스의 끝
