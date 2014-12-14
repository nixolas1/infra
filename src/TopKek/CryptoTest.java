package TopKek;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
//import java.util.Random;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CryptoTest {
	
	public static void main(String[] args) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException, GeneralSecurityException{
		
		
		double kuk = 1.99999999999;
		int kek = (int)kuk;
		System.out.println(kuk);
		System.out.println(kek);
		System.out.println("kek"+ 4*10 +4);
		/*String lines = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
		
		System.out.print("Password: ");
		Scanner sc = new Scanner(System.in);
		String inn = sc.nextLine();
		//String inn = "kek";
		System.out.println(lines);
		Crypto crypt = new Crypto(inn, "Shhhh!! MuCH NSA must BE SECTRETORNMONOERN KLASUI GDas7das7kt6RDas57rjD iuYTSYU&ARDU(AS% (IASG KslSHf dkya g,UGSdo6asfio76GIOsdt7 ASFkd");
		
		//Crypto.shuffleArray(crypt.res, "L+eIHelDEZXwxvOYxyFEgQ");
		//System.out.println(crypt.res.toString());
		
		
		
		
		while(true){
			System.out.print("Encrypt/Decrypt: ");
			inn = sc.nextLine();
			if(inn.equalsIgnoreCase("exit"))break;
			if(inn.equals(""))inn = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			
			inn=crypt.unKek(inn);
			String dec = crypt.decrypt(inn);
			
			if(dec.equals("000")){
			//	System.out.print(lines);
				String encrypted = crypt.encrypt(inn);
				encrypted = crypt.kek(encrypted);//is broken!!!!!!!!!!!!!
				String dek = crypt.decrypt(crypt.unKek(encrypted));
				System.out.println(encrypted+"\n");
				System.out.println(dek);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(encrypted), null);
			}
			else{
				System.out.println(dec+"\n");
			}
		}
		sc.close();	*/
	}

}






 /*
				char[] enc = new String(encrypted).substring(0, dec.length).toCharArray();
				for(int i = 0; i<dec.length; i++){
					while(enc[i] != dec[i]){
						if(r.nextInt(2000/enc.length)==1){enc[i]=dec[i]; break;}
						else{enc[i]=(char)r.nextInt(160);}
						Thread.sleep(8);
						System.out.println(new String(enc));
					}
				}
				System.out.println(dec);*/

