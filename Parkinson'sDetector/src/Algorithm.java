
public class Algorithm {
	private String text;

	private String[] words = {" ANYONE WHO FEELS THAT IF SO MANY MORE STUDENTS WHOM WE HAVEN’T ACTUALLY ADMITTED"
			, "ARE SITTING IN ON THE COURSE THAN ONES WE HAVE THAT THE ROOM HAD"
			, "TO BE CHANGED, THEN PROBABLY AUDITORS WILL HAVE TO BE EXCLUDED, IS LIKELY TO AGREE THAT THE"
			, "CURRICULUM NEEDS REVISION.", "A rough-coated, dough-faced, thoughtful ploughman strode through the "
			, " streets of Scarborough; after falling into a slough, he coughed and hiccoughed", 
			"This exceeding trifling witling, considering ranting criticizing concerning adopting fitting"
			, "wording being exhibiting transcending learning, was displaying, notwithstanding ridiculing"
			," surpassing boasting swelling reasoning, respecting correcting erring writing, and"
			,"touching detecting deceiving arguing during debating."};

	public Algorithm() {
		// TODO Auto-generated constructor stub
		for(int i =0; i < words.length; i++){
			words[i] = words[i].toLowerCase();
		}
	}

	public String wordsChosen() {
		// TODO Auto-generated method stub
		
		return (words[(int)(Math.random() * 10)/2] + words[(int)(Math.random() * 10)/2 + 5] + words[(int)(Math.random() * 10)/2] + words[(int)(Math.random() * 10)/2 + 5]).toLowerCase() ;
	}

	public String wrongWords() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getSpeed(String given, String typed, double time, double grossSpeed) {
		char[] g = given.toCharArray();
		char[] t= typed.toCharArray();
		int error = 0;
		if(g.length != t.length){
			return Math.abs(grossSpeed - (1.0 * (Math.abs(g.length - t.length))/5 / time));
		}
		else{
			for(int i =0 ;i < given.length(); i++){
				if(g[i] != t[i]){
					error ++;
				}
			}	
			return grossSpeed - (double)((double)error / time);
		}
		
	}
	
}
