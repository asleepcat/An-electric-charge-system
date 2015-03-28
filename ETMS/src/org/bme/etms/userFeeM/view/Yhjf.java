package org.bme.etms.userFeeM.view;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bme.base.model.FeelRecode;
import org.bme.etms.base.BaseBll;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Yhjf {

	protected Shell shell;
	private Table table;
	private Text txtTHXM;
	private Text txtSFZ;
	private Text txtYHDZ;
	private Text textYHLX;
	private Text txtYE;
	private Text txtLXDH;
	private Text txtJFJE;
//	private Text txtCZR;
	private Text txtID;

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
		shell = new Shell();
		shell.setSize(830, 486);
		shell.setText("缴费管理");

		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row = table.getSelectionIndex();
				TableItem item = table.getItem(row);
				txtID.setText(item.getText(1));
				txtTHXM.setText(item.getText(2));
				textYHLX.setText(item.getText(3));
				txtLXDH.setText(item.getText(4));
				txtSFZ.setText(item.getText(5));
				txtYHDZ.setText(item.getText(6));
				txtYE.setText(item.getText(7));
				txtJFJE.setText("");
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 35, 794, 214);

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("序号");

		TableColumn tblclmnid = new TableColumn(table, SWT.NONE);
		tblclmnid.setWidth(100);
		tblclmnid.setText("用户ID");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("用户姓名");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("用户类型");

		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("联系电话");

		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("身份证");

		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("用户地址");

		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("余额");

		Group group = new Group(shell, SWT.NONE);
		group.setText("用户信息");
		group.setBounds(10, 255, 794, 83);

		txtYHDZ = new Text(group, SWT.BORDER);
		txtYHDZ.setEditable(false);
		txtYHDZ.setBounds(418, 54, 366, 21);

		Label label_1 = new Label(group, SWT.NONE);
		label_1.setBounds(351, 57, 61, 15);
		label_1.setText("用户地址：");

		Label label = new Label(group, SWT.NONE);
		label.setBounds(10, 57, 61, 15);
		label.setText("身份证：");

		txtSFZ = new Text(group, SWT.BORDER);
		txtSFZ.setEditable(false);
		txtSFZ.setBounds(77, 54, 268, 21);

		txtTHXM = new Text(group, SWT.BORDER);
		txtTHXM.setEditable(false);
		txtTHXM.setBounds(77, 22, 177, 21);

		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(10, 25, 61, 15);
		lblNewLabel.setText("用户姓名：");

		textYHLX = new Text(group, SWT.BORDER);
		textYHLX.setEditable(false);
		textYHLX.setBounds(363, 22, 136, 21);

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(296, 25, 61, 15);
		label_2.setText("用户类型：");

		Label label_5 = new Label(group, SWT.NONE);
		label_5.setText("联系电话：");
		label_5.setBounds(546, 25, 61, 15);

		txtLXDH = new Text(group, SWT.BORDER);
		txtLXDH.setEditable(false);
		txtLXDH.setBounds(613, 22, 171, 21);

		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setText("账户信息");
		group_1.setBounds(10, 344, 794, 59);

		Label label_3 = new Label(group_1, SWT.NONE);
		label_3.setBounds(10, 24, 36, 15);
		label_3.setText("余额：");

		txtYE = new Text(group_1, SWT.BORDER);
		txtYE.setEditable(false);
		txtYE.setBounds(50, 21, 91, 21);

		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setBounds(147, 24, 19, 15);
		label_4.setText("元");

		txtJFJE = new Text(group_1, SWT.BORDER);
		txtJFJE.setBounds(248, 21, 91, 21);

		Label label_6 = new Label(group_1, SWT.NONE);
		label_6.setText("缴费金额：");
		label_6.setBounds(182, 24, 60, 15);

		Label label_7 = new Label(group_1, SWT.NONE);
		label_7.setText("元");
		label_7.setBounds(345, 24, 19, 15);

		Button btnNewButton = new Button(group_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
				try{
					int row =table.getSelectionIndex();
					if(row<0||txtJFJE.getText().equals("")){
						mb.setText("提示");
						mb.setMessage("请选中一个用户,并填写缴费金额！");
						mb.open();
						return;
					}
					String useid = txtID.getText();
					String balance = txtYE.getText().substring(1, txtYE.getText().length());
					String fee = txtJFJE.getText();
//					String operator = txtCZR.getText();
					BaseBll baseBll = new BaseBll();
					FeelRecode feelRecode = new FeelRecode();
					feelRecode.setUseid(useid);
					feelRecode.setBalance(balance);
					feelRecode.setFee(fee);
//					feelRecode.setOperator(operator);
					feelRecode.setOperatordate(new Date());
					baseBll.add(feelRecode);
					String ye = String.valueOf((Double.parseDouble(fee)+Double.parseDouble(balance)));
					txtYE.setText("￥"+ye);
					String hql = "update UserInfo set yhye='"+ye+"' where yhid='"+useid+"'";
					baseBll.update(hql);
					cleanTableItem();
					initTableItem();
					txtJFJE.setText("");
					mb.setText("提示");
					mb.setMessage("用户交费成功！");
					mb.open();
				}catch(Exception e2){
					mb.setText("提示");
					mb.setMessage("请确保信息填写正确，缴费金额必须为数字！");
					mb.open();
				}
			}
		});
		btnNewButton.setBounds(474, 19, 80, 25);
		btnNewButton.setText("确定缴费");

		txtID = new Text(shell, SWT.BORDER);
		txtID.setVisible(false);
		txtID.setBounds(10, 416, 177, 21);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(10, 10, 61, 15);
		label_9.setText("用户列表：");
		initTableItem();
	}

	private void initTableItem() {
		List list = this.initUserInfo();
		int count = 0;
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object[] obj = (Object[]) i.next();
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { String.valueOf(count + 1),
					String.valueOf(obj[0] != null ? obj[0].toString() : ""),
					obj[1] != null ? obj[1].toString() : "",
					obj[2] != null ? obj[2].toString() : "",
					obj[3] != null ? obj[3].toString() : "",
					obj[4] != null ? obj[4].toString() : "",
					obj[5] != null ? obj[5].toString() : "",
					obj[6] != null ? "￥" + obj[6].toString() : "" });
		}
	}

	private void cleanTableItem() {
		table.removeAll();
	}

	private List initUserInfo() {
		BaseBll baseBll = new BaseBll();
		return baseBll.load("select " + "a.yhid," + "a.yhxm," + "b.typename,"
				 + "a.yhdh," + "a.yhsfz,"+ "a.yhdz," + "a.yhye "
				+ "from UserInfo a," + "PowerType b "
				+ "where a.powertypeID=b.id");
	}
}
