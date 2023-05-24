package hexlet.code;

public class Cli {
	private String name;

	Cli (String name) {
		//this.name = name;
		this.name = nameСapitalization(name);
	}

	public String getName() {
		return name;
	}

	public static void greeting() {
		System.out.print("May I have your name? ");
	}

	private String nameСapitalization(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
	}
}
