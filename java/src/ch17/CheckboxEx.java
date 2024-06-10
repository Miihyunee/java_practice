package ch17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckboxEx extends JFrame {// JFrame 상속받음

	private static final long serialVersionUID = 1L;// 클래스의 버전관리(실행에 영향없음)
	private JPanel contentPane;
	private JTextArea ta;// 필드변수(프로퍼티 변수)로 변경 //JTextArea: 여러줄 입력, JTextFiled: 한줄 입력

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckboxEx frame = new CheckboxEx();
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
	public CheckboxEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);// 메인페널 NORTH 영역에 패널을 추가하세요(체크박스 3개를 삽입하기 위해)

		JCheckBox ckJava = new JCheckBox("자바");
		ckJava.addItemListener(new ItemListener() {// 체크박스.아이템이벤트감시기능추가(아이템이벤트)
			public void itemStateChanged(ItemEvent e) {// 아이템의 상태가 변경될 떄, 체크박스 클릭 시 e 에 정보가 전달됨
				if (e.getStateChange() == ItemEvent.SELECTED) {// 선택되었을 때
					ta.append("Java를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {// 해제되었을 때
					ta.append("Java를 취소했습니다.\n"); // 텍스트영역.append(추가할 내용);,  텍스트영역.setText(변경할내용); - 기존내용 삭제,  텍스트영역.getText() → 내용
				}
			}
		});
		panel.add(ckJava);

		JCheckBox ckPython = new JCheckBox("파이썬");
		ckPython.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("Python을 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("Python을 취소했습니다.\n");
				}
			}
		});
		panel.add(ckPython);

		JCheckBox ckLinux = new JCheckBox("리눅스");
		ckLinux.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("Linux를 신청했습니다.\n");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("Linux를 취소했습니다.\n");
				}
			}
		});
		panel.add(ckLinux);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);

		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {// 버튼.액션이벤트
			public void actionPerformed(ActionEvent e) {// actionPerformed 버튼 클릭 시 실행되는 함수
				System.exit(0);// 프로그램 종료
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);// 패널 SOUTH 영역에 btnExit 버튼을 추가
	}

}
