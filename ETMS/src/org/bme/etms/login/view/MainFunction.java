package org.bme.etms.login.view;

import org.bme.etms.baseInfoM.view.Glyxxb;
import org.bme.etms.baseInfoM.view.Yhgl;
import org.bme.etms.baseInfoM.view.Yhlxxxgl;
import org.bme.etms.chaobiao.view.ChaoBiao;
import org.bme.etms.dataQuery.view.QueryFeeRecode;
import org.bme.etms.dataQuery.view.QueryReadMeterRecode;
import org.bme.etms.userFeeM.view.Yhjf;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainFunction {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	/**
	 * Launch the application.
	 * @param args
	 */

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
		shell.setSize(732, 545);
		shell.setText("电费交费系统");
		shell.setLayout(null);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("基本信息管理");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem yhgl = new MenuItem(menu_1, SWT.NONE);
		yhgl.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/操作员管理.png"));
		yhgl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Yhgl yhglwindow=new Yhgl();
				yhglwindow.open();
			}
		});
		yhgl.setText("用户信息管理");
		
		MenuItem czyxxgl = new MenuItem(menu_1, SWT.NONE);
		czyxxgl.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/czy.png"));
		czyxxgl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Glyxxb czyglwindow =new Glyxxb();
				czyglwindow.open();
			}
		});
		czyxxgl.setText("操作员信息管理");
		
		MenuItem ydlxgl = new MenuItem(menu_1, SWT.NONE);
		ydlxgl.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/16.png"));
		ydlxgl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Yhlxxxgl sfbzwindow=new Yhlxxxgl();
				sfbzwindow.open();
			}
		});
		ydlxgl.setText("收费标准管理");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText("交费管理");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem mntmNewItem = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/money.png"));
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Yhjf jfwindow =new Yhjf();
				jfwindow.open();
			}
		});
		mntmNewItem.setText("用户缴费");
		
		MenuItem mntmNewSubmenu_2 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_2.setText("抄表管理");
		
		Menu menu_3 = new Menu(mntmNewSubmenu_2);
		mntmNewSubmenu_2.setMenu(menu_3);
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_3, SWT.NONE);
		mntmNewItem_1.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/513.png"));
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChaoBiao cb =new ChaoBiao();
				cb.open();
			}
		});
		mntmNewItem_1.setText("用户抄表");
		
		MenuItem mntmNewSubmenu_3 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_3.setText("基本信息查询");
		
		Menu menu_4 = new Menu(mntmNewSubmenu_3);
		mntmNewSubmenu_3.setMenu(menu_4);
		
		MenuItem mntmNewItem_2 = new MenuItem(menu_4, SWT.NONE);
		mntmNewItem_2.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/517.png"));
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				QueryFeeRecode feewindow =new QueryFeeRecode();
				feewindow.open();
			}
		});
		mntmNewItem_2.setText("缴费历史查询");
		
		MenuItem mntmNewItem_3 = new MenuItem(menu_4, SWT.NONE);
		mntmNewItem_3.setImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/520.png"));
		mntmNewItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				QueryReadMeterRecode Meterwindow=new QueryReadMeterRecode();
				Meterwindow.open();
			}
		});
		mntmNewItem_3.setText("抄表历史查询");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(MainFunction.class, "/org/bme/res/Main.jpg"));
		composite.setBounds(0, 0, 726, 496);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
	}
}
