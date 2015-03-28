package org.bme.etms.baseInfoM.view;

import java.util.List;

import javax.swing.JOptionPane;

import org.bme.base.model.PowerType;
import org.bme.etms.base.BaseBll;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Yhlxxxgl {

	protected Shell shell;
	private Text typename;
	private Text feestandard;
	private Table table;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE);
		shell.setSize(595, 255);
		shell.setText("用户类型信息管理");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(319, 39, 61, 15);
		label.setText("用户类型：");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(319, 76, 61, 15);
		label_1.setText("收费标准：");
		
		typename = new Text(shell, SWT.BORDER);
		typename.setBounds(386, 36, 112, 21);
		
		feestandard = new Text(shell, SWT.BORDER);
		feestandard.setBounds(386, 73, 112, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(508, 76, 61, 15);
		label_2.setText("元/度");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				typename.setText("");
				feestandard.setText("");
			}
		});
		btnNewButton.setBounds(332, 118, 80, 25);
		btnNewButton.setText("新增");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示");
					if(typename.getText().equals("")||feestandard.getText().equals("")){
						mb.setMessage("请填写用户类型及收费标准两项！");
						mb.open();
						return;
					}
					PowerType powertype=new PowerType();
					powertype.setTypename(typename.getText());
					powertype.setFeestandard(Double.parseDouble(feestandard.getText()));
					BaseBll basebill =new BaseBll();
					basebill.add(powertype);
					mb.setMessage("保存成功！");
					mb.open();
					table.removeAll();
					initTableItem();
				}catch(Exception e1){
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示");
					mb.setMessage("保存失败，请确保用电单位为数字");
					mb.open();
				}
			}
		});
		btnNewButton_1.setBounds(430, 118, 80, 25);
		btnNewButton_1.setText("保存");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				typename.setText("");
				feestandard.setText("");
			}
		});
		btnNewButton_2.setBounds(332, 151, 80, 25);
		btnNewButton_2.setText("重置");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row=table.getSelectionIndex();
				if(row==-1){
					JOptionPane.showMessageDialog(null, "请选择一条数据！");
					return;
				}
				TableItem item =table.getItem(row);
				Integer id=Integer.parseInt(item.getText());
				BaseBll basebll=new BaseBll();
				PowerType p=new PowerType();
				p.setId(id);
				basebll.delete(p);
				table.removeAll();
				initTableItem();
			}
		});
		btnNewButton_3.setBounds(430, 151, 80, 25);
		btnNewButton_3.setText("删除");
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row=table.getSelectionIndex();
				TableItem item =table.getItem(row);
				typename.setText(item.getText(1));
				feestandard.setText(item.getText(2));
				typename.setEnabled(true);
				feestandard.setEnabled(true);
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 22, 303, 165);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(54);
		tblclmnNewColumn.setText("编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(107);
		tblclmnNewColumn_1.setText("用户类型");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(98);
		tblclmnNewColumn_2.setText("收费标准");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(10, 7, 61, 15);
		label_3.setText("类型列表：");
		initTableItem();
	}
	//加载表格
	private void initTableItem(){
		List<PowerType> list = this.init();
		for (int i = 0; i < list.size(); i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[]{list.get(i).getId().toString(),list.get(i).getTypename(),list.get(i).getFeestandard().toString()});
		}
	}

	private List<PowerType> init() {
		BaseBll baseBll = new BaseBll();
		return baseBll.load("from PowerType");
	}
}
