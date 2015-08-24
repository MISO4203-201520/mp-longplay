package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Provider.getByUserId", query = "select u from ProviderEntity u WHERE u.userId = :user_id")
})
public class ProviderEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Provider")
    private Long id;

    private String name;

    private String userId;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LongPlayEntity> longPlays;
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * @generated
     */
    public List<LongPlayEntity> getLongPlays() {
        return longPlays;
    }

    /**
     * @generated
     */
    public void setLongPlays(List<LongPlayEntity> longplays) {
        this.longPlays = longplays;
    }

}
