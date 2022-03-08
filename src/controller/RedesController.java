package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
	//Retorna o S.O.
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public String getOs() {	
		return os();
	}
	
	public void ip() {
		String os = getOs();
		String ip = "";
		String nomeAdaptador = "";
		if (os.contains("Windows")) {
			ip = "ipconfig";
		} else if (os == "Linux") {
			ip = "ifconfig";
		}
		try {
			Process p = Runtime.getRuntime().exec(ip);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {			
				linha = buffer.readLine();
				if (linha == null) {
					break;
				}
				if (linha.contains("Adaptador")) {
					nomeAdaptador = linha;
				}
				if (linha.contains("IPv4")) {
					System.out.println(nomeAdaptador);
					String[] string = linha.split(":");
					String numIp = string[1];
					System.out.println(numIp);
				}
			} 
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ping() {
		String os = getOs();
		String ping = "";
		if (os.contains("Windows")) {
			ping = "PING -4 -n 10 www.google.com.br";
		} else if (os == "Linux") {
			ping = "PING -4 -c 10 www.google.com.br";
		}
		try {
			Process p = Runtime.getRuntime().exec(ping);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
