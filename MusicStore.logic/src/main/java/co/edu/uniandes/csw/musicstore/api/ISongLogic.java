/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
import java.util.List;

/**
 *
 * @author je.barrera11
 */
public interface ISongLogic {

    public int countSongs();

    public List<SongDTO> getSongs(Integer page, Integer maxRecords);

    public SongDTO getSong(Long id);

    public SongDTO createSong(SongDTO dto);

    public SongDTO updateSong(SongDTO dto);

    public void deleteSong(Long id);

    public List<SongDTO> findByName(String name);

    public List<SongDTO> findByLongPlay(String longPlay);
}
