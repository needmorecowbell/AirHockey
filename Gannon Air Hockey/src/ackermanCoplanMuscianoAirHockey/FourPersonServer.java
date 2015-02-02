package ackermanCoplanMuscianoAirHockey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FourPersonServer {

	private ServerSocket ss;
	private Socket clientSocket1, clientSocket2, clientSocket3;
	private PrintWriter pw1, pw2, pw3;
	private BufferedReader br1, br2, br3;
	private String name, name1, name2, name3;
	private final int TIMEOUT = 120 * 1000;
	
	
	public FourPersonServer(String name){
		this.name = name;
	}
	
	public void startServer(){
		try{
			ss = new ServerSocket(63400);
			ss.setSoTimeout(TIMEOUT);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void connect1(){
		try{
			clientSocket1 = ss.accept();
			br1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
			pw1 = new PrintWriter(clientSocket1.getOutputStream(), true);
			pw1.println(name);
			name1 = br1.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void connect2(){
		try{
			clientSocket2 = ss.accept();
			br2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
			pw2 = new PrintWriter(clientSocket2.getOutputStream(), true);
			pw2.println(name);
			name2 = br2.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void connect3(){
		try{
			clientSocket3 = ss.accept();
			br3 = new BufferedReader(new InputStreamReader(clientSocket3.getInputStream()));
			pw3 = new PrintWriter(clientSocket3.getOutputStream(), true);
			pw3.println(name);
			name3 = br3.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getUserName(){return name;}
	public String getOpponent1Name(){return name1;}
	public String getOpponent2Name(){return name2;}
	public String getOpponent3Name(){return name3;}
}
