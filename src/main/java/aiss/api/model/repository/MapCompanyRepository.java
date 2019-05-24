package aiss.api.model.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import aiss.api.model.Company;
import aiss.api.model.VideoGame;


public class MapCompanyRepository implements CompanyRepository{

	Map<String, Company> CompanyMap;
	Map<String, VideoGame> VideoGameMap;
	private static MapCompanyRepository instance = null;
	private int index = 0;			// Index to create Companys and VideoGames' identifiers.
	
	
	public static MapCompanyRepository getInstance() {
		
		if (instance==null) {
			instance = new MapCompanyRepository();
			instance.init();
		}
		
		return instance;
	}
	
	//POPULA CON DATOS LAS ENTIDADES
	public void init() {
		
		CompanyMap = new HashMap<String,Company>();
		VideoGameMap = new HashMap<String,VideoGame>();
		
		// Create VideoGames
		VideoGame KH3 = new VideoGame();
		KH3.setTitulo("Kingdom Hearts 3");
		KH3.setGenero("Action RPG");
		KH3.setFechaLanzamiento(LocalDate.parse("2019-01-25"));
		KH3.setPlataforma("PS4,XBOX ONE");
		KH3.setCaratula("https://i11b.3djuegos.com/juegos/5911/kingdom_hearts_3/fotos/ficha/kingdom_hearts_3-4669949.jpg");
		addVideoGame(KH3);
		
		VideoGame dragonAgeOrigins = new VideoGame();
		dragonAgeOrigins.setTitulo("Dragon Age: Origins");
		dragonAgeOrigins.setGenero("Rol");
		dragonAgeOrigins.setFechaLanzamiento(LocalDate.parse("2009-11-20"));
		dragonAgeOrigins.setPlataforma("Windows,PS3,Xbox 360");
		dragonAgeOrigins.setCaratula("https://i11c.3djuegos.com/juegos/2045/dragon_age/fotos/ficha/dragon_age-1694542.jpg");
		addVideoGame(dragonAgeOrigins);
		
		VideoGame hp = new VideoGame();
		hp.setTitulo("Harry Potter y el prisionero de Azkaban");
		hp.setGenero("Accion Aventura");
		hp.setFechaLanzamiento(LocalDate.parse("2004-05-25"));
		hp.setPlataforma("PS2");
		hp.setCaratula("https://media.vandalimg.com/i/220x313/3165/harry-potter-y-el-prisionero-de-azkaban-201431914622_1.jpg");
		addVideoGame(hp);
		
		VideoGame ff7 = new VideoGame();
		ff7.setTitulo("Final Fantasy 7");
		ff7.setGenero("Rol");
		ff7.setPlataforma("PS1");
		ff7.setFechaLanzamiento(LocalDate.parse("1997-01-31"));
		ff7.setCaratula("https://media.vandalimg.com/i/220x218/1436/final-fantasy-vii-20161062139_1.jpg");
		addVideoGame(ff7);
		
		VideoGame dragonQuestVIII = new VideoGame();
		dragonQuestVIII.setTitulo("Dragon Quest VIII: El periplo del Rey Maldito");
		dragonQuestVIII.setGenero("Rol");
		dragonQuestVIII.setFechaLanzamiento(LocalDate.parse("2004-11-27"));
		dragonQuestVIII.setPlataforma("PS2");
		dragonQuestVIII.setCaratula("https://vignette.wikia.nocookie.net/dragonquest/images/f/f7/Dragon_Quest_VIII.jpg/revision/latest?cb=20160729171122&path-prefix=es");
		addVideoGame(dragonQuestVIII);
		
		// Create Companys
		Company squareEnix = new Company();
		squareEnix.setNombre("Square Enix");
		squareEnix.setFechaFormacion(LocalDate.parse("2003-04-01"));
		addCompany(squareEnix);
		
		Company EA = new Company();
		EA.setNombre("Electronic Arts");
		EA.setFechaFormacion(LocalDate.parse("1982-05-27"));
		addCompany(EA);
		
		// Add VideoGames to Companys
		addVideoGame(squareEnix.getId(), KH3.getId());
		addVideoGame(squareEnix.getId(), ff7.getId());
		addVideoGame(squareEnix.getId(), dragonQuestVIII.getId());
		
		addVideoGame(EA.getId(), dragonAgeOrigins.getId());
		addVideoGame(EA.getId(), hp.getId());
		
	}
	
	
	// Company related operations
	@Override
	public void addCompany(Company p) {
		String id = "p" + index++;	
		p.setId(id);
		CompanyMap.put(id,p);
	}
	
	@Override
	public Collection<Company> getAllCompanys() {
			return CompanyMap.values();
	}

	@Override
	public Company getCompany(String id) {
		return CompanyMap.get(id);
	}
	
	@Override
	public void updateCompany(Company p) {
		CompanyMap.put(p.getId(),p);
	}

	@Override
	public void deleteCompany(String id) {	
		CompanyMap.remove(id);
	}

	@Override
	public void addVideoGame(String CompanyId, String VideoGameId) {
		Company Company = getCompany(CompanyId);
		Company.addGame(VideoGameMap.get(VideoGameId));
	}

	@Override
	public Collection<VideoGame> getAll(String CompanyId) {
		return getCompany(CompanyId).getVideojuegos();
	}

	@Override
	public void removeVideoGame(String CompanyId, String VideoGameId) {
		getCompany(CompanyId).deleteGame(VideoGameId);
	}

	
	// VideoGame related operations
	
	@Override
	public void addVideoGame(VideoGame s) {
		String id = "s" + index++;
		s.setId(id);
		VideoGameMap.put(id, s);
	}
	
	@Override
	public Collection<VideoGame> getAllVideoGames() {
			return VideoGameMap.values();
	}

	@Override
	public VideoGame getVideoGame(String VideoGameId) {
		return VideoGameMap.get(VideoGameId);
	}

	@Override
	public void updateVideoGame(VideoGame s) {
		VideoGame VideoGame = VideoGameMap.get(s.getId());
		VideoGame.setTitulo(s.getTitulo());
		VideoGame.setPlataforma(s.getPlataforma());
		VideoGame.setGenero(s.getGenero());
		VideoGame.setFechaLanzamiento(s.getFechaLanzamiento());
	}

	@Override
	public void deleteVideoGame(String VideoGameId) {
		VideoGameMap.remove(VideoGameId);
	}
	
}
