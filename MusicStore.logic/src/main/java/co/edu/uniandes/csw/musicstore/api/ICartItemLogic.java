package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.CartItemDTO;
import java.util.List;

public interface ICartItemLogic {
    public int countCartItems();
    public List<CartItemDTO> getCartItems(Integer page, Integer maxRecords);
    public CartItemDTO getCartItem(Long id);
    public CartItemDTO createCartItem(CartItemDTO dto);
    public CartItemDTO updateCartItem(CartItemDTO dto);
    public void deleteCartItem(Long id);
    public List<CartItemDTO> findByName(String name);
}
