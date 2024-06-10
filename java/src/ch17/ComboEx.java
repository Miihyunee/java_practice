package ch17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ta;// 필드변수로 이동

	/**
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
	public ComboEx() {// 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JComboBox cboTable = new JComboBox();
		cboTable.addItemListener(new ItemListener() {// 콤보박스.아이템이벤트감지기능 추가
			public void itemStateChanged(ItemEvent e) {// 값이 변경될 때ㄴ
				// 변경된상태값가져오기
				if (e.getStateChange() == ItemEvent.SELECTED) {// 선택되었을 때
					ta.setText("");// 기존텍스트 교체
					int table = cboTable.getSelectedIndex() + 2;
					for (int i = 1; i <= 9; i++) {
						ta.append(String.format("%2d x %2d = %2d\n", table, i, table * i));
					}
				}
			}
		});
		cboTable.setModel(new DefaultComboBoxModel(new String[] { "2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단" }));
		contentPane.add(cboTable, BorderLayout.NORTH);

		ta = new JTextArea();
		contentPane.add(ta, BorderLayout.CENTER);
	}

}
