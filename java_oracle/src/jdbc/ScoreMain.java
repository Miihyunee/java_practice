package jdbc;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreMain extends JFrame {// JFrame 상속받음

	private static final long serialVersionUID = 1L;
	// 프로퍼티 변수
	private JPanel contentPane;
	private JTable table;
	private ScoreDAO dao;
	private Vector data, cols;
	private JButton btnAdd;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 현재 프레임
					ScoreMain frame = new ScoreMain();
					frame.setVisible(true);// 화면에 표시
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScoreMain() {// 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);// 절대좌표 레이아웃

		btnAdd = new JButton("추가");// 추가버튼 생성
		btnAdd.addActionListener(new ActionListener() {// 버튼.액션이벤트추가(동작)
			public void actionPerformed(ActionEvent e) {
				// 추가 폼 띄우기(현재 주소) : 화면 갱신을 위해 주소값이 필요
				// SaveScore : 입력 → 저장 → ScoreMain 화면 갱신 → 현재 창 닫힘
				SaveScore form = new SaveScore(ScoreMain.this);
				form.setVisible(true);
				form.setLocation(200, 200);
			}
		});
		btnAdd.setBounds(33, 12, 97, 35);
		contentPane.add(btnAdd);

		btnEdit = new JButton("수정/삭제");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// table.getSelectedRow() = JTable 선택된 행번호 인덱스
				int idx = table.getSelectedRow();
				if (idx == -1) {// 선택하지 않았을 때
					JOptionPane.showMessageDialog(ScoreMain.this, "편집할 레코드를 선택하세요.");
					return; // 함수 종료(void 일 때 return)
				}
				// table.getValueAt(행번호, 열번호)
				String student_no = String.valueOf(table.getValueAt(idx, 0));
				String name = String.valueOf(table.getValueAt(idx, 1));
				int kor = Integer.valueOf(table.getValueAt(idx, 2) + "");
				int eng = Integer.valueOf(table.getValueAt(idx, 3) + "");
				int mat = Integer.valueOf(table.getValueAt(idx, 4) + "");

				// DTO에 묶어서 보내기
				ScoreDTO dto = new ScoreDTO(student_no, name, kor, eng, mat);
				// (부모창의 주소, 전달할 값);
				EditScore form = new EditScore(ScoreMain.this, dto);
				form.setVisible(true);
			}
		});
		btnEdit.setBounds(148, 12, 97, 35);
		contentPane.add(btnEdit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 57, 368, 279);
		contentPane.add(scrollPane);

		// DAO의 인스턴스 생성
		dao = new ScoreDAO();// 참조변수 = 인스턴스 객체
		cols = new Vector();
		cols.add("학번");// 벡터참조변수.add → 벡터에 값 추가
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");

		table = new JTable();
		scrollPane.setViewportView(table);
		refreshTable();// 함수 호출(call)
	}

	public void refreshTable() {
		// Model : 데이터 변환시켜주는 역할, DefaultTableModel(데이터, 헤더)
		DefaultTableModel model = new DefaultTableModel(dao.listScore(), cols);
		table.setModel(model);// 테이블에 모델 셋팅 → 화면 반영
	}
}
