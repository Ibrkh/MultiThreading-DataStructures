package MultiThreading;

// This is custom exception
@SuppressWarnings("serial")
public class VocabularyFrequencyNegativeException extends Exception
{
	public VocabularyFrequencyNegativeException(String message) {
		super(message);
	}

}
