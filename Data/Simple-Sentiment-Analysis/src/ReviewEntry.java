
//Calculates the sentiment of user-selected Rotten Tomatoes movie review using the aggregate numerical sentiment value of its content
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReviewEntry {

	static void CalcAverage(int sentenceID) throws ArithmeticException, IOException {

		int totalScore = 0;
		int numPhrases = 0;
		double avgScore = 0;
		int numWords = 0;
		String[] pullPhrase = null;
		String ovrlSentiment = "";
		boolean firstSentence = false;

		StringTokenizer sToken;
		BufferedReader TSVFile = new BufferedReader(
				new FileReader("tsv/movieReviews.tsv"));
		String dataRow = TSVFile.readLine(); // Read first line.
		List<String> dataArray = null;

		// Tokenizes string and substring values using tabular delimiter of TSV file
		while (dataRow != null) {
			sToken = new StringTokenizer(dataRow, "\t");
			dataArray = new ArrayList<>();
			while (sToken.hasMoreElements()) {
				dataArray.add(sToken.nextElement().toString());
			}

			// Adds all entries under user-specified sentenceID and counts phrases
			if (dataArray.get(1).equals(Integer.toString(sentenceID))) {
				totalScore += Integer.parseInt(dataArray.get(3));
				++numPhrases;
			}

			// Splits initial sentence at space delimiter and counts number of words
			// (punctuation-inclusive)
			if (dataArray.get(1).equals(Integer.toString(sentenceID)) && firstSentence != true) {
				pullPhrase = dataArray.get(2).split(" ");
				numWords = pullPhrase.length;
				firstSentence = true;
			}

			// Read next line of data.
			dataRow = TSVFile.readLine();

		}

		// Close the file once all data has been read.
		TSVFile.close();

		// Calculates average sentiment score
		avgScore = (double) totalScore / numPhrases;

		// Determines if review is positive, neutral, or negative
		if (avgScore >= 0 && avgScore <= 2) {
			ovrlSentiment = "negative";
		} else if (avgScore >= 2 && avgScore <= 3) {
			ovrlSentiment = "Neutral";
		} else if (avgScore >= 3 && avgScore <= 4) {
			ovrlSentiment = "positive";
		}

		// Prints statistics

		System.out.print("Sentence ID " + sentenceID + " has " + numPhrases + " phrases with an average rating of "
				+ String.format("%.2f", avgScore) + ". The overall sentiment is " + ovrlSentiment + ".");

	}

	public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);

		// Prompts user for sentenceID
		System.out.print("Enter a sentence ID: ");
		int sentenceID = scnr.nextInt();

		CalcAverage(sentenceID);

		scnr.close();
	}
}
