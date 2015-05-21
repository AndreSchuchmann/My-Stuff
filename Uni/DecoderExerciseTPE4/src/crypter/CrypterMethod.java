package crypter;

/**
 * So, trying to build here two constructors for the CrypterMethod.. First of all i build the enum for
 * the 3 crypter variation. 
 * @author Andre
 *
 */

	
	public enum CrypterMethod{
		SUBSTITUTIONSCHIFFRE("SUBSTITUTIONSCHIFFRE", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26 , 26, "exactly 26"),
		CAESAR("CAESAR", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, 1, "exactly 1"),
		XOR("XOR", "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_","min 1");
		
		private final String name;
		private final String alphabet;
		private final int minimumKeyLength;
		private final int maximumKeyLength;
		private final String keyRange;
		
		//constructor for xor mofos .. length are useless here. Why? look at question
		
		private CrypterMethod(String name, String alphabet, String keyRange){
			this.name= name;
			this.alphabet = alphabet;
			this.keyRange = keyRange;
			minimumKeyLength = -1;
			maximumKeyLength = -1;
		}
		
		// building constructor for caesar and sub.. not sure if this is right? dunno..
		
		private CrypterMethod(String name , String alphabet , int minimumKeyLength , int maximumKeyLength ,String keyRange){
			this.name = name;
			this.alphabet = alphabet;
			this.minimumKeyLength = minimumKeyLength;
			this.maximumKeyLength = maximumKeyLength;
			this.keyRange = keyRange;
			
		}
		/*
		 * Jo getter und setter Methoden Bitches!
		 */

		public String getName() {
			return name;
		}

		public String getAlphabet() {
			return alphabet;
		}

		public int getMinimumKeyLength() {
			return minimumKeyLength;
		}

		public int getMaximumKeyLength() {
			return maximumKeyLength;
		}

		public String getKeyRange() {
			return keyRange;
		}
		
		
	}


