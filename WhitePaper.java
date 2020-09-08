
public class WhitePaper {

	public static void main(String[] args) {
		String result;
		result = "The cat sat on the mat.".replaceAll("[Tt]he", "*");
		System.out.println(result);

		result = "The cat sat on the mat. he the she".replaceAll("[^Tt]he", "*");
		System.out.println(result);
	}
}
