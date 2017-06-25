package com.amilos;

import com.amilos.kerberos.DataResponse;
import com.amilos.kerberos.LogResponse;
import com.amilos.kerberos.Request;
import com.amilos.kerberos.UpdateResponse;
import com.amilos.services.CryptoServiceImpl;
import com.amilos.services.SerializationServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.util.Scanner;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		byte[] tgt = null;
		boolean flag = true;
		SerializationServiceImpl serializationService = null;
		CryptoServiceImpl cryptoService = null;
		String id = "";
		String password = "";
		Scanner sc = new Scanner(System.in);


		try {
			BASE64Encoder encoder = new BASE64Encoder();
			serializationService = new SerializationServiceImpl();
			cryptoService = new CryptoServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://localhost:8080/";
		byte[] rawResponse = null;
		byte[] decryptedResponse = null;

		while (flag) {

			while (flag) {
				try {
					System.out.println("Enter ID:");
					Long ID = Long.parseLong(sc.nextLine());
					System.out.println("Enter Password: ");
					String pass = sc.nextLine();
					id = "" + ID;
					password = new BASE64Encoder().encode(DigestUtils.sha256(pass));
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


			try {
				rawResponse = restTemplate.postForObject(uri + "login", Long.parseLong(id), byte[].class);
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
			try {
				decryptedResponse = cryptoService.decrypt(rawResponse,password);
				LogResponse logResponse = (LogResponse) serializationService.deserializeResponse(decryptedResponse);
				tgt = logResponse.getTgt();
				cryptoService.setKey(logResponse.getKey());
				cryptoService.setIv(logResponse.getIv());
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Request request = new Request();
		request.setID(new BASE64Encoder().encode(cryptoService.encrypt(id.getBytes())));
		request.setTgt(tgt);

		flag = true;
		while (flag){
			int option = 0;
			System.out.println("Choose option:\n1. Get Transaction Data\n2. Add Transaction\n3. Log out");
			option = sc.nextInt();
			sc.nextLine();
			if(option==1){
				try {
					rawResponse = restTemplate.postForObject(uri+"getData",request,byte[].class);
					decryptedResponse = cryptoService.decrypt(rawResponse);
					DataResponse dataResponse = (DataResponse) serializationService.deserializeResponse(decryptedResponse);
					System.out.println("Your tansacrions:");
					dataResponse.getTransactions().stream().forEach(System.out::println);
				}catch (Exception e){
					e.printStackTrace();
				}
			}else if(option == 2){
					try {
						System.out.println("Eneter transaction parameters(value_type): ");
						String data = sc.nextLine();
						if(data.length()>1){
							request.setData(new BASE64Encoder().encode(
									cryptoService.encrypt(data.getBytes())));
							rawResponse = restTemplate.postForObject(uri+"insert",request,byte[].class);
							decryptedResponse = cryptoService.decrypt(rawResponse);
							UpdateResponse updateResponse = (UpdateResponse) serializationService.deserializeResponse(decryptedResponse);
							System.out.print("Server Response: "+updateResponse.getStatus());
						}
					}catch (Exception e){
						e.printStackTrace();
					}
			}else if(option == 3) {
				break;
			}else {
				System.out.println("Wrong option!");
				continue;
			}
		}
	}
}
