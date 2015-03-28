package org.bme.etms.login.view;

import org.bme.etms.login.bll.LoginBLL;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class LoginFunction {

	protected Shell shell;
	private Text userName;
	private Text userPassword;
	private static String SUCCESS;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginFunction window = new LoginFunction();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		shell.setSize(377, 256);
		shell.setText("登陆");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(LoginFunction.class, "/org/bme/res/login.jpg"));
		composite.setBounds(0, 0, 371, 227);
		
		userName = new Text(composite, SWT.BORDER);
		userName.setBounds(238, 84, 103, 21);
		
		userPassword = new Text(composite, SWT.BORDER);
		userPassword.setBounds(238, 111, 103, 21);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoginBLL loginBLL = new LoginBLL();
				SUCCESS = loginBLL.getLoginInfo(userName.getText(),
						userPassword.getText());
				if (SUCCESS.equals("0")) {
					userName.setText("");
					userPassword.setText("");
					MessageBox mb = new MessageBox(shell,SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					mb.setText("提示！");
					mb.setMessage("账户不存在或密码错误，请重新输入！");
					mb.open();
					return;
				}
				else{
					shell.close();
					MainFunction main =new MainFunction();
					main.open();
				}
			}
		});
		btnNewButton.setBounds(188, 155, 65, 25);
		btnNewButton.setText("登陆");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(273, 155, 68, 25);
		btnNewButton_1.setText("取消");

	}
}
