package org.bme.etms.dataQuery.view;

import java.util.Iterator;
import java.util.List;

import org.bme.etms.base.BaseBll;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class QueryFeeRecode {

	protected Shell shell;
	private Table table;
	private Text text;
	private DateTime dateTime;
	private DateTime dateTime_1;

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
		shell.setSize(800, 393);
		shell.setText("缴费历史记录查询");
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 34, 774, 319);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("序号");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnId = tableViewerColumn_1.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("用户ID");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn_2.getColumn();
		tableColumn.setWidth(100);
		tableColumn.setText("用户姓名");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_3.getColumn();
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("余额");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_4.getColumn();
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("缴费");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_3 = tableViewerColumn_5.getColumn();
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("操作员");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_6.getColumn();
		tableColumn_4.setWidth(150);
		tableColumn_4.setText("操作日期");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(77, 7, 103, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 61, 15);
		lblNewLabel.setText("用户姓名：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(212, 10, 36, 15);
		lblNewLabel_1.setText("日期：");
		
		dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(248, 4, 88, 24);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(342, 10, 21, 15);
		lblNewLabel_2.setText("至");
		
		dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(362, 7, 88, 24);
		dateTime.setMonth(dateTime_1.getMonth()-1);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StringBuilder hql = new StringBuilder("select " + 
															"b.id," + 
															"a.yhid," + 
															"a.yhxm," + 
															"b.balance," + 
															"b.fee," + 
															"b.operator," + 
															"b.operatordate " + 
													  "from UserInfo a," + 
															"FeelRecode b " + 
													  "where a.yhid=b.useid ");
				String yh = text.getText();
				if(yh != "")
				{
					hql.append("and ( a.yhxm like '%"+yh+"%' or a.yhid like '%"+yh+"%') ");
				}
				String date = String.valueOf(dateTime.getYear()) + "-" 
						+ String.valueOf(dateTime.getMonth()+1) + "-" 
						+ String.valueOf(dateTime.getDay()-1);
				String date1 = String.valueOf(dateTime_1.getYear()) + "-" 
								+ String.valueOf(dateTime_1.getMonth()+1) + "-" 
								+ String.valueOf(dateTime_1.getDay()+1);
				if(date != "" && date1 != ""){
					hql.append("and b.operatordate between '"+date+"' and '"+date1+"'");
				}
				
				BaseBll baseBll = new BaseBll();
				List list = baseBll.load(hql.toString());
				Iterator i = list.iterator();
				cleanTableItem();
				while (i.hasNext()) {
					Object[] obj = (Object[]) i.next();
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(new String[] {
							String.valueOf(obj[0] != null ? obj[0].toString() : ""),
							obj[1] != null ? obj[1].toString() : "",
							obj[2] != null ? obj[2].toString() : "",
							obj[3] != null ? "￥" + obj[3].toString() : "",
							obj[4] != null ? "￥" + obj[4].toString() : "",
							obj[5] != null ? obj[5].toString() : "",
							obj[6] != null ? obj[6].toString().substring(0,
									obj[6].toString().length() - 2) : "" });
				}
				
			}
		});
		btnNewButton.setBounds(464, 5, 80, 25);
		btnNewButton.setText("查询");
		
		initTableItem();
	}

	private void initTableItem() {
		List list = this.initUserInfo();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object[] obj = (Object[]) i.next();
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {
					String.valueOf(obj[0] != null ? obj[0].toString() : ""),
					obj[1] != null ? obj[1].toString() : "",
					obj[2] != null ? obj[2].toString() : "",
					obj[3] != null ? "￥" + obj[3].toString() : "",
					obj[4] != null ? "￥" + obj[4].toString() : "",
					obj[5] != null ? obj[5].toString() : "",
					obj[6] != null ? obj[6].toString().substring(0,
							obj[6].toString().length() - 2) : "" });
		}
	}

	private void cleanTableItem() {
		table.removeAll();
	}

	private List initUserInfo() {
		BaseBll baseBll = new BaseBll();
		return baseBll
				.load("select " + "b.id," + "a.yhid," + "a.yhxm,"
						+ "b.balance," + "b.fee," + "b.operator,"
						+ "b.operatordate " + "from UserInfo a,"
						+ "FeelRecode b " + "where a.yhid=b.useid");
	}
}
