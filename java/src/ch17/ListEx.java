package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf;
	private JList<String> list;
	private DefaultListModel<String> model;// 데이터처리를 대행

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
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
	public ListEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		tf = new JTextField();
		// 텍스트필드에서 Enter 쳤을 때 반영되도록
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
				list.setModel(model);
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(tf);
		tf.setColumns(10);

		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
				list.setModel(model);// 리스트에 모델을 셋팅하세요(모델정보), 화면에 반영됨
				tf.setText("");// 텍스트필드 교체
				tf.requestFocus();// 요청포커스(커서깜빡임): 입력 후에도 커서가 깜빡일 수 있도록
			}
		});
		panel.add(btnAdd);

		JButton btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();// 선택된 인덱스 가져오기
				if (selectedIndex != -1) {// 선택되었다면 (선택 안하면 -1)
					model.remove(selectedIndex);// 모델에서 제거(선택한 인덱스)
					list.setModel(model);// 리스트에 셋팅(모델) - 변경내용이 List에 반영됨
				}
			}
		});
		panel.add(btnDel);

		model = new DefaultListModel<>();// <> Generic(일반화) : 모든 자료형을 처리할 수 있음
		list = new JList<>();
		contentPane.add(list, BorderLayout.CENTER);
	}
}
