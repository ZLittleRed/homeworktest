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
	        System.out.println("正在连接。。。。");  
	        new Thread(new Runnable() {
			@Override
			@Test
			public void run() {
				// TODO Auto-generated method stub
			InetAddress serverAddr;
			try {
				serverAddr = InetAddress.getByName("192.168.43.209");
				socket = new Socket(serverAddr, 1234);
				System.out.println("连接成功。。。。。。。。"); 
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
					    //IP地址和端口号（对应服务端），我这的IP是本地路由器的IP地址  
					new Thread(new Runnable() {
						@Override
						@Test
						public void run() {
							// TODO Auto-generated method stub
							try {
					            //发送给服务端的消息  
					            String message = "本消息来自于安卓客户端";  
					            System.out.println("安卓客户端发送消息: '" + data_send.getText().toString() + "'");  
					            //第二个参数为True则为自动flush  
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