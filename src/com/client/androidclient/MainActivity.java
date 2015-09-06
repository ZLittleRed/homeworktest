package com.client.androidclient;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends Activity {
	    /** Called when the activity is first created. */  
	private EditText data_send;
	private Socket socket;
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.activity_main);  
	        data_send=(EditText) findViewById(R.id.data_send);
	        Button button = (Button) this.findViewById(R.id.send_button);  
	        System.out.println("�������ӡ�������");  
	        new Thread(new Runnable() {
			@Override
			@Test
			public void run() {
				// TODO Auto-generated method stub
			InetAddress serverAddr;
			try {
				serverAddr = InetAddress.getByName("192.168.43.209");
				socket = new Socket(serverAddr, 1234);
				System.out.println("���ӳɹ�����������������"); 
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}).start();
	        button.setOnClickListener(new OnClickListener() {  
	            @Override  
	            public void onClick(View v) {  
					    //IP��ַ�Ͷ˿ںţ���Ӧ����ˣ��������IP�Ǳ���·������IP��ַ  
					new Thread(new Runnable() {
						@Override
						@Test
						public void run() {
							// TODO Auto-generated method stub
							try {
					            //���͸�����˵���Ϣ  
					            String message = "����Ϣ�����ڰ�׿�ͻ���";  
					            System.out.println("��׿�ͻ��˷�����Ϣ: '" + data_send.getText().toString() + "'");  
					            //�ڶ�������ΪTrue��Ϊ�Զ�flush  
					            PrintWriter out = new PrintWriter(  
					                    new BufferedWriter(new OutputStreamWriter(  
					                            socket.getOutputStream(),"GBK")));  
					            out.println(data_send.getText().toString());  
					            out.flush();  
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						}
					}).start();  
	            }  
	        });  
	    }  
	}  