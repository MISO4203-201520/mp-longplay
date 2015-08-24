package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import java.util.List;

public interface ILongPlayLogic {
    public int countLongPlays();
    public List<LongPlayDTO> getLongPlays(Integer page, Integer maxRecords);
    public LongPlayDTO getLongPlay(Long id);
    public LongPlayDTO createLongPlay(LongPlayDTO dto);
    public LongPlayDTO updateLongPlay(LongPlayDTO dto);
    public void deleteLongPlay(Long id);
    public List<LongPlayDTO> findByName(String name);
}
