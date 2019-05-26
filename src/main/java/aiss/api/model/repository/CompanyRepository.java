package aiss.api.model.repository;

import java.util.Collection;

import aiss.api.model.Company;
import aiss.api.model.VideoGame;

public interface CompanyRepository {
	
	
	// VideoGames
	public void addVideoGame(VideoGame game);
	public Collection<VideoGame> getAllVideoGames();
	public VideoGame getVideoGame (String VideoGameId);
	public void updateVideoGame(VideoGame game);
	public void deleteVideoGame(String VideoGameId);
	
	// Companys
	public void addCompany(Company c);
	public Collection<Company> getAllCompanys();
	public Company getCompany(String CompanyId);
	public void updateCompany(Company c);
	public void deleteCompany(String CompanyId);
	public Collection<VideoGame> getAll(String CompanyId);
	public void addVideoGame(String CompanyId, String VideoGameId);
	public void removeVideoGame(String CompanyId, String VideoGameId); 

	
}
