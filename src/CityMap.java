import java.util.ArrayList;

/*
*	Clayton Salinger Ketner
*	February 11, 2014
*	CSCI 460 - Artificial Intelligence
*/

public class CityMap implements Debug
{
	private static ArrayList<City> listOfCities = new ArrayList<City>();

	/** Adds the city to the list of cities.
	*	@return True if city was added. False if city already exists. **/
	public static boolean addCity(String cityName)
	{
		if (getCity(cityName) == null) // If city doesn't exist already
		{
			listOfCities.add(new City(cityName));
			if (debug)
				System.err.println("Added " + cityName + ".");
			return true;
		}
		return false;
	}

	/** Looks up a city based on the name.
	*	@return The city object, if it exists, null if it doesn't. **/
	public static City getCity(String cityName)
	{
		for (City city : listOfCities)
		{
			if (city.name.equals(cityName))
				return city;
		}
		if (debug)
			System.err.println("City " + cityName + " not found in city map!");
		return null;
	}
	
	public static int getSize()
	{
		return listOfCities.size();
	}

	public static void initializeMap()
	{
		CityMap.addCity("Siwa");
		CityMap.addCity("Matruh");
		CityMap.addCity("Alexandria");
		CityMap.addCity("Cairo");
		CityMap.addCity("Asyut");
		CityMap.addCity("Nekhel");
		CityMap.addCity("Suez");
		CityMap.addCity("Quseir");
		CityMap.addCity("Sohag");
		CityMap.addCity("Qena");
		CityMap.addCity("Luxor");
		CityMap.addCity("Kharga");
		CityMap.addCity("Mut");
		CityMap.addCity("Qasr Farafra");
		CityMap.addCity("Bawiti");
		

		CityMap.getCity("Siwa").addNeighbors(			
						new String[]{"Matruh", 	"Bawiti"},
						new int[] 	{181, 		210});

		CityMap.getCity("Matruh").addNeighbors(			
						new String[]{"Alexandria",	"Siwa"},
						new int[] 	{159,			181});

		CityMap.getCity("Alexandria").addNeighbors(		
						new String[]{"Matruh",	"Cairo",	"Nekhel"},
						new int[] 	{159,		112,		245});
		
		CityMap.getCity("Cairo").addNeighbors(			
						new String[]{"Alexandria",	"Bawiti",	"Asyut"},
						new int[] 	{112,			186,		198});

		CityMap.getCity("Asyut").addNeighbors(			
						new String[]{"Cairo"},
						new int[] 	{198});

		CityMap.getCity("Nekhel").addNeighbors(			
						new String[]{"Alexandria",	"Suez",	"Quseir"},
						new int[] 	{245,			72,		265});

		CityMap.getCity("Suez").addNeighbors(			
						new String[]{"Nekhel"},
						new int[] 	{72});

		CityMap.getCity("Quseir").addNeighbors(			
						new String[]{"Nekhel",	"Sohag"},
						new int[] 	{265,		163});

		CityMap.getCity("Sohag").addNeighbors(			
						new String[]{"Quseir",	"Qena",	"Mut"},
						new int[] 	{163,		69,		184});

		CityMap.getCity("Qena").addNeighbors(			
						new String[]{"Sohag",	"Luxor"},
						new int[] 	{69,		33});

		CityMap.getCity("Luxor").addNeighbors(			
						new String[]{"Qena"},
						new int[] 	{33});

		CityMap.getCity("Kharga").addNeighbors(			
						new String[]{"Mut"},
						new int[] 	{98});

		CityMap.getCity("Mut").addNeighbors(			
						new String[]{"Qasr Farafra",	"Sohag",	"Kharga"},
						new int[] 	{126,				184,		98});

		CityMap.getCity("Qasr Farafra").addNeighbors(	
						new String[]{"Bawiti",	"Mut"},
						new int[] 	{104,		126});

		CityMap.getCity("Bawiti").addNeighbors(			
						new String[]{"Siwa",	"Cairo",	"Qasr Farafra"},
						new int[] 	{210,		186,		104});
	}
}