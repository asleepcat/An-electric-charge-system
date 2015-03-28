package org.bme.etms.baseInfoM.view;

import java.util.List;

import org.bme.base.model.LoginInfo;
import org.bme.etms.base.BaseBll;
import org.eclipse.jface.dialogs.MessageDialog;
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

public class Glyxxb {

	protected Shell shell;
	private Text text;
	private Table table;
	private Text text_1;

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
		shell.setSize(721, 231);
		shell.setText("操作员信息管理");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(444, 43, 79, 15);
		lblNewLabel.setText("登录用户名：");

		text = new Text(shell, SWT.BORDER);
		text.setEnabled(false);
		text.setBounds(529, 40, 166, 21);

		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row = table.getSelectionIndex();
				TableItem item = table.getItem(row);
				text.setText(item.getText(1));
				text_1.setText(item.getText(2));
				text.setEnabled(true);
				text_1.setEnabled(true);
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 10, 426, 177);

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("序号");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(150);
		tableColumn_1.setText("登录用户名");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(150);
		tableColumn_2.setText("登录密码");

		Label label = new Label(shell, SWT.NONE);
		label.setText("登录密码：");
		label.setBounds(444, 80, 79, 15);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setBounds(529, 77, 166, 21);

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text.setEnabled(true);
				text_1.setEnabled(true);
			}
		});
		button.setBounds(444, 127, 80, 25);
		button.setText("新增");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text.getText().equals("")||text_1.getText().equals("")){
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示！");
					mb.setMessage("请确保信息填写完整！");
					mb.open();
					return;
				}
				String username = text.getText();
				String password = text_1.getText();
				List<LoginInfo> list = this.queryUsername(username);
				BaseBll baseBll = new BaseBll();
				LoginInfo loginInfo = new LoginInfo();
				loginInfo.setUsername(username);
				loginInfo.setPassword(password);
				if (list.isEmpty()) {
					baseBll.add(loginInfo);
				} else {
					baseBll.update(loginInfo);
				}
				cleanTableItem();
				initTableItem();
			}
			
			private List<LoginInfo> queryUsername(String username) {
				BaseBll baseBll = new BaseBll();
				return baseBll.load("from LoginInfo where username = '"
						+ username + "'");
			}
		});
		button_1.setText("保存");
		button_1.setBounds(529, 127, 80, 25);

		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row = table.getSelectionIndex();
				if (row < 0) {
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示");
					mb.setMessage("请选中一条删除的数据！");
					mb.open();
				} else {
					TableItem item = table.getItem(row);
					String username = item.getText(1);
					LoginInfo loginInfo = new LoginInfo();
					loginInfo.setUsername(username);
					BaseBll baseBll = new BaseBll();
					baseBll.delete(loginInfo);
					cleanTableItem();
					initTableItem();
				}

			}
		});
		button_2.setText("删除");
		button_2.setBounds(615, 127, 80, 25);

		initTableItem();
	}

	private void initTableItem() {
		List<LoginInfo> list = this.initLoginInfo();
		for (int i = 0; i < list.size(); i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { String.valueOf(i + 1),
					list.get(i).getUsername(), list.get(i).getPassword() });
		}
	}

	private void cleanTableItem() {
		table.removeAll();
	}

	private List<LoginInfo> initLoginInfo() {
		BaseBll baseBll = new BaseBll();
		return baseBll.load("from LoginInfo");
	}

}
