package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.BtRDao;
import test.dto.BtRDto;

public class BtRFrame extends JFrame implements ActionListener{
	JTextField inputTitle, inputWriter;
	DefaultTableModel model;
	JTable table;
	
	public BtRFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		JLabel label2=new JLabel("책 제목");
		JLabel label3=new JLabel("저자");
		
		inputTitle = new JTextField(50);
		inputWriter = new JTextField(30);
		
		JButton addBtn=new JButton("추가");
		JButton deleteBtn=new JButton("삭제");
		
		JPanel panel=new JPanel();
		panel.add(label2);
		panel.add(inputTitle);
		panel.add(label3);
		panel.add(inputWriter);
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.setSize(1500,500);
		
		panel.setBackground(Color.orange);
		add(panel, BorderLayout.NORTH);
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		table =new JTable();
		String[] colNames= {"번호", "책 제목", "저자"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);
		
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);

		printBtR();
		
		table.getTableHeader().setFont(new Font("Sans-serif",Font.BOLD, 18));
		table.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		table.setRowHeight(25);
	}


	public static void main(String[] args) {
		BtRFrame f=new BtRFrame("읽을 책 목록");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(20,20, 1500, 1000);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			String title=inputTitle.getText();
			String writer=inputWriter.getText();
			BtRDto dto=new BtRDto();
			dto.setTitle(title);
			dto.setWriter(writer);
			BtRDao dao=new BtRDao();
			dao.insert(dto);
		}else if(command.equals("delete")) {
			int selectedRow=table.getSelectedRow();
			if(selectedRow==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요");
				return;
			}
			int num=(int)model.getValueAt(selectedRow, 0);
			new BtRDao().delete(num);
		}
		printBtR();
	}
	
	
	public void printBtR() {
		model.setRowCount(0);
		BtRDao dao= new BtRDao();
		List<BtRDto> list=dao.getList();
		for(BtRDto tmp:list) {
			Object[] rowData= {tmp.getNo(), tmp.getTitle(), tmp.getWriter()};
			model.addRow(rowData);
		}
		
	}
	
}
