package TopKek;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import net.openvpn.jacs.SCrypt;



public class Crypto {
	
	private SecretKeyFactory factory;
	private KeySpec spec;
	final private SecretKey secret;
	final private String[] re={"tor", "tails","january","february","911","december","june","1100","square","department","of","homeland","security","dhs","fema","coast","guard","uscg","border","patrol","secret","service","usss","national","operations","center","noc","defense","ice","agent","task","force","central","intelligence","agency","cia","prism","fusion","drug","enforcement","dea","sbi","fbi","cis","fams","tsa","air","marshal","faa","red","cross","united","nations","un","assassination","attack","domestic","drill","exercise","cops","law","authorities","dndo","preparedness","response","recovery","dirty","bomb","nuclear","emergency","management","first","responder","initiative","militia","shooting","shots","fired","evacuation","deaths","hostage","explosion","explosive","police","team","dmat","organized","crime","gangs","state","breach","threat","standoff","swat","screening","lockdown","squad","or","crash","looting","riot","landing","pipe","incident","facility","hazmat","chemical","spill","suspicious","package","device","toxic","laboratory","cloud","plume","radiation","radioactive","leak","biological","infection","burn","epidemic","hazardous","industrial","powder","gas","spillover","anthrax","blister","exposure","nerve","ricin","sarin","north","korea","outbreak","contamination","virus","bacteria","recall","ebola","food","poisoning","fmd","h5n1","avian","flu","salmonella","small","pox","plague","human","to","animal","influenza","administration","fda","agro","terror","tuberculosis","listeria","symptoms","mutation","resistant","antiviral","wave","pandemic","water/air","borne","sick","the","be","and","a","in","have","it","i","that","for","you","he","with","on","do","say","this","they","at","but","we","his","from","not","by","she","as","what","go","their","can","who","get","if","would","her","all","my","make","about","know","will","up","one","time","there","year","so","think","when","which","them","some","me","people","take","out","into","just","see","him","your","come","could","now","than","like","other","how","then","its","our","two","more","these","want","way","look","also","new","because","day","use","no","man","find","here","thing","give","many","well","only","those","tell","very","even","back","any","good","woman","through","us","life","child","work","down","may","after","should","call","world","over","school","still","try","last","ask","need","too","feel","three","never","become","between","high","really","something","most","another","much","family","own","leave","put","old","while","mean","keep","student","why","let","great","same","big","group","begin","seem","country","help","talk","where","turn","problem","every","start","hand","might","american","show","part","against","place","such","again","few","case","week","company","system","each","right","program","hear","question","during","play","government","run","number","off","always","move","night","live","mr","point","believe","hold","today","bring","happen","next","without","before","large","million","must","home","under","water","room","write","mother","area","money","story","young","fact","month","different","lot","study","book","eye","job","word","though","business","issue","side","kind","four","head","far","black","long","both","little","house","yes","since","provide","around","friend","important","father","sit","away","until","power","hour","game","often","yet","line","political","end","among","ever","stand","bad","lose","however","member","pay","meet","car","city","almost","include","continue","set","later","community","name","five","once","white","least","president","learn","real","change","minute","best","several","idea","kid","body","information","nothing","ago","lead","social","understand","whether","watch","together","follow","parent","stop","face","anything","create","public","already","speak","others","read","level","allow","add","office","spend","door","health","person","art","sure","war","history","party","within","grow","result","open","morning","walk","reason","low","win","girl","guy","1984","active","aec","afsatcom","agcy","airforce","aldergrove","alert","algorithm","alpha","amu","anonymous","anti","area51","arpa","base","bi","bird","dog","blacklist","black-ops","blocks","bluebird","bnd","bronze","bugs","bunny","camouflage","capricorn","carbon","cbot","cdc","cell","chaining","classified","clearance","clone","code","cold","collat","compsec","conspiracy","control","counter","crypto","cypher","data","death","debugging","defcon","device","direct","dna","doa","dod","duplex","e-bomb","ebe","echo","ehf","electronic","encryption","energy","enigma","error","espionage","eternity","server","eurofed","factor","field","files","filter","firefly","foreign","fox","freq","g-man","gate","genetic","gp","ground","gray","groom","gsg-9","hackers","halcon","halo","hitword","humint","hyper","icbm","indigo","infosec","infowar","infrasound","insert","integrate","irbm","jason","jet","jpl","jupiter","key","lablink","ld","lethal","lf","liquid","lock","log","mailbomb","majic","mal","maple","maser","mass","mechanics","mercury","merlin","mev","mi","micro","mil","military","milsatcom","missile","mit","mj-12","mobile","mole","monitor","mosaic","nas","nasa","nato","navelexsyssecengcen","navwan","nevada","newton","noise","norad","nsa","nsc","objective","observe","oil","order","oss","overkill","password","patent","pentagon","perl-rsa","pgp","pi","pine","gap","ping","plutonium","privacy","proof","propaganda","propulsion","proton","psyops","quantum","r00t","radint","radio","record","register","remailer","retinal","roswell","rsa","rsp","sac","sam","sascom","satellite","scan","secdef","secops","secure","sequence","shape","shf","sig","sigdev","signature","sniper","sop","sp4","special","sphinx","spies","stanford","stealth","stp","strategic","supercomputer","supra","surveillance","branch","tactics","technology","ti","top","trace","transfer","transmit","trap","trinity","trojan","uhf","ultrasound","umbrella","undercover","unit","usaf","vaccine","vlf","warfare","wire","worm","xi","zero","zeta","zone"};
	
	public Crypto(String pass, String salt) throws UnsupportedEncodingException, GeneralSecurityException{
		removeCryptographyRestrictions();
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(pass.getBytes("UTF-8"));
		new SCrypt();
		byte[] sc = SCrypt.scryptJ(hash, salt.substring(salt.length()/2).getBytes("UTF-8"), 2048, 8, 15, 128);
		pass=new String(sc);
		factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); //change to SHA512
		spec = new PBEKeySpec(pass.toCharArray(), salt.getBytes("UTF-8"), 13337, 256);
		//spec = new PBEKeySpec((pass+new String(hash)).toCharArray(), salt.getBytes("UTF-8"), 13337, 256);
		SecretKey tmp = factory.generateSecret(spec);
	    secret = new SecretKeySpec(tmp.getEncoded(), "AES");
	   
	}
	
	public String encrypt(String txt) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidParameterSpecException, InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException{
		SecretKey tmp = factory.generateSecret(spec);
	    secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		AlgorithmParameters params = cipher.getParameters();
		
		byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
		byte[] ciphertext = cipher.doFinal(txt.getBytes("UTF-8"));
		
		return DatatypeConverter.printBase64Binary(ciphertext)+"*"+DatatypeConverter.printBase64Binary(iv);
	}
	
	public String kek(String txt){
		String[] w = txt.split("\\*");
		String iv = w[1].split("=")[0];
		return topKek(w[0], iv) + iv;
	}
	
	public String unKek(String txt){
		String[] words = txt.split(" ");
		String iv = words[words.length-1];
		List<String> res = Arrays.asList(re.clone());
		shuffleArray(res, iv);
		//System.out.println(res);
		int i = 0;
		byte[] bytes = new byte[words.length-1];
		
		for(String w : words){
			if(i==words.length-1 && i != 0){
				String ret = DatatypeConverter.printBase64Binary(bytes)+"*"+w+"==";
				return ret;
			}
			
			if(res.contains(w)){
				int idx = res.indexOf(w);
				int m=idx;
				try{
					bytes[i] = (byte) m;
				}catch(ArrayIndexOutOfBoundsException e){ return "000"; }
			}else{
				return "001";
			}
			i++;
		}
		
		return "002";
	}
	
	public String topKek(String txt, String rnd){
		
		List<String> res = Arrays.asList(re.clone());
		shuffleArray(res, rnd);
		//System.out.println(res);
		String out = "";
		byte[] bs = DatatypeConverter.parseBase64Binary(txt);
		for(int i = 0; i<bs.length; i++){
			int m = rnd.charAt(i%(rnd.length()-1));
			m = bs[i] & 0xff;
			if(m>=0 && m <res.size()){
				out+=res.get(m)+" ";
			}else{out+="***";}
		}
		return out;
	}
	
	public String decrypt(String encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] tIV;
		
		try{tIV = DatatypeConverter.parseBase64Binary(encrypted.split("\\*")[1]);}
		catch(ArrayIndexOutOfBoundsException e){return "000";}
		try{cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(tIV));}
		catch(InvalidAlgorithmParameterException e){ System.out.println();return "000";}
		
		String plaintext;
		try { plaintext = new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted.split("\\*")[0])), "UTF-8"); } 
		catch (BadPaddingException e) { return "** ENCRYPTED **";}
		
		return plaintext;
	}
	
	public void shuffleArray(List<String> ar, String ran)
	  {
		Long seed = 2L;
		int x = 1;
		
		for(int i : ran.toCharArray()){seed+=i*x; x*=10;}
		//System.out.println(seed + ran + ar);
	    Random rnd = new Random(seed);
	    for (int i = ar.size() - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      String a = ar.get(index);
	      ar.set(index, ar.get(i));
	      ar.set(i, a);
	    }
	 }

	
	private static void removeCryptographyRestrictions() {
	    if (!isRestrictedCryptography()) {
	        System.out.println("Cryptochecks not needed.");
	        return;
	    }
	    try {
	    	
	        final Class<?> jceSecurity = Class.forName("javax.crypto.JceSecurity");
	        final Class<?> cryptoPermissions = Class.forName("javax.crypto.CryptoPermissions");
	        final Class<?> cryptoAllPermission = Class.forName("javax.crypto.CryptoAllPermission");

	        final Field isRestrictedField = jceSecurity.getDeclaredField("isRestricted");
	        isRestrictedField.setAccessible(true);
	        isRestrictedField.set(null, false);

	        final Field defaultPolicyField = jceSecurity.getDeclaredField("defaultPolicy");
	        defaultPolicyField.setAccessible(true);
	        final PermissionCollection defaultPolicy = (PermissionCollection) defaultPolicyField.get(null);

	        final Field perms = cryptoPermissions.getDeclaredField("perms");
	        perms.setAccessible(true);
	        ((Map<?, ?>) perms.get(defaultPolicy)).clear();

	        final Field instance = cryptoAllPermission.getDeclaredField("INSTANCE");
	        instance.setAccessible(true);
	        defaultPolicy.add((Permission) instance.get(null));

	        //System.out.println("Restoring unlimited cryptography strength. Channel is secure.");
	    } catch (final Exception e) {
	        System.out.println("Failed to fix cryptorestrictions");
	    }
	}

	private static boolean isRestrictedCryptography() {
	    // This simply matches the Oracle JRE, but not OpenJDK.
	    return "Java(TM) SE Runtime Environment".equals(System.getProperty("java.runtime.name"));
	}
}
