package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import java.util.List;

public interface IAlbumLogic {
    public int countAlbums();
    public List<AlbumDTO> getAlbums(Integer page, Integer maxRecords);
    public AlbumDTO getAlbum(Long id);
    public AlbumDTO createAlbum(AlbumDTO dto);
    public AlbumDTO updateAlbum(AlbumDTO dto);
    public void deleteAlbum(Long id);
    public List<AlbumDTO> findByName(String name);
    public List<AlbumDTO> getTopSellerAlbums();
}
