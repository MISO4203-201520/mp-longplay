package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.IProviderLogic;
import co.edu.uniandes.csw.musicstore.converters.ProviderConverter;
import co.edu.uniandes.csw.musicstore.dtos.ProviderDTO;
import co.edu.uniandes.csw.musicstore.entities.ProviderEntity;
import co.edu.uniandes.csw.musicstore.persistence.ProviderPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProviderLogic implements IProviderLogic {

    @Inject
    private ProviderPersistence persistence;

    /**
     * @generated
     */
    @Override
    public int countProviders() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<ProviderDTO> getProviders(Integer page, Integer maxRecords) {
        return ProviderConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public ProviderDTO getProvider(Long id) {
        return ProviderConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public ProviderDTO createProvider(ProviderDTO dto) {
        ProviderEntity entity = ProviderConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProviderConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public ProviderDTO updateProvider(ProviderDTO dto) {
        ProviderEntity entity = persistence.update(ProviderConverter.fullDTO2Entity(dto));
        return ProviderConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteProvider(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<ProviderDTO> findByName(String name) {
        return ProviderConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    @Override
    public ProviderDTO getArtistByUserId(String userId) {
        return ProviderConverter.refEntity2DTO(persistence.getProviderByUserId(userId));
    }
    
    @Override
    public List<ProviderDTO> getAllProviders() {
        return ProviderConverter.listEntity2DTO(persistence.findAll());
    }
}
