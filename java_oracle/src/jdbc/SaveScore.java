package jdbc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SaveScore extends JFrame {

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
	public SaveScore(ScoreMain parent) {// 부모창의 주소 전달
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 현재 프로그램 종료
		setBounds(10, -39, 344, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(68, 36, 57, 23);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(68, 69, 57, 23);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(68, 102, 57, 23);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(68, 135, 57, 23);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(68, 168, 57, 23);
		contentPane.add(lbl5);

		JButton btnSave = new JButton("저장");// 저장버튼 생성
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DAO 생성
				ScoreDAO dao = new ScoreDAO();
				// 텍스트필드.getText() : 텍스트필드에 입력한 값 가져오기
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				// Integer.valueOf(String) : 스트링값을 숫자로 변환
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());

				dao.insertScore(new ScoreDTO(student_no, name, kor, eng, mat));
				// showMessageDialog(화면, 메시지);
				JOptionPane.showMessageDialog(SaveScore.this, "추가되었습니다.");
				// 화면 새로고침
				parent.refreshTable();
				// 현재 창 종료(추가버튼 클릭 시 열렸던 창 종료)
				dispose();
			}
		});
		btnSave.setBounds(108, 211, 103, 29);
		contentPane.add(btnSave);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(154, 37, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(154, 70, 116, 21);
		contentPane.add(tfName);

		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(154, 102, 116, 21);
		contentPane.add(tfKor);

		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(154, 134, 116, 21);
		contentPane.add(tfEng);

		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(154, 167, 116, 21);
		contentPane.add(tfMat);
	}
}
