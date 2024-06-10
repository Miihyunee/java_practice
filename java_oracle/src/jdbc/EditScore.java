package jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditScore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;

	/**
	 * Create the frame.
	 */
	public EditScore(ScoreMain parent, ScoreDTO dto) {// (부모창의 주소, 편집할 데이터)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 현재 프로그램 종료
		setBounds(100, 100, 358, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(46, 44, 57, 15);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(46, 83, 57, 15);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(46, 127, 57, 15);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(46, 171, 57, 15);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(46, 216, 57, 15);
		contentPane.add(lbl5);

		tfStudentNo = new JTextField();
		tfStudentNo.setEditable(false);
		tfStudentNo.setBounds(156, 41, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(156, 80, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfKor = new JTextField();
		tfKor.setBounds(156, 124, 116, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		tfEng = new JTextField();
		tfEng.setBounds(156, 168, 116, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		tfMat = new JTextField();
		tfMat.setBounds(156, 213, 116, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				dao.updateScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(EditScore.this, "수정되었습니다.");
				parent.refreshTable();
				dispose();

			}
		});
		btnUpdate.setBounds(53, 258, 97, 29);
		contentPane.add(btnUpdate);

		// 텍스트필드.setText(스트링);
		tfStudentNo.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
		// 숫자일 때 : 텍스트필드.setText(스트링 + "");
		tfKor.setText(dto.getKor() + "");
		tfEng.setText(dto.getEng() + "");
		tfMat.setText(dto.getMat() + "");

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// showConfirmDialog(표시할 화면, 메시지)
				int response = JOptionPane.showConfirmDialog(EditScore.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {// '예'를 클릭
					// 텍스트필드.getText() 텍스트필드 입력값 가져오기
					String student_no = tfStudentNo.getText();
					ScoreDAO dao = new ScoreDAO();
					dao.deleteScore(student_no);
					parent.refreshTable();
					JOptionPane.showMessageDialog(EditScore.this, "삭제되었습니다.");
					dispose();
				}
			}
		});
		btnDelete.setBounds(175, 258, 97, 29);
		contentPane.add(btnDelete);
	}

}
