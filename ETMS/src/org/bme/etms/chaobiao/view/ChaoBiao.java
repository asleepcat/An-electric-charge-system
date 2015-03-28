package org.bme.etms.chaobiao.view;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.bme.base.model.GetData;
import org.bme.etms.base.BaseBll;
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

public class ChaoBiao {

	protected Shell shell;
	private Table table;
	private Text yhxm;
	private Text yhye;
	private Text yhdh;
	private Text bccbdl;
	private Text cbrq;
	private Text cbdl;


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
		shell.setSize(657, 432);
		shell.setText("抄表信息登记");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row=table.getSelectionIndex();
				TableItem item =table.getItem(row);
				yhxm.setText(item.getText(1));
				yhye.setText(item.getText(2));
				yhdh.setText(item.getText(3));
				cbdl.setText(item.getText(4));
				cbrq.setText(item.getText(5));
			}
		});
		table.setBounds(10, 30, 621, 184);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(91);
		tblclmnNewColumn_5.setText("用户编号");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(66);
		tblclmnNewColumn.setText("姓名");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(67);
		tblclmnNewColumn_1.setText("余额");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("电话");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("上次电量");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(192);
		tblclmnNewColumn_4.setText("上次抄表日期");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 61, 15);
		label.setText("用户选择：");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("用户信息：");
		group.setBounds(10, 230, 272, 116);
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(10, 20, 61, 15);
		lblNewLabel.setText("姓名：");
		
		yhxm = new Text(group, SWT.READ_ONLY);
		yhxm.setBounds(77, 20, 106, 21);
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(10, 51, 61, 15);
		lblNewLabel_1.setText("用户余额：");
		
		yhye = new Text(group, SWT.READ_ONLY);
		yhye.setBounds(77, 48, 190, 21);
		
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setBounds(10, 82, 45, 15);
		lblNewLabel_2.setText("电话：");
		
		yhdh = new Text(group, SWT.READ_ONLY);
		yhdh.setBounds(77, 79, 190, 21);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setText("抄表信息登记：");
		group_1.setBounds(302, 230, 329, 116);
		
		Label lblNewLabel_3 = new Label(group_1, SWT.NONE);
		lblNewLabel_3.setLocation(10, 23);
		lblNewLabel_3.setSize(61, 15);
		lblNewLabel_3.setText("上次电量：");
		
		bccbdl = new Text(group_1, SWT.BORDER);
		bccbdl.setLocation(100, 85);
		bccbdl.setSize(219, 21);
		
		Label lblNewLabel_4 = new Label(group_1, SWT.NONE);
		lblNewLabel_4.setLocation(10, 56);
		lblNewLabel_4.setSize(84, 15);
		lblNewLabel_4.setText("上次抄表日期：");
		
		cbrq = new Text(group_1, SWT.READ_ONLY);
		cbrq.setLocation(101, 53);
		cbrq.setSize(218, 21);
		
		Label lblNewLabel_5 = new Label(group_1, SWT.NONE);
		lblNewLabel_5.setLocation(10, 88);
		lblNewLabel_5.setSize(84, 15);
		lblNewLabel_5.setText("本次抄表电量：");
		
		cbdl = new Text(group_1, SWT.READ_ONLY);
		cbdl.setLocation(101, 20);
		cbdl.setSize(218, 21);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
				try{
					int row = table.getSelectionIndex();
					if(bccbdl.getText().equals("")||row<0){
						mb.setText("提示");
						mb.setMessage("请选择一条数据，并填写本次抄表电量！");
						mb.open();
						return;
					}
					TableItem item =table.getItem(row);
					String yhid=item.getText(0);//用户ID
					//计算价格并扣除使用电量
					BaseBll b=new BaseBll();
					List l =b.load("select cbdl from GetData where yhid='"+yhid+"' and sfqy='是'");
					double scdl=(Double) l.get(0);//上次电量
					double dqdl=Double.parseDouble(bccbdl.getText());//当前电量
					if(dqdl<=scdl){
						mb.setText("提示");
						mb.setMessage("请确保当前电量大于上次电量！！");
						mb.open();
						return;
					}
					double cha=dqdl-scdl;
					List stand =b.load("select a.feestandard from PowerType a,UserInfo b where a.id=b.powertypeID and b.yhid='"+yhid+"'");
					double standard=Double.parseDouble(stand.get(0).toString());
					double ye=Double.parseDouble(yhye.getText())-cha*standard;
					String hql = "update UserInfo set yhye='"+ye+"' where yhid='"+yhid+"'";
					b.update(hql);
					//之前的记录更新为否
					if(!b.load("select gdid from GetData where yhid='"+yhid+"'").isEmpty()){
						b.update("update GetData set sfqy='否' where yhid='"+yhid+"'");
					}
					//新建抄表记录
					GetData g =new GetData();
					g.setYhid(Integer.parseInt(yhid));
					g.setCbrq(new Date());
					g.setSfqy("是");
					g.setCbdl(Double.parseDouble(bccbdl.getText()));
					b.add(g);
					mb.setText("提示");
					mb.setMessage("保存成功!");
					mb.open();
					yhye.setText(String.valueOf(ye));
					table.removeAll();
					initTableItem();
				}catch(Exception e1){
					mb.setText("提示");
					mb.setMessage("请确保信息填写正确，保证本次抄表电量为数字！");
					mb.open();
				}
			}
		});
		button.setBounds(379, 352, 80, 25);
		button.setText("确定");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				yhxm.setText("");
				yhye.setText("");
				yhdh.setText("");
				bccbdl.setText("");
				cbrq.setText("");
				cbdl.setText("");
			}
		});
		btnNewButton.setBounds(514, 352, 80, 25);
		btnNewButton.setText("重置");
		initTableItem();
	}	
	private void initTableItem() {
		List list = this.initUserInfo();
		int count = 0;
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object[] obj = (Object[]) i.next();
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {
					String.valueOf(obj[0] != null ? obj[0].toString() : ""),
					obj[1] != null ? obj[1].toString() : "",
					obj[2] != null ? obj[2].toString() : "",
					obj[3] != null ? obj[3].toString() : "",
					obj[4] != null ? obj[4].toString() : "",
					obj[5] != null ? obj[5].toString() : "" });
		}
	}

	private List initUserInfo() {
		BaseBll baseBll = new BaseBll();
		return baseBll.load("select a.yhid,a.yhxm,a.yhye,a.yhdh,b.cbdl,b.cbrq from UserInfo a,GetData b where a.yhid=b.yhid and b.sfqy='是'");
	}
}
