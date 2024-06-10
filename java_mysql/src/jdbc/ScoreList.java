package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ScoreList extends JFrame {

	// 프로퍼티 변수
	private ScoreDAO dao;
	private Vector<String> cols;
	private DefaultTableModel model;
	private ScoreDTO dto;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JScrollPane scrollPane;
	private JButton btnSave;
	private JButton btnUpdate;
	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreList frame = new ScoreList();
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
	public ScoreList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 211, 400, 141);
		contentPane.add(scrollPane);

		dao = new ScoreDAO();
		cols = new Vector<String>();
		cols.add("학번");
		cols.add("이름");
		cols.add("국어");
		cols.add("영어");
		cols.add("수학");
		cols.add("총점");
		cols.add("평균");
		list();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfStudentNo.setEditable(false);
				tfStudentNo.setText(table.getValueAt(idx, 0) + "");
				tfName.setText(table.getValueAt(idx, 1) + "");
				tfKor.setText(table.getValueAt(idx, 2) + "");
				tfEng.setText(table.getValueAt(idx, 3) + "");
				tfMat.setText(table.getValueAt(idx, 4) + "");
			}
		});

		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(22, 13, 57, 15);
		contentPane.add(lblNewLabel);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(151, 10, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		JLabel label = new JLabel("이름");
		label.setBounds(22, 49, 57, 15);
		contentPane.add(label);

		tfName = new JTextField();
		tfName.setBounds(151, 46, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(22, 82, 57, 15);
		contentPane.add(label_1);

		tfKor = new JTextField();
		tfKor.setBounds(151, 79, 116, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(22, 117, 57, 15);
		contentPane.add(label_2);

		tfEng = new JTextField();
		tfEng.setBounds(151, 114, 116, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(22, 151, 57, 15);
		contentPane.add(label_3);

		tfMat = new JTextField();
		tfMat.setBounds(151, 148, 116, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insert_score(dto);
				if (result == 1) {// 레코드 저장이 성공했을 때
					JOptionPane.showMessageDialog(ScoreList.this, "저장되었습니다.");
					list();
					table.setModel(model);// 테이블.모델입력(모델), 화면 갱신
					clear();
				}
			}
		});
		btnSave.setBounds(303, 9, 97, 23);
		contentPane.add(btnSave);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.update_score(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(303, 45, 97, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 학번(키값) 가져오기
				String student_no = tfStudentNo.getText();
				int result = 0;
				// showConfirmDialog : 사용자의 확인을 받음
				int response = JOptionPane.showConfirmDialog(ScoreList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {// 예(삭제) 클릭 시 실행
					result = dao.delete_score(student_no);
				}
				if (result == 1) {
					JOptionPane.showMessageDialog(ScoreList.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnDelete.setBounds(303, 78, 97, 23);
		contentPane.add(btnDelete);

		JLabel lblNewLabel_1 = new JLabel("이름을 입력하세요");
		lblNewLabel_1.setBounds(22, 186, 117, 15);
		contentPane.add(lblNewLabel_1);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});

		tfSearch.setBounds(151, 180, 116, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(303, 178, 97, 23);
		contentPane.add(btnSearch);
	}

	public void search() {// '찾기' 버튼
		String name = tfSearch.getText();
		model = new DefaultTableModel(dao.search_score(name), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}

	public void input() {
		// 텍스트필드.getText() : 텍스트필드에 입력한 값 가져오기
		String student_no = tfStudentNo.getText();
		String name = tfName.getText();
		// Integer.parseInt : String 값을 정수로 변환
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		// 프로퍼티 변수에 값 저장
		dto = new ScoreDTO(student_no, name, kor, eng, mat);
	}

	public void clear() {
		// 텍스트필드 초기화
		tfStudentNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		// 커서를 이동시킴
		tfStudentNo.requestFocus();
		// 셀편집 가능(새로운 자료 넣기 위해)
		tfStudentNo.setEditable(true);
	}

	public void list() {// 모델을 갱신하는 함수
		// 테이블 → 테이블모델 → JTable
		model = new DefaultTableModel(dao.list_score(), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {// 셀편집 가능여부 함수
				return false;
			}
		};
	}
}