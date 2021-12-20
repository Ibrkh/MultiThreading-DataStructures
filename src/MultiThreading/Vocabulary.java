package MultiThreading;

public class Vocabulary 
{
	private String Word;
	private int Frequency;
	
	// Parameterized Constructor
	public Vocabulary(String word)
	{
		//System.out.println("Vocabulary " + word + " created");
		
		Word = word;
		Frequency = 1;
	}
	
	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public int getFrequency() throws VocabularyFrequencyNegativeException {
		
		// CustomException Thrown; Negative Frequency Value
		if(Frequency < 0)
			throw new VocabularyFrequencyNegativeException("Vocabulary Frequency is negative (-ve) #NegativeExceptionThrown");
		
		return Frequency;
	}

	public void setFrequency(int frequency) throws VocabularyFrequencyNegativeException {
		Frequency = frequency;
		
		// CustomException Thrown; Negative Frequency Value
		if(Frequency < 0)
			throw new VocabularyFrequencyNegativeException("Vocabulary Frequency is negative (-ve) #NegativeExceptionThrown");

	}

	public void increaseFrequency() throws VocabularyFrequencyNegativeException
	{
		Frequency++;
		
		// CustomException Thrown; Negative Frequency Value
		if(Frequency < 0)
			throw new VocabularyFrequencyNegativeException("Vocabulary Frequency is negative (-ve) #NegativeExceptionThrown");

	}
	
	// Display Function
	public void printVocabularyDetails() throws VocabularyFrequencyNegativeException
	{
		System.out.println("Matching Word: " + Word);
		System.out.println("Word Frequency: " + Frequency + "\n");

		// CustomException Thrown; Negative Frequency Value
		if(Frequency < 0)
			throw new VocabularyFrequencyNegativeException("Vocabulary Frequency is negative (-ve) #NegativeExceptionThrown");

	}
}
