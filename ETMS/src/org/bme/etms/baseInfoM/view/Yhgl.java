package org.bme.etms.baseInfoM.view;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.bme.base.model.GetData;
import org.bme.base.model.UserInfo;
import org.bme.etms.base.BaseBll;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


public class Yhgl {

	protected Shell shell;
	private Table table;
	private Text yhxm;
	private Text yhsfz;
	private Text yhdz;
	private Text yhdh;
	private Text email;
	private Text khyh;
	private Text yhzh;
	private Text qq;
	private Text cz;


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
		shell.setModified(true);
		shell.setTouchEnabled(true);
		shell.setSize(800, 616);
		shell.setText("用户信息管理");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 61, 15);
		label.setText("用户列表：");
		
		//combo
		final Combo yhlx = new Combo(shell, SWT.READ_ONLY);
		yhlx.setBounds(272, 392, 125, 23);
		BaseBll baseBll = new BaseBll();
		List list=baseBll.load("select id,typename from PowerType");
		Iterator i=list.iterator();
		int count =0;
		while(i.hasNext()){
			Object[] obj = (Object[]) i.next();
			yhlx.add(obj[1].toString());
			yhlx.setData(String.valueOf(count++),obj[0].toString());
		}
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row=table.getSelectionIndex();
				TableItem item =table.getItem(row);
				yhxm.setText(item.getText(1));
				yhsfz.setText(item.getText(2));
				yhdz.setText(item.getText(3));
				yhdh.setText(item.getText(4));
				qq.setText(item.getText(5));
				yhlx.setText(item.getText(6));
				cz.setText(item.getText(7));
				email.setText(item.getText(8));
				khyh.setText(item.getText(9));
				yhzh.setText(item.getText(10));
			}
		});
		table.setBounds(10, 31, 764, 221);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(60);
		tblclmnNewColumn.setText("用户编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(66);
		tblclmnNewColumn_1.setText("用户姓名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(103);
		tblclmnNewColumn_2.setText("身份证");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("用户地址");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(116);
		tblclmnNewColumn_4.setText("用户电话");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(94);
		tblclmnNewColumn_5.setText("QQ");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(70);
		tblclmnNewColumn_6.setText("用户类型");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(46);
		tblclmnNewColumn_7.setText("传真");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(76);
		tblclmnNewColumn_8.setText("E-mail");
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("开户银行");
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_10.setWidth(100);
		tblclmnNewColumn_10.setText("银行账号");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(205, 282, 61, 15);
		label_1.setText("用户姓名：");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(205, 315, 61, 15);
		label_2.setText("身份证：");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(205, 343, 61, 15);
		label_3.setText("用户地址");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(205, 369, 61, 15);
		label_4.setText("用户电话：");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(205, 395, 61, 15);
		label_5.setText("用户类型：");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(205, 422, 61, 15);
		lblEmail.setText("E-mail：");
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(205, 451, 61, 15);
		label_6.setText("开户银行：");
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(205, 478, 61, 15);
		label_7.setText("银行账号：");
		
		yhxm = new Text(shell, SWT.BORDER);
		yhxm.setBounds(272, 279, 168, 21);
		
		yhsfz = new Text(shell, SWT.BORDER);
		yhsfz.setBounds(272, 312, 295, 21);
		
		yhdz = new Text(shell, SWT.BORDER);
		yhdz.setBounds(272, 340, 295, 21);
		
		yhdh = new Text(shell, SWT.BORDER);
		yhdh.setBounds(272, 366, 125, 21);		
		
		email = new Text(shell, SWT.BORDER);
		email.setBounds(272, 419, 295, 21);
		
		khyh = new Text(shell, SWT.BORDER);
		khyh.setBounds(272, 448, 295, 21);
		
		yhzh = new Text(shell, SWT.BORDER);
		yhzh.setBounds(272, 475, 295, 21);
		
		Label lblQq = new Label(shell, SWT.NONE);
		lblQq.setBounds(403, 369, 37, 15);
		lblQq.setText("QQ：");
		
		qq = new Text(shell, SWT.BORDER);
		qq.setBounds(442, 366, 125, 21);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(403, 395, 37, 15);
		label_8.setText("传真：");
		
		cz = new Text(shell, SWT.BORDER);
		cz.setBounds(442, 392, 125, 21);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_9.setBounds(446, 282, 193, 15);
		label_9.setText("*用户身份证真实姓名");
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_10.setBounds(573, 315, 187, 15);
		label_10.setText("*第二代居民身份证");
		
		Label label_11 = new Label(shell, SWT.NONE);
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_11.setBounds(573, 343, 168, 15);
		label_11.setText("*家庭住址精确到街道");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//新增
				yhxm.setText("");
				yhsfz.setText("");
				yhdz.setText("");
				yhdh.setText("");
				email.setText("");
				khyh.setText("");
				yhzh.setText("");
				qq.setText("");
				cz.setText("");
				yhlx.setText("");
			}
		});
		button.setBounds(205, 527, 80, 25);
		button.setText("新增");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//保存
				if(	
				yhxm.getText().equals("")||
				yhsfz.getText().equals("")||
				yhdz.getText().equals("")||
				yhdh.getText().equals("")||
				khyh.getText().equals("")||
				yhzh.getText().equals("")||
				yhlx.getText().equals("")){
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
				mb.setText("提示");
				mb.setMessage("请检查信息是否填写完整！");
				mb.open();
				return;
				}
				UserInfo userinfo=new UserInfo();
				userinfo.setYhxm(yhxm.getText());
				userinfo.setYhsfz(yhsfz.getText());
				userinfo.setYhdz(yhdz.getText());
				userinfo.setYhdh(yhdh.getText());
				userinfo.setYhqq(qq.getText());
				userinfo.setYhemail(email.getText());
				userinfo.setYhcz(cz.getText());
				userinfo.setYhkhyh(khyh.getText());
				userinfo.setYhyhzh(yhzh.getText());
				userinfo.setYhye("0");
				Integer key = yhlx.getSelectionIndex();
				String value =(String) yhlx.getData(key.toString());
				if(value.equals("")){
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示");
					mb.setMessage("请重新选择用户类型，或者点击新增，编辑之后再保存！");
					mb.open();
					return;
				}
				userinfo.setPowertypeID(value);
				BaseBll basebill =new BaseBll();
				basebill.add(userinfo);
				GetData g=new GetData();
				g.setYhid(userinfo.getYhid());
				g.setCbrq(new Date());
				g.setCbdl((double) 0);
				g.setSfqy("是");
				basebill.add(g);
				MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
				mb.setText("提示");
				mb.setMessage("保存成功！");
				mb.open();
				table.removeAll();
				initTableItem();
			}
		});
		button_1.setBounds(304, 527, 80, 25);
		button_1.setText("保存");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				yhxm.setText("");
				yhsfz.setText("");
				yhdz.setText("");
				yhdh.setText("");
				email.setText("");
				khyh.setText("");
				yhzh.setText("");
				qq.setText("");
				cz.setText("");
				yhlx.setText("");
			}
		});
		button_2.setBounds(403, 527, 80, 25);
		button_2.setText("重置");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int row=table.getSelectionIndex();
				if(row==-1){
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示！");
					mb.setMessage("请选择一条数据！");
					mb.open();
					return;
				}
				TableItem item =table.getItem(row);
				Integer id=Integer.parseInt(item.getText());
				BaseBll basebll=new BaseBll();
				UserInfo p=new UserInfo();
				p.setYhid(id);
				basebll.delete(p);
				table.removeAll();
				initTableItem();
			}
		});
		button_3.setBounds(502, 527, 80, 25);
		button_3.setText("删除");
		
		Label lblqqemail = new Label(shell, SWT.NONE);
		lblqqemail.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblqqemail.setBounds(573, 369, 187, 15);
		lblqqemail.setText("*QQ，传真，E-mail非必填");
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
					obj[5] != null ? obj[5].toString() : "",
					obj[6] != null ? obj[6].toString() : "",
					obj[7] != null ? obj[7].toString() : "",
					obj[8] != null ? obj[8].toString() : "",
					obj[9] != null ? obj[9].toString() : "",
					obj[10] != null ? obj[10].toString() : "",
					});
		}
	}

//初始化用户查询
	private List initUserInfo() {
		BaseBll baseBll = new BaseBll();
		return baseBll.load("select "
									+ "a.yhid,"
									+ "a.yhxm,"
									+ "a.yhsfz,"
									+ "a.yhdz,"
									+ "a.yhdh,"
									+ "a.yhqq,"
									+ "b.typename,"
									+ "a.yhcz,"
									+ "a.yhemail,"
									+ "a.yhkhyh,"
									+ "a.yhyhzh "
							+ "from "
									+ "UserInfo a,"
									+ "PowerType b "
							+ "where "
									+ "a.powertypeID=b.id");
	}
}
