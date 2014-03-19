import java.util.HashMap;

/*
 *	Clayton Salinger Ketner
 *	February 27, 2014
 *	CSCI 460 -- Artificial Intelligence
 */

public class Heuristics
{
	private static HashMap<City, Integer> h1 = new HashMap<City, Integer>();
	private static HashMap<City, Integer> h2 = new HashMap<City, Integer>();

	public enum Heuristic
	{
		H1, H2
	}
	
	public static int h1(City city)
	{
		Integer result = h1.get(city);
		if (result == null)
		{
			return -1;
		}
		return result.intValue();
	}

	public static int h2(City city)
	{
		Integer result = h2.get(city);
		if (result == null)
		{
			return -1;
		}
		return result.intValue();
	}

	public static int getHeuristic(Heuristic heuristic, City city)
	{
		if (heuristic == Heuristic.H1)
		{
			return h1(city);
		}

		if (heuristic == Heuristic.H2)
		{
			return h2(city);
		}

		return -1;
	}

	public static void initialize()
	{
		// Heuristic 1
		h1.put(CityMap.getCity("Matruh"), 174);
		h1.put(CityMap.getCity("Cairo"), 126);
		h1.put(CityMap.getCity("Nekhel"), 133);
		h1.put(CityMap.getCity("Siwa"), 132);
		h1.put(CityMap.getCity("Bawiti"), 105);
		h1.put(CityMap.getCity("Asyut"), 52);
		h1.put(CityMap.getCity("Suez"), 121);
		h1.put(CityMap.getCity("Qasr Farafra"), 68);
		h1.put(CityMap.getCity("Quseir"), 55);
		h1.put(CityMap.getCity("Mut"), 51);
		h1.put(CityMap.getCity("Kharga"), 24);
		h1.put(CityMap.getCity("Sohag"), 27);
		h1.put(CityMap.getCity("Qena"), 10);
		
		// Heuristic 2
		h2.put(CityMap.getCity("Matruh"), 189);
		h2.put(CityMap.getCity("Cairo"), 139);
		h2.put(CityMap.getCity("Nekhel"), 145);
		h2.put(CityMap.getCity("Siwa"), 148);
		h2.put(CityMap.getCity("Bawiti"), 118);
		h2.put(CityMap.getCity("Asyut"), 67);
		h2.put(CityMap.getCity("Suez"), 136);
		h2.put(CityMap.getCity("Qasr Farafra"), 77);
		h2.put(CityMap.getCity("Quseir"), 59);
		h2.put(CityMap.getCity("Mut"), 65);
		h2.put(CityMap.getCity("Kharga"), 38);
		h2.put(CityMap.getCity("Sohag"), 36);
		h2.put(CityMap.getCity("Qena"), 19);
	}
}
