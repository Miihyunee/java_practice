package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JTableEx extends JFrame {

	private static final long serialVersionUID = 1L;// 코드의 버전관리
	private JPanel contentPane;
	private JTable table;
	private Vector data, cols;// 데이터, 헤더

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableEx frame = new JTableEx();
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
	public JTableEx() {// 생성자 호출
		cols = new Vector();// 헤더를 위한 행벡터 생성
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// DAO 생성
		ScoreDAO dao = new ScoreDAO();
		// DB → DAO → DefaultTableModel → JTable
		DefaultTableModel model = new DefaultTableModel(dao.list_score(), cols) {// (데이터, 헤더)
			@Override
			public boolean isCellEditable(int row, int column) {// 셀 편집 가능여부
				return false;// 편집 불가
				// return true;//편집 가능
			}
		};
		// Data → DefaultTableModel → JTable
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

}
